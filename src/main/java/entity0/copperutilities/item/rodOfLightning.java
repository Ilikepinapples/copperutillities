package entity0.copperutilities.item;

import entity0.coppernetworks.CopperNetworkPowerClass;
import entity0.coppernetworks.copperNetworkPowerAPI;
import entity0.copperutilities.CopperUtilities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Arrays;
public class rodOfLightning extends Item implements copperNetworkPowerAPI {
    private boolean clicked = false;
    public rodOfLightning(Settings settings) {
        super(settings);

    }
    int clickede;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && clicked) {
            clickede++;
            CopperUtilities.LOGGER.info(String.valueOf(clickede));
            clicked = false;
            if (copperNetworkAPI().canConsume(10000)) {
                copperNetworkAPI().consume(10000);
                world.createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 0.01f, World.ExplosionSourceType.TNT);
            }
        }
        copperNetworkAPI().cleanupNetwork();
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            clicked = true;
            Vec3d look = user.getEyePos().add(user.getRotationVector().multiply(4d));
            user.requestTeleport(look.x, look.y, look.z);
        }
        return super.use(world, user, hand);
    }

    CopperNetworkPowerClass copperPowerInstance = new CopperNetworkPowerClass();
    @Override
    public CopperNetworkPowerClass copperNetworkAPI() {
        return copperPowerInstance;
    }
}
