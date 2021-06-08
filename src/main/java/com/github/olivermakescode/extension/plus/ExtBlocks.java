package com.github.olivermakescode.extension.plus;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExtBlocks {
    public static String modid = ExtensionPlus.modid;

    public static MudBlock MUD = new MudBlock(FabricBlockSettings.of(Material.SOIL).mapColor(MapColor.BROWN).ticksRandomly().jumpVelocityMultiplier(0.2F).sounds(BlockSoundGroup.ROOTED_DIRT));
    public static Block HARDENED_MUD = new Block(FabricBlockSettings.copy(Blocks.DIRT));
    public static Block CHARCOAL = new Block(FabricBlockSettings.copy(Blocks.COAL_BLOCK));
    public static Block[] ORE_ARR = {

    };
    public enum ores {
        GRANITE,
        DIORITE,
        ANDESITE,
        BEDROCK (false, true),

        ;

        public final Block[] array;

        ores() {
            this.array = new Block[] {
                    new Block(FabricBlockSettings.copy(Blocks.COAL_ORE)),
                    new Block(FabricBlockSettings.copy(Blocks.IRON_ORE)),
                    new Block(FabricBlockSettings.copy(Blocks.COPPER_ORE)),
                    new Block(FabricBlockSettings.copy(Blocks.GOLD_ORE)),
                    new Block(FabricBlockSettings.copy(Blocks.DIAMOND_ORE)),
                    new Block(FabricBlockSettings.copy(Blocks.EMERALD_ORE)),
                    new RedstoneOreBlock(FabricBlockSettings.copy(Blocks.REDSTONE_ORE)),
                    new Block(FabricBlockSettings.copy(Blocks.LAPIS_ORE))
            };
        }

        ores(boolean dirt, boolean unbreakable) {
            if (dirt)
                this.array = new Block[] {
                    new Block(FabricBlockSettings.copy(Blocks.COAL_ORE)),
                    new Block(FabricBlockSettings.copy(Blocks.IRON_ORE)),
                    new Block(FabricBlockSettings.copy(Blocks.COPPER_ORE)),
                    new Block(FabricBlockSettings.copy(Blocks.GOLD_ORE)),
                    new Block(FabricBlockSettings.copy(Blocks.DIAMOND_ORE)),
                    new Block(FabricBlockSettings.copy(Blocks.EMERALD_ORE)),
                    new RedstoneOreBlock(FabricBlockSettings.copy(Blocks.REDSTONE_ORE)),
                    new Block(FabricBlockSettings.copy(Blocks.LAPIS_ORE))
                };
            else if (unbreakable)
                this.array = new Block[] {
                        new Block(FabricBlockSettings.copy(Blocks.COAL_ORE).strength(-1.0F, 3600000.0F)),
                        new Block(FabricBlockSettings.copy(Blocks.IRON_ORE).strength(-1.0F, 3600000.0F)),
                        new Block(FabricBlockSettings.copy(Blocks.COPPER_ORE).strength(-1.0F, 3600000.0F)),
                        new Block(FabricBlockSettings.copy(Blocks.GOLD_ORE).strength(-1.0F, 3600000.0F)),
                        new Block(FabricBlockSettings.copy(Blocks.DIAMOND_ORE).strength(-1.0F, 3600000.0F)),
                        new Block(FabricBlockSettings.copy(Blocks.EMERALD_ORE).strength(-1.0F, 3600000.0F)),
                        new RedstoneOreBlock(FabricBlockSettings.copy(Blocks.REDSTONE_ORE).strength(-1.0F, 3600000.0F)),
                        new Block(FabricBlockSettings.copy(Blocks.LAPIS_ORE).strength(-1.0F, 3600000.0F))
                };
            else
                this.array = new Block[] {
                        new Block(FabricBlockSettings.copy(Blocks.COAL_ORE)),
                        new Block(FabricBlockSettings.copy(Blocks.IRON_ORE)),
                        new Block(FabricBlockSettings.copy(Blocks.COPPER_ORE)),
                        new Block(FabricBlockSettings.copy(Blocks.GOLD_ORE)),
                        new Block(FabricBlockSettings.copy(Blocks.DIAMOND_ORE)),
                        new Block(FabricBlockSettings.copy(Blocks.EMERALD_ORE)),
                        new RedstoneOreBlock(FabricBlockSettings.copy(Blocks.REDSTONE_ORE)),
                        new Block(FabricBlockSettings.copy(Blocks.LAPIS_ORE))
                };
        }
    }
    public static Block[][] ORES = {
            ores.GRANITE.array,
            ores.DIORITE.array,
            ores.ANDESITE.array,
    };

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(modid, "mud"), MUD);
        Registry.register(Registry.BLOCK, new Identifier(modid, "hardened_mud"), HARDENED_MUD);
        Registry.register(Registry.BLOCK, new Identifier(modid, "charcoal_block"), CHARCOAL);

        for (int i = 0; i < ORES.length; i++) {
            Block[] arr_ = ORES[i];
            for (int j = 0; j < arr_.length; j++) {
                String[] nameSpace = new String [2];
                System.out.println("X " + i + " Y " + j);
                if (i == 0) nameSpace[0] = "granite";
                else if (i == 1) nameSpace[0] = "diorite";
                else if (i == 2) nameSpace[0] = "andesite";
                else nameSpace[0] = "unknown";

                System.out.println(nameSpace[0]);

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