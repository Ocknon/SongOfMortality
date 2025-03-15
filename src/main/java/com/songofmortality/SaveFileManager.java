package com.songofmortality;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import joptsimple.internal.Strings;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import net.runelite.client.config.ConfigManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;

@Slf4j
public class SaveFileManager
{
    private static String CONFIG_GROUP = "songofmortality";
    private static String DATA = "data_";

    private static ConfigManager manager;
    private static Gson gson;

    public static void Init(Gson g, ConfigManager cm)
    {
        manager = cm;
        gson = g;
    }

    public static void Save(HashSet<String> data)
    {
        String json = gson.toJson(data);
        manager.setConfiguration(CONFIG_GROUP, DATA, json);
    }

    public static HashSet<String> Load()
    {
        String json = manager.getConfiguration(CONFIG_GROUP, DATA);
        HashSet<String> loadedKills = new HashSet<>();

        if (Strings.isNullOrEmpty(json)) return loadedKills;

        String[] data = new String[0];
        Type type = new TypeToken<String[]>(){}.getType();

        try
        {
            data = gson.fromJson(json, type);
            loadedKills.addAll(Arrays.asList(data));
        }
        catch (Exception e)
        {
            DeleteData();
        }

        return loadedKills;
    }

    public static void DeleteData()
    {
        manager.unsetConfiguration(CONFIG_GROUP, DATA);
    }
}
