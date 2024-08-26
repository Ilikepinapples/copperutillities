package entity0.copperutilities.item.armour;

import entity0.coppernetworks.CopperNetworkPowerClass;
import entity0.coppernetworks.copperNetworkItemPowerClass;
import entity0.coppernetworks.copperNetworkPowerAPI;
import entity0.coppernetworks.copperNetworkPowerItemAPI;
import entity0.copperutilities.CopperUtilities;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class copperHelmet extends ArmorItem implements copperNetworkPowerItemAPI {

    public copperHelmet(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!world.isClient) {
            if (copperNetworkAPI(stack).canConsume(50)) {
                copperNetworkAPI(stack).consume(50);
                if ((stack.contains(DataComponentTypes.TRIM)) && (stack.get(DataComponentTypes.TRIM).getMaterial().getIdAsString().equals("minecraft:copper"))) {
                    stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, new AttributeModifiersComponent(Collections.singletonList((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_OXYGEN_BONUS, new EntityAttributeModifier(Identifier.of("helmet_air"), 20, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("LEGS")))), false));
                    //if (entity instanceof LivingEntity) {
                    //    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2000, 0, true, false, false));
                    //}
                } else {
                    stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, new AttributeModifiersComponent(Collections.singletonList((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_OXYGEN_BONUS, new EntityAttributeModifier(Identifier.of("helmet_air"), 10, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("LEGS")))), false));
                    //if (entity instanceof LivingEntity) {
                    //    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 0, 0, true, false, false));
                    //}
                }
            } else {
                stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, new AttributeModifiersComponent(Collections.singletonList((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_OXYGEN_BONUS, new EntityAttributeModifier(Identifier.of("helmet_air"), 0, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("LEGS")))), false));
            }
            copperNetworkAPI(stack).cleanupNetwork();
        }
    }

}
