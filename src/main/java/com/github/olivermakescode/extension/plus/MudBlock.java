package com.github.olivermakescode.extension.plus;

import com.github.olivermakescode.extension.extension;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Iterator;
import java.util.Random;

public class MudBlock extends Block {
    public static IntProperty moisture = IntProperty.of("moisture", 1, 5);
    public MudBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(moisture, 5));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(moisture);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = state.get(moisture);
        if (!isWaterNearby(world, pos) && !world.hasRain(pos.up())) {
            if (i > 1) {
                world.setBlockState(pos, state.with(moisture, i - 1), Block.NOTIFY_LISTENERS);
            } else {
                setToDirt(world, pos);
            }
        } else if (i < 5) {
            world.setBlockState(pos, state.with(moisture, i + 1), Block.NOTIFY_LISTENERS);
        }
    }

    public static void setToDirt(World world, BlockPos pos) {
        world.setBlockState(pos, Blocks.DIRT.getDefaultState());
    }

    private static boolean isWaterNearby(WorldView world, BlockPos pos) {
        int dist = extension.cropWaterRadius.getValue();
        Iterator<BlockPos> iterator = BlockPos.iterate(pos.add(-dist, 0, -dist), pos.add(dist, 1, dist)).iterator();
        BlockPos blockPos;
        do {
            if (!iterator.hasNext()) {
                return false;
            }

            blockPos = iterator.next();
        } while(!world.getFluidState(blockPos).isIn(FluidTags.WATER));

        return true;
    }
}
