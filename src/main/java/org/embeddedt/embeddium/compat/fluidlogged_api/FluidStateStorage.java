package org.embeddedt.embeddium.compat.fluidlogged_api;

import git.jbredwards.fluidlogged_api.api.capability.IFluidStateCapability;
import git.jbredwards.fluidlogged_api.api.capability.IFluidStateContainer;
import git.jbredwards.fluidlogged_api.api.util.FluidState;
import net.minecraft.world.chunk.Chunk;

import java.util.Objects;

/**
 * Wrapper class for {@link IFluidStateContainer}.
 */
public class FluidStateStorage {
    private final IFluidStateContainer container;
    private final int containerY;

    public FluidStateStorage(Chunk chunk, int y) {
        container = Objects.requireNonNull(IFluidStateCapability.get(chunk)).getContainer(y);
        containerY = y;
    }

    public Object get(int x, int y, int z) {
        return container.getFluidState(x, containerY | y, z, FluidState.EMPTY);
    }
}
