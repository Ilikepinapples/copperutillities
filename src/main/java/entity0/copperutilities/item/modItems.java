package entity0.copperutilities.item;

import entity0.coppernetworks.CopperNetworkPowerClass;
import entity0.coppernetworks.ModComponents;
import entity0.coppernetworks.copperNetworkItemPowerClass;
import entity0.copperutilities.CopperUtilities;
import entity0.copperutilities.blocks.modBlocks;
import entity0.copperutilities.item.armour.copperBoots;
import entity0.copperutilities.item.armour.copperChestplate;
import entity0.copperutilities.item.armour.copperHelmet;
import entity0.copperutilities.item.armour.copperLeggings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class modItems {
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(CopperUtilities.MOD_ID, id);
        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        // Return the registered item!
        return registeredItem;
    }
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> {
        itemGroup.add(modItems.COPPERHELMET.asItem());
        itemGroup.add(modItems.COPPERCHESTPLATE.asItem());
        itemGroup.add(modItems.COPPERLEGGINGS.asItem());
        itemGroup.add(modItems.COPPERBOOTS.asItem());
    });}
    public static final Item RODOFLIGHTNING = register(new rodOfLightning(new Item.Settings()), "rodoflightning");
    public static final Item COPPERHELMET = register(new copperHelmet(modArmourMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))), "copper_helmet");
    public static final Item COPPERCHESTPLATE = register(new copperChestplate(modArmourMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))), "copper_chestplate");
    public static final Item COPPERLEGGINGS = register(new copperLeggings(modArmourMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))), "copper_leggings");
    public static final Item COPPERBOOTS = register(new copperBoots(modArmourMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))), "copper_boots");

}
