package entity0.copperutilities.item.armour;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import entity0.coppernetworks.*;
import entity0.copperutilities.CopperUtilities;
import net.minecraft.component.Component;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Objects;
import java.util.function.BiConsumer;

public class copperLeggings extends ArmorItem implements copperNetworkPowerItemAPI {
    public copperLeggings(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }
    //int Energy;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!world.isClient) {
            if (copperNetworkAPI(stack).canConsume(50)) {
                copperNetworkAPI(stack).consume(50);
                if ((stack.contains(DataComponentTypes.TRIM)) && (stack.get(DataComponentTypes.TRIM).getMaterial().getIdAsString().equals("minecraft:copper"))) {
                    stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, new AttributeModifiersComponent(Collections.singletonList((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(Identifier.of("leggings_speed"), 2, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("LEGS")))), false));
                } else {
                    stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, new AttributeModifiersComponent(Collections.singletonList((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(Identifier.of("leggings_speed"), 0.2, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("LEGS")))), true));
                }
            } else {
                stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, new AttributeModifiersComponent(Collections.singletonList((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(Identifier.of("leggings_speed"), 0, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("LEGS")))), false));
            }
            CopperUtilities.LOGGER.info(String.valueOf(copperNetworkAPI(stack).networkPower[0]));
            copperNetworkAPI(stack).cleanupNetwork();
        }
    }

    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        stack.set(ModComponents.COPPER_POWER_COMPONENT, new copperNetworkItemPowerClass(1));
        return super.onStackClicked(stack, slot, clickType, player);
    }

    @Override
    public copperNetworkItemPowerClass copperNetworkAPI(ItemStack itemStack) {
        CopperUtilities.LOGGER.info(itemStack.toString());
        CopperUtilities.LOGGER.info(itemStack.get(ModComponents.COPPER_POWER_COMPONENT).toString());
        return itemStack.get(ModComponents.COPPER_POWER_COMPONENT);
    }
}