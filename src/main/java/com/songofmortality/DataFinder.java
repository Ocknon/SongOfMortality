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

    public static int[] TryGetNpcVariants(int npcId)
    {
        // I wish there was more npc data support :c
        switch (npcId)
        {
            case NpcID.CHICKEN:
            case NpcID.CHICKEN_1174:
            case NpcID.CHICKEN_10495:
            case NpcID.CHICKEN_10496:
            case NpcID.CHICKEN_9488:
            case NpcID.CHICKEN_10494:
            case NpcID.CHICKEN_10497:
            case NpcID.CHICKEN_3661:
            case NpcID.CHICKEN_3662:
            case NpcID.CHICKEN_2804:
            case NpcID.CHICKEN_2805:
            case NpcID.CHICKEN_2806:
                return new int[]{NpcID.CHICKEN, NpcID.CHICKEN_1174, NpcID.CHICKEN_10495, NpcID.CHICKEN_10496, NpcID.CHICKEN_9488, NpcID.CHICKEN_10494, NpcID.CHICKEN_10497, NpcID.CHICKEN_3661, NpcID.CHICKEN_3662, NpcID.CHICKEN_2804, NpcID.CHICKEN_2805, NpcID.CHICKEN_2806};

            case NpcID.SPIDER_3019:
            case NpcID.SPIDER_4561:
            case NpcID.SPIDER:
                return new int[]{NpcID.SPIDER_3019, NpcID.SPIDER_4561, NpcID.SPIDER};

            case NpcID.RABBIT_3420:
            case NpcID.RABBIT_3421:
            case NpcID.RABBIT_3422:
            case NpcID.RABBIT_3664:
            case NpcID.RABBIT_3665:
            case NpcID.RABBIT:
            case NpcID.RABBIT_1853:
            case NpcID.RABBIT_9118:
                return new int[]{NpcID.RABBIT_9118, NpcID.RABBIT_3420, NpcID.RABBIT_3421, NpcID.RABBIT_3422, NpcID.RABBIT_3664, NpcID.RABBIT_3665, NpcID.RABBIT, NpcID.RABBIT_1853};

            case NpcID.DUCK_1839:
            case NpcID.DUCK:
                return new int[]{NpcID.DUCK_1839, NpcID.DUCK};

            case NpcID.RAT_2854:
            case NpcID.RAT_2855:
            case NpcID.RAT_2492:
            case NpcID.RAT_2513:
                return new int[]{NpcID.RAT_2854, NpcID.RAT_2855, NpcID.RAT_2492, NpcID.RAT_2513};

            // Regular
            case NpcID.GOBLIN_3028:
            case NpcID.GOBLIN_3029:
            case NpcID.GOBLIN_3030:
            case NpcID.GOBLIN_3031:
            case NpcID.GOBLIN_3032:
            case NpcID.GOBLIN_3033:
            case NpcID.GOBLIN_3034:
            case NpcID.GOBLIN_3035:
            case NpcID.GOBLIN_3036:
            case NpcID.GOBLIN_3037:
            case NpcID.GOBLIN_3038:
            case NpcID.GOBLIN_3039:
            case NpcID.GOBLIN_3040:
            case NpcID.GOBLIN_3041:
            case NpcID.GOBLIN_3042:
            case NpcID.GOBLIN_3043:
            case NpcID.GOBLIN_3044:
            case NpcID.GOBLIN_3051:
            case NpcID.GOBLIN_3052:
            case NpcID.GOBLIN_3053:
            case NpcID.GOBLIN_3054:
            case NpcID.GOBLIN_5195:
            case NpcID.GOBLIN_5196:
            case NpcID.GOBLIN_5197:
            case NpcID.GOBLIN_5198:
            case NpcID.GOBLIN_5199:
            case NpcID.GOBLIN_5200:
            case NpcID.GOBLIN_5201:
            case NpcID.GOBLIN_5202:
            case NpcID.GOBLIN_5203:
            case NpcID.GOBLIN_5192:
            case NpcID.GOBLIN_5193:
            case NpcID.GOBLIN_5204:
            case NpcID.GOBLIN_5205:
            case NpcID.GOBLIN_5206:
            case NpcID.GOBLIN_5207:
            case NpcID.GOBLIN_5208:
            case NpcID.GOBLIN_3045:
            case NpcID.GOBLIN_3073:
            case NpcID.GOBLIN_3074:
            case NpcID.GOBLIN_3075:
            case NpcID.GOBLIN_3076:
            case NpcID.GOBLIN_3046:
            // Goblin Village
            case NpcID.GOBLIN:
            case NpcID.GOBLIN_656:
            case NpcID.GOBLIN_657:
            case NpcID.GOBLIN_658:
            case NpcID.GOBLIN_659:
            case NpcID.GOBLIN_660:
            case NpcID.GOBLIN_661:
            // Stronghold of Security
            case NpcID.GOBLIN_2484:
            case NpcID.GOBLIN_2486:
            case NpcID.GOBLIN_2485:
            case NpcID.GOBLIN_2487:
            case NpcID.GOBLIN_2489:
            case NpcID.GOBLIN_2488:
            // God Wars
            case NpcID.GOBLIN_2247:
            case NpcID.GOBLIN_2246:
            case NpcID.GOBLIN_2249:
            case NpcID.GOBLIN_2248:
            case NpcID.GOBLIN_2245:
                return new int[]{NpcID.GOBLIN_2245, NpcID.GOBLIN_2248, NpcID.GOBLIN_2249, NpcID.GOBLIN_2246, NpcID.GOBLIN_2247, NpcID.GOBLIN_2488, NpcID.GOBLIN_2489, NpcID.GOBLIN_2487, NpcID.GOBLIN_2485, NpcID.GOBLIN_2486, NpcID.GOBLIN_2484, NpcID.GOBLIN_3028, NpcID.GOBLIN_3029, NpcID.GOBLIN_3030, NpcID.GOBLIN_3031,NpcID.GOBLIN_3032, NpcID.GOBLIN_3033, NpcID.GOBLIN_3034, NpcID.GOBLIN_3035, NpcID.GOBLIN_3036, NpcID.GOBLIN_3037, NpcID.GOBLIN_3038, NpcID.GOBLIN_3039, NpcID.GOBLIN_3040, NpcID.GOBLIN_3041, NpcID.GOBLIN_3042, NpcID.GOBLIN_3043, NpcID.GOBLIN_3044, NpcID.GOBLIN_3051, NpcID.GOBLIN_3052, NpcID.GOBLIN_3053, NpcID.GOBLIN_3054, NpcID.GOBLIN_5195, NpcID.GOBLIN_5196, NpcID.GOBLIN_5197, NpcID.GOBLIN_5198, NpcID.GOBLIN_5199, NpcID.GOBLIN_5200, NpcID.GOBLIN_5201, NpcID.GOBLIN_5202, NpcID.GOBLIN_5203, NpcID.GOBLIN_5192, NpcID.GOBLIN_5193, NpcID.GOBLIN_5204, NpcID.GOBLIN_5205, NpcID.GOBLIN_5206, NpcID.GOBLIN_5207, NpcID.GOBLIN_5208, NpcID.GOBLIN_3045, NpcID.GOBLIN_3073, NpcID.GOBLIN_3074, NpcID.GOBLIN_3075, NpcID.GOBLIN_3076, NpcID.GOBLIN_3046, NpcID.GOBLIN, NpcID.GOBLIN_656, NpcID.GOBLIN_657, NpcID.GOBLIN_658, NpcID.GOBLIN_659, NpcID.GOBLIN_660, NpcID.GOBLIN_661,};

            case NpcID.RAM_1262:
            case NpcID.RAM_1263:
            case NpcID.RAM_1264:
            case NpcID.RAM_1265:
            case NpcID.RAM:
                return new int[]{NpcID.RAM_1262, NpcID.RAM_1263, NpcID.RAM_1264, NpcID.RAM_1265, NpcID.RAM};

            case NpcID.IMP_5007:
            case NpcID.IMP:
                return new int[]{NpcID.IMP_5007, NpcID.IMP};

            case NpcID.ROOSTER_3663:
            case NpcID.ROOSTER:
                return new int[]{NpcID.ROOSTER_3663, NpcID.ROOSTER};

            case NpcID.SEAGULL:
            case NpcID.SEAGULL_1339:
            case NpcID.SEAGULL_9609:
                return new int[]{NpcID.SEAGULL, NpcID.SEAGULL_1339, NpcID.SEAGULL_9609};

            case NpcID.MAN_3106:
            case NpcID.MAN_6818:
            case NpcID.MAN_6987:
            case NpcID.MAN_8858:
            case NpcID.MAN_3107:
            case NpcID.MAN_6988:
            case NpcID.MAN_3108:
            case NpcID.MAN_6989:
            case NpcID.MAN_3109:
            case NpcID.MAN_6815:
            case NpcID.MAN_3110:
            case NpcID.MAN_3261:
            case NpcID.MAN_3264:
            case NpcID.MAN_3265:
            case NpcID.MAN_3652:
            case NpcID.MAN_3014:
            case NpcID.MAN_11058:
            case NpcID.MAN_11057:
            case NpcID.MAN_1118:
            case NpcID.MAN_4271:
            case NpcID.MAN_4270:
                return new int[]{NpcID.MAN_4270, NpcID.MAN_4271, NpcID.MAN_1118, NpcID.MAN_3106, NpcID.MAN_6818, NpcID.MAN_6987, NpcID.MAN_8858, NpcID.MAN_3107, NpcID.MAN_6988, NpcID.MAN_3108, NpcID.MAN_6989, NpcID.MAN_3109, NpcID.MAN_6815, NpcID.MAN_3110, NpcID.MAN_3261, NpcID.MAN_3264, NpcID.MAN_3265, NpcID.MAN_3652, NpcID.MAN_3014, NpcID.MAN_11058, NpcID.MAN_11057};

            case NpcID.WOMAN_3111:
            case NpcID.WOMAN_6990:
            case NpcID.WOMAN_10728:
            case NpcID.WOMAN_3112:
            case NpcID.WOMAN_6991:
            case NpcID.WOMAN_3113:
            case NpcID.WOMAN_6992:
            case NpcID.WOMAN_3015:
            case NpcID.WOMAN_11053:
            case NpcID.WOMAN_11054:
            case NpcID.WOMAN:
            case NpcID.WOMAN_1131:
            case NpcID.WOMAN_1141:
            case NpcID.WOMAN_1130:
            case NpcID.WOMAN_1139:
            case NpcID.WOMAN_1140:
            case NpcID.WOMAN_1142:
                return new int[]{NpcID.WOMAN_1142, NpcID.WOMAN_1140, NpcID.WOMAN_1139, NpcID.WOMAN_1130, NpcID.WOMAN_1141, NpcID.WOMAN_1131, NpcID.WOMAN, NpcID.WOMAN_3111, NpcID.WOMAN_6990, NpcID.WOMAN_10728, NpcID.WOMAN_3112, NpcID.WOMAN_6991, NpcID.WOMAN_3113, NpcID.WOMAN_6992, NpcID.WOMAN_3015, NpcID.WOMAN_11053, NpcID.WOMAN_11054};

            case NpcID.BUNNY:
            case NpcID.BUNNY_3903:
                return new int[]{NpcID.BUNNY, NpcID.BUNNY_3903};

            case NpcID.COW:
            case NpcID.COW_2791:
            case NpcID.COW_2793:
            case NpcID.COW_2795:
            case NpcID.COW_5842:
                return new int[]{NpcID.COW, NpcID.COW_2791, NpcID.COW_2793, NpcID.COW_2795, NpcID.COW_5842};

            case NpcID.COW_CALF:
            case NpcID.COW_CALF_2794:
            case NpcID.COW_CALF_2801:
                return new int[]{NpcID.COW_CALF, NpcID.COW_CALF_2794, NpcID.COW_CALF_2801};

            case NpcID.PHEASANT:
            case NpcID.PHEASANT_5500:
            case NpcID.PHEASANT_374:
            case NpcID.PHEASANT_5502:
                return new int[]{NpcID.PHEASANT, NpcID.PHEASANT_5500, NpcID.PHEASANT_374, NpcID.PHEASANT_5502};

            case NpcID.MONKEY_2848:
            case NpcID.MONKEY_1038:
                return new int[]{NpcID.MONKEY_2848, NpcID.MONKEY_1038};

            case NpcID.ZOMBIE_RAT:
            case NpcID.ZOMBIE_RAT_3970:
            case NpcID.ZOMBIE_RAT_3971:
                return new int[]{NpcID.ZOMBIE_RAT, NpcID.ZOMBIE_RAT_3970, NpcID.ZOMBIE_RAT_3971};

            case NpcID.GNOME_TROOP:
            case NpcID.GNOME_TROOP_4974:
            case NpcID.GNOME_TROOP_5966:
            case NpcID.GNOME_TROOP_5967:
                return new int[]{NpcID.GNOME_TROOP, NpcID.GNOME_TROOP_4974, NpcID.GNOME_TROOP_5966, NpcID.GNOME_TROOP_5967};

            case NpcID.CAVE_GOBLIN_6434:
            case NpcID.CAVE_GOBLIN_6435:
            case NpcID.CAVE_GOBLIN_6436:
            case NpcID.CAVE_GOBLIN_6437:
                return new int[]{NpcID.CAVE_GOBLIN_6434, NpcID.CAVE_GOBLIN_6435, NpcID.CAVE_GOBLIN_6436, NpcID.CAVE_GOBLIN_6437};

            case NpcID.GNOME_5969:
            case NpcID.GNOME_6094:
            case NpcID.GNOME_6095:
            case NpcID.GNOME_6096:
            case NpcID.GNOME_5968:
            case NpcID.GNOME_5970:
                return new int[]{NpcID.GNOME_5969, NpcID.GNOME_6094, NpcID.GNOME_6095, NpcID.GNOME_6096, NpcID.GNOME_5968, NpcID.GNOME_5970};

            case NpcID.SLEEPWALKER_9446:
            case NpcID.SLEEPWALKER_9447:
            case NpcID.SLEEPWALKER_9448:
            case NpcID.SLEEPWALKER_9449:
            case NpcID.SLEEPWALKER_9450:
            case NpcID.SLEEPWALKER_9451:
                return new int[]{NpcID.SLEEPWALKER_9446, NpcID.SLEEPWALKER_9447, NpcID.SLEEPWALKER_9448, NpcID.SLEEPWALKER_9449, NpcID.SLEEPWALKER_9450, NpcID.SLEEPWALKER_9451};

            case NpcID.GIANT_RAT_2856:
            case NpcID.GIANT_RAT_2857:
            case NpcID.GIANT_RAT_2858:
            case NpcID.GIANT_RAT_2859:
            case NpcID.GIANT_RAT_2860:
            case NpcID.GIANT_RAT_2861:
            case NpcID.GIANT_RAT_9483:
            case NpcID.GIANT_RAT_2862:
            case NpcID.GIANT_RAT_2863:
            case NpcID.GIANT_RAT_2864:
            case NpcID.GIANT_RAT:
            case NpcID.GIANT_RAT_2511:
            case NpcID.GIANT_RAT_2512:
                return new int[]{NpcID.GIANT_RAT_2856, NpcID.GIANT_RAT_2857, NpcID.GIANT_RAT_2858, NpcID.GIANT_RAT_2859, NpcID.GIANT_RAT_2860, NpcID.GIANT_RAT_2861, NpcID.GIANT_RAT_9483, NpcID.GIANT_RAT_2862, NpcID.GIANT_RAT_2863, NpcID.GIANT_RAT_2864, NpcID.GIANT_RAT, NpcID.GIANT_RAT_2511, NpcID.GIANT_RAT_2512};

            case NpcID.GARDENER:
            case NpcID.GARDENER_3276:
            case NpcID.GARDENER_3651:
            case NpcID.GARDENER_5512:
                return new int[]{NpcID.GARDENER, NpcID.GARDENER_3276, NpcID.GARDENER_3651, NpcID.GARDENER_5512};

            case NpcID.MONK_4246:
            case NpcID.MONK_2579:
            case NpcID.MONK_4068:
            case NpcID.MONK_6956:
                return new int[]{NpcID.MONK_4246, NpcID.MONK_2579, NpcID.MONK_4068, NpcID.MONK_6956};

            case NpcID.BAT:
            case NpcID.BAT_14042:
            case NpcID.BAT_10888:
                return new int[]{NpcID.BAT, NpcID.BAT_14042, NpcID.BAT_10888};

            case NpcID.MUGGER:
            case NpcID.MUGGER_1461:
            case NpcID.MUGGER_6996:
                return new int[]{NpcID.MUGGER, NpcID.MUGGER_1461, NpcID.MUGGER_6996};
        }
        return null;
    }
}
