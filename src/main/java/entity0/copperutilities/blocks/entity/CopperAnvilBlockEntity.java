package entity0.copperutilities.blocks.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;

public class CopperAnvilBlockEntity extends BlockEntity {
    public CopperAnvilBlockEntity(BlockPos pos, BlockState state) {
        super(modBlockEntity.COPPER_ANVIL_BLOCK_ENTITY, pos, state);
    }
    public static void tick(World world, BlockPos pos, BlockState state, CopperAnvilBlockEntity blockEntity) {

    }
}
