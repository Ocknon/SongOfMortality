package com.songofmortality;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("songofmortality")
public interface SongOfMortalityConfig extends Config
{
	@ConfigItem(
			keyName = "deleteSave",
			name = "Delete saved data",
			description = "Delete saved file. DO NOT KEEP TOGGLED ON!"
	)
	default boolean deleteSavedData() { return false; }
}
