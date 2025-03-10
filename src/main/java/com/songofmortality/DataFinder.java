package com.songofmortality;

import net.runelite.api.NpcID;

public class DataFinder
{
    public static boolean IsArmadylMinion(int actorId)
    {
        switch (actorId)
        {
            case NpcID.AVIANSIE:
            case NpcID.AVIANSIE_3177:
            case NpcID.AVIANSIE_3178:
            case NpcID.AVIANSIE_3170:
            case NpcID.AVIANSIE_3179:
            case NpcID.AVIANSIE_3172:
            case NpcID.AVIANSIE_3171:
            case NpcID.AVIANSIE_3180:
            case NpcID.AVIANSIE_3173:
            case NpcID.AVIANSIE_3181:
            case NpcID.AVIANSIE_3174:
            case NpcID.AVIANSIE_3182:
            case NpcID.AVIANSIE_3183:
            case NpcID.AVIANSIE_3175:
            case NpcID.AVIANSIE_3176:
            case NpcID.SPIRITUAL_WARRIOR_3166:
            case NpcID.SPIRITUAL_RANGER_3167:
            case NpcID.SPIRITUAL_MAGE_3168:
                return true;
        }
        return false;
    }

    public static boolean IsBandosMinion(int actorId)
    {
        switch (actorId)
        {
            case NpcID.GOBLIN_2247:
            case NpcID.GOBLIN_2246:
            case NpcID.GOBLIN_2249:
            case NpcID.GOBLIN_2248:
            case NpcID.GOBLIN_2245:
            case NpcID.OGRE:
            case NpcID.OGRE_2233:
            case NpcID.JOGRE_2234:
            case NpcID.HOBGOBLIN_2241:
            case NpcID.ORK_2237:
            case NpcID.ORK_2238:
            case NpcID.ORK_2239:
            case NpcID.ORK_2240:
            case NpcID.CYCLOPS_2235:
            case NpcID.CYCLOPS_2236:
            case NpcID.SPIRITUAL_WARRIOR_2243:
            case NpcID.SPIRITUAL_MAGE_2244:
            case NpcID.SPIRITUAL_RANGER_2242:
                return true;
        }
        return false;
    }

    public static boolean IsSaradominMinion(int actorId)
    {
        switch (actorId)
        {
            case NpcID.KNIGHT_OF_SARADOMIN:
            case NpcID.KNIGHT_OF_SARADOMIN_2214:
            case NpcID.SARADOMIN_PRIEST:
            case NpcID.SPIRITUAL_MAGE:
            case NpcID.SPIRITUAL_RANGER:
            case NpcID.SPIRITUAL_WARRIOR:
                return true;
        }
        return false;
    }

    public static boolean IsZamorakMinion(int actorId)
    {
        switch (actorId)
        {
            case NpcID.IMP:
            case NpcID.ICEFIEND:
            case NpcID.PYREFIEND_3139:
            case NpcID.FERAL_VAMPYRE:
            case NpcID.BLOODVELD_3138:
            case NpcID.WEREWOLF_3135:
            case NpcID.WEREWOLF_3136:
            case NpcID.HELLHOUND_3133:
            case NpcID.GORAK_3141:
            case NpcID.SPIRITUAL_WARRIOR_3159:
            case NpcID.SPIRITUAL_RANGER_3160:
            case NpcID.SPIRITUAL_MAGE_3161:
                return true;
        }
        return false;
    }

    public static boolean IsZarosMinion(int actorId)
    {
        switch (actorId)
        {
            case NpcID.SPIRITUAL_WARRIOR_11290:
            case NpcID.SPIRITUAL_RANGER_11291:
            case NpcID.SPIRITUAL_MAGE_11292:
            case NpcID.BLOOD_REAVER:
                return true;
        }
        return false;
    }
}
