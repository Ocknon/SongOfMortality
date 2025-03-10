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
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import org.apache.commons.lang3.ArrayUtils;

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

	private HashSet<Integer> killedSet = new HashSet<>();
	private HashSet<Integer> tempSet = new HashSet<>();
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
			SaveFileManager.DeleteData();
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		hooks.registerRenderableDrawListener(drawListener);
		SaveFileManager.Init(gson, configManager);
		killedSet = SaveFileManager.Load();
	}

	@Override
	protected void shutDown() throws Exception
	{
		hooks.unregisterRenderableDrawListener(drawListener);
		SaveFileManager.Save(killedSet);
		killedSet.clear();
		clientThread.invoke(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				client.setGameState(GameState.LOADING);
			}
		});
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
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
		 	if (tempSet.contains(npc.getId()) == false)
			{
				tempSet.add(npc.getId());
				TryDumpGodWarsMinions();
			}
		}
		else // Add to killed set
		{
			if (killedSet.contains(npc.getId()) == false)
			{
				killedSet.add(npc.getId());
			}
		}
	}

	@VisibleForTesting
	boolean shouldDraw(Renderable renderable, boolean drawingUI)
	{
		if (renderable instanceof NPC)
		{
			NPC actor = (NPC) renderable;
            return !killedSet.contains(actor.getId());
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
		// Fight Caves
		if (ArrayUtils.contains(client.getMapRegions(), 9551))
		{
			isInInstance = true;
			if (tempSet.contains(npc.getId()) == false)
			{
				tempSet.add(npc.getId());
			}
		}
		// Inferno
		else if (ArrayUtils.contains(client.getMapRegions(), 9043))
		{
			isInInstance = true;
			if (tempSet.contains(npc.getId()) == false)
			{
				tempSet.add(npc.getId());
			}
		}
		return isInInstance;
	}

	private boolean AddKilledInstancesOnInstanceLeave()
	{
		if (isInInstance != wasInInstance)
		{
			killedSet.addAll(tempSet);
			tempSet.clear();
			return true;
		}
		return false;
	}

	private void TryDumpGodWarsMinions()
	{
		if (AtRequiredKC(God.Armadyl))
		{
			for (int ID : tempSet)
			{
				if (DataFinder.IsArmadylMinion(ID))
				{
					killedSet.add(ID);
				}
			}

			tempSet.clear();
		}

		if (AtRequiredKC(God.Bandos))
		{
			for (int ID : tempSet)
			{
				if (DataFinder.IsBandosMinion(ID))
				{
					killedSet.add(ID);
				}
			}

			tempSet.clear();
		}

		if (AtRequiredKC(God.Saradomin))
		{
			for (int ID : tempSet)
			{
				if (DataFinder.IsSaradominMinion(ID))
				{
					killedSet.add(ID);
				}
			}

			tempSet.clear();
		}

		if (AtRequiredKC(God.Zamorak))
		{
			for (int ID : tempSet)
			{
				if (DataFinder.IsZamorakMinion(ID))
				{
					killedSet.add(ID);
				}
			}

			tempSet.clear();
		}

		if (AtRequiredKC(God.Zaros))
		{
			for (int ID : tempSet)
			{
				if (DataFinder.IsZarosMinion(ID))
				{
					killedSet.add(ID);
				}
			}

			tempSet.clear();
		}
	}
}
