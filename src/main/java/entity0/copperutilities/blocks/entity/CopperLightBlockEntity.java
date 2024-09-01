package entity0.copperutilities.blocks.entity;

import entity0.coppernetworks.*;
import entity0.copperutilities.CopperUtilities;
import entity0.copperutilities.blocks.modBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CopperLightBlockEntity extends BlockEntity implements copperNetworkPowerAPI {
    CopperNetworkPowerClass powerInstance = new CopperNetworkPowerClass();
        public CopperLightBlockEntity(BlockPos pos, BlockState state) {
            super(modBlockEntity.COPPER_LIGHT_BLOCK_ENTITY, pos, state);
        }
        int cooldown = 0;
        public static void tick(World world, BlockPos pos, BlockState state, CopperLightBlockEntity blockEntity) {
            if (blockEntity.cooldown <= 0) {
                blockEntity.cooldown = 100;
                if (blockEntity.copperNetworkAPI().canConsume(50000)) {
                    for(int x = -10; x < 10; x++) {
                        for(int y = -10; y < 10; y++) {
                            for(int z = -10; z < 10; z++) {
                                if (!(x==0 & y==0 & z==0)) {
                                    world.setBlockState(pos.north(x).west(z).up(y), modBlocks.LIGHT.getDefaultState());
                                }
                            }

                        }
                    }
                }
            }
            CopperUtilities.LOGGER.info("e");
            blockEntity.cooldown--;
            blockEntity.copperNetworkAPI().cleanupNetwork();
        }

    @Override
    public CopperNetworkPowerClass copperNetworkAPI() {
        return powerInstance;
    }
}
