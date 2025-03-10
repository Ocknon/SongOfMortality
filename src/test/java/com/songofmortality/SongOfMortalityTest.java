package com.songofmortality;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class SongOfMortalityTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(SongOfMortalityPlugin.class);
		RuneLite.main(args);
	}
}