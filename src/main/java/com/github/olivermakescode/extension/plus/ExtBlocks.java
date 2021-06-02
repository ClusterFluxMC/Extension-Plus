package com.github.olivermakescode.extension.plus;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExtBlocks {
    public static String modid = ExtensionPlus.modid;

    public static MudBlock MUD = new MudBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.BROWN).ticksRandomly().jumpVelocityMultiplier(0.1F).sounds(BlockSoundGroup.ROOTED_DIRT));
    public static Block CHARCOAL = new Block(FabricBlockSettings.copy(Blocks.COAL_BLOCK));
    public static Block[] GRANITE_ORES = {
            new Block(FabricBlockSettings.copy(Blocks.GRANITE)),
            new Block(FabricBlockSettings.copy(Blocks.GRANITE)),
            new Block(FabricBlockSettings.copy(Blocks.GRANITE)),
            new Block(FabricBlockSettings.copy(Blocks.GRANITE)),
            new Block(FabricBlockSettings.copy(Blocks.GRANITE)),
            new Block(FabricBlockSettings.copy(Blocks.GRANITE)),
            new Block(FabricBlockSettings.copy(Blocks.GRANITE)),
            new Block(FabricBlockSettings.copy(Blocks.GRANITE)),
    };
    public static Block[] DIORITE_ORES = {
            new Block(FabricBlockSettings.copy(Blocks.DIORITE)),
            new Block(FabricBlockSettings.copy(Blocks.DIORITE)),
            new Block(FabricBlockSettings.copy(Blocks.DIORITE)),
            new Block(FabricBlockSettings.copy(Blocks.DIORITE)),
            new Block(FabricBlockSettings.copy(Blocks.DIORITE)),
            new Block(FabricBlockSettings.copy(Blocks.DIORITE)),
            new Block(FabricBlockSettings.copy(Blocks.DIORITE)),
            new Block(FabricBlockSettings.copy(Blocks.DIORITE)),
    };
    public static Block[] ANDESITE_ORES = {
            new Block(FabricBlockSettings.copy(Blocks.ANDESITE)),
            new Block(FabricBlockSettings.copy(Blocks.ANDESITE)),
            new Block(FabricBlockSettings.copy(Blocks.ANDESITE)),
            new Block(FabricBlockSettings.copy(Blocks.ANDESITE)),
            new Block(FabricBlockSettings.copy(Blocks.ANDESITE)),
            new Block(FabricBlockSettings.copy(Blocks.ANDESITE)),
            new Block(FabricBlockSettings.copy(Blocks.ANDESITE)),
            new Block(FabricBlockSettings.copy(Blocks.ANDESITE)),
    };
    public static Block[][] ORES = {
            GRANITE_ORES,DIORITE_ORES,ANDESITE_ORES
    };

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(modid, "mud"), MUD);
        Registry.register(Registry.BLOCK, new Identifier(modid, "charcoal_block"), CHARCOAL);

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
                Registry.register(Registry.BLOCK,new Identifier(modid, name),ORES[i][j]);
            }
        }
    }
}