package com.songofmortality;

import com.google.common.annotations.VisibleForTesting;
import com.google.gson.Gson;
import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.ComponentID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.callback.Hooks;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ClientShutdown;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;

@Slf4j
@PluginDescriptor(
	name = "Song of Mortality"
)
public class SongOfMortalityPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private SongOfMortalityConfig config;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ConfigManager configManager;

	@Inject
	private Gson gson;

	@Inject
	private Hooks hooks;

	private final Hooks.RenderableDrawListener drawListener = this::shouldDraw;

	private HashSet<String> killedSet = new HashSet<>();
	private HashMap<Integer, String> tempMap = new HashMap<>();
	private boolean isInInstance = false;
	private boolean wasInInstance = false;

	private enum God {Armadyl, Bandos, Saradomin, Zamorak, Zaros}

	@Getter
	@AllArgsConstructor
	private enum CombatAchievements
	{
		GRANDMASTER(Varbits.COMBAT_ACHIEVEMENT_TIER_GRANDMASTER, 15),
		MASTER(Varbits.COMBAT_ACHIEVEMENT_TIER_MASTER, 25),
		ELITE(Varbits.COMBAT_ACHIEVEMENT_TIER_ELITE, 30),
		HARD(Varbits.COMBAT_ACHIEVEMENT_TIER_HARD, 35),
		DEFAULT(-1, 40);

		private final int combatAchievementVarbitId;
		private final int kcRequired;
	}

	@Provides
	SongOfMortalityConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SongOfMortalityConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getKey().equals("deleteSave") && config.deleteSavedData())
		{
			killedSet.clear();
			tempMap.clear();
			SaveFileManager.DeleteData();
		}
	}

	@Override
	protected void startUp()
	{
		hooks.registerRenderableDrawListener(drawListener);
		SaveFileManager.Init(gson, configManager);
		killedSet = SaveFileManager.Load();
	}

	@Override
	protected void shutDown()
	{
		hooks.unregisterRenderableDrawListener(drawListener);
		SaveFileManager.Save(killedSet);
	}

	@Subscribe(priority = 101)
	protected void onClientShutdown(ClientShutdown e)
	{
		SaveFileManager.Save(killedSet);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN && killedSet.isEmpty() == false)
		{
			SaveFileManager.Save(killedSet);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		Player localPlayer = client.getLocalPlayer();
		if (localPlayer.isInteracting() == false) return;
		Actor temp = localPlayer.getInteracting();
		if (temp.isDead() == false || temp instanceof NPC == false) return;
		NPC npc = (NPC)temp;

		// Exception for Inferno + Fight cave instances
		wasInInstance = isInInstance;
		if (ProcessInstanceKill(npc)) return;
		if (AddKilledInstancesOnInstanceLeave()) return;

		// GWD exception
		if (client.getWidget(ComponentID.GWD_KC_LAYER) != null)
		{
		 	if (tempMap.containsKey(npc.getName()) == false)
			{
				tempMap.put(npc.getId(), npc.getName());
				TryDumpGodWarsMinions();
			}
		}
		else
		{
			AddToKillSet(npc);
		}
	}

	@VisibleForTesting
	boolean shouldDraw(Renderable renderable, boolean drawingUI)
	{
		if (renderable instanceof NPC)
		{
			NPC actor = (NPC) renderable;
			return !(killedSet.contains(actor.getName()) && actor.getCombatLevel() > 0);
		}
		return true;
	}

	boolean AtRequiredKC(God god)
	{
		int id = 0;
		switch (god)
		{
			case Armadyl:
				id = 3973;
			case Bandos:
				id = 3975;
			case Saradomin:
				id = 3972;
			case Zamorak:
				id = 3976;
			case Zaros:
				id = 13080;
		}

		if (id == 0) return false;
		int currentKC = client.getVarbitValue(id);
		return currentKC >= getRequiredKc();
	}

	// From BetterGodwarsOverlay: https://github.com/abd-khrubi/better-godwars-overlay/tree/master
	public int getRequiredKc() {
		for (CombatAchievements required : CombatAchievements.values()) {
			if (required == CombatAchievements.DEFAULT) break;

			boolean completedCa = client.getVarbitValue(required.getCombatAchievementVarbitId()) == 2;
			if (completedCa) {
				return required.getKcRequired();
			}
		}
		return CombatAchievements.DEFAULT.getKcRequired();
	}

	private boolean ProcessInstanceKill(NPC npc)
	{
		isInInstance = false;
		// Fight Caves and inferno
		if (ArrayUtils.contains(client.getMapRegions(), 9551) || ArrayUtils.contains(client.getMapRegions(), 9043))
		{
			isInInstance = true;
			if (tempMap.containsKey(npc.getId()) == false)
			{
				tempMap.put(npc.getId(), npc.getName());
			}
		}
		return isInInstance;
	}

	private boolean AddKilledInstancesOnInstanceLeave()
	{
		if (isInInstance != wasInInstance)
		{
			for (var ID : tempMap.keySet())
			{
				killedSet.add(tempMap.get(ID));
			}
			tempMap.clear();
			return true;
		}
		return false;
	}

	private void TryDumpGodWarsMinions()
	{
		if (AtRequiredKC(God.Armadyl))
		{
			for (var ID : tempMap.keySet())
			{
				if (DataFinder.IsArmadylMinion(ID))
				{
					killedSet.add(tempMap.get(ID));
				}
			}

			tempMap.clear();
		}

		if (AtRequiredKC(God.Bandos))
		{
			for (var ID : tempMap.keySet())
			{
				if (DataFinder.IsBandosMinion(ID))
				{
					killedSet.add(tempMap.get(ID));
				}
			}

			tempMap.clear();
		}

		if (AtRequiredKC(God.Saradomin))
		{
			for (var ID : tempMap.keySet())
			{
				if (DataFinder.IsSaradominMinion(ID))
				{
					killedSet.add(tempMap.get(ID));
				}
			}

			tempMap.clear();
		}

		if (AtRequiredKC(God.Zamorak))
		{
			for (var ID : tempMap.keySet())
			{
				if (DataFinder.IsZamorakMinion(ID))
				{
					killedSet.add(tempMap.get(ID));
				}
			}

			tempMap.clear();
		}

		if (AtRequiredKC(God.Zaros))
		{
			for (var ID : tempMap.keySet())
			{
				if (DataFinder.IsZarosMinion(ID))
				{
					killedSet.add(tempMap.get(ID));
				}
			}

			tempMap.clear();
		}
	}

	private void AddToKillSet(NPC npc)
	{
		String npcName = npc.getName();
		if (killedSet.contains(npcName)) return;
		killedSet.add(npcName);
	}
}
