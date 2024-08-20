package entity0.copperutilities.item;

import entity0.coppernetworks.CopperNetworkPowerClass;
import entity0.coppernetworks.copperNetworkPowerAPI;
import entity0.copperutilities.CopperUtilities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Arrays;

public class rodOfLightning extends Item implements copperNetworkPowerAPI {
    public rodOfLightning(Settings settings) {
        super(settings);

    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        CopperUtilities.LOGGER.info(Arrays.toString(copperNetworkAPI().networkPower));
        copperNetworkAPI().cleanupNetwork();
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        CopperUtilities.LOGGER.info(Arrays.toString(copperNetworkAPI().networkPower));
        if (copperNetworkAPI().canConsume(10000)) {
            copperNetworkAPI().consume(10000);
            world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 0.01f, World.ExplosionSourceType.TNT);
        }
        return super.use(world, user, hand);
    }

    CopperNetworkPowerClass copperPowerInstance = new CopperNetworkPowerClass();
    @Override
    public CopperNetworkPowerClass copperNetworkAPI() {
        return copperPowerInstance;
    }
}
