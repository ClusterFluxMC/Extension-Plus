package com.github.olivermakescode.extension.plus;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExtItems {
    public static String modid = ExtensionPlus.modid;

    public static BlockItem mud = new BlockItem(ExtBlocks.MUD, new FabricItemSettings());
    public static BlockItem CHARCOAL = new BlockItem(ExtBlocks.CHARCOAL, new FabricItemSettings());
    public static Block[][] ORES = ExtBlocks.ORES;
    public static void register() {
        Registry.register(Registry.ITEM,new Identifier(modid, "mud"),mud);
        Registry.register(Registry.ITEM,new Identifier(modid, "charcoal_block"),CHARCOAL);

        for (int i = 0; i < ORES.length; i++) {
            for (int j = 0; j < ORES[i].length; j++) {
                String[] nameSpace = new String [2];

                if (i == 0) nameSpace[0] = "granite";
                else if (i == 1) nameSpace[0] = "diorite";
                else if (i == 2) nameSpace[0] = "andesite";
                else nameSpace[0] = "unknown";

                nameSpace[1] = switch (j) {
                    case 0 -> "coal";
                    case 1 -> "iron";
                    case 2 -> "copper";
                    case 3 -> "gold";
                    case 4 -> "diamond";
                    case 5 -> "emerald";
                    case 6 -> "redstone";
                    case 7 -> "lapis";
                    default -> "unknown";
                };
                String name = nameSpace[0] + "_" + nameSpace[1] + "_ore";
                BlockItem item = new BlockItem(ORES[i][j], new FabricItemSettings());
                Registry.register(Registry.ITEM,new Identifier(modid, name),item);
            }
        }
    }
}
