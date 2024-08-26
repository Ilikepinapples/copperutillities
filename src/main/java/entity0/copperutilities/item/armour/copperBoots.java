package entity0.copperutilities.item.armour;

import entity0.coppernetworks.copperNetworkPowerItemAPI;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class copperBoots extends ArmorItem implements copperNetworkPowerItemAPI {
    public copperBoots(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!world.isClient) {
            if (copperNetworkAPI(stack).canConsume(50)) {
                copperNetworkAPI(stack).consume(50);
                if ((stack.contains(DataComponentTypes.TRIM)) && (stack.get(DataComponentTypes.TRIM).getMaterial().getIdAsString().equals("minecraft:copper"))) {
                    List<AttributeModifiersComponent.Entry> Attributes = new ArrayList<>();
                    Attributes.add((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_JUMP_STRENGTH, new EntityAttributeModifier(Identifier.of("boots_jump"), 0.5, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("FEET"))));
                    Attributes.add((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_STEP_HEIGHT, new EntityAttributeModifier(Identifier.of("boots_step"), 3, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("FEET"))));
                    Attributes.add((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE, new EntityAttributeModifier(Identifier.of("boots_fall"), 20, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("FEET"))));
                    stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, new AttributeModifiersComponent(Attributes, false));
                } else {
                    List<AttributeModifiersComponent.Entry> Attributes = new ArrayList<>();
                    Attributes.add((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_JUMP_STRENGTH, new EntityAttributeModifier(Identifier.of("boots_jump"), 0.2, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("FEET"))));
                    Attributes.add((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_STEP_HEIGHT, new EntityAttributeModifier(Identifier.of("boots_step"), 1, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("FEET"))));
                    Attributes.add((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE, new EntityAttributeModifier(Identifier.of("boots_fall"), 8, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("FEET"))));
                    stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, new AttributeModifiersComponent(Attributes, false));
                }
            } else {
                stack.set(DataComponentTypes.ATTRIBUTE_MODIFIERS, new AttributeModifiersComponent(Collections.singletonList((new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_JUMP_STRENGTH, new EntityAttributeModifier(Identifier.of("boots_jump"), 0, EntityAttributeModifier.Operation.valueOf("ADD_VALUE")), AttributeModifierSlot.valueOf("FEET")))), false));
            }
            copperNetworkAPI(stack).cleanupNetwork();
        }
    }
}
