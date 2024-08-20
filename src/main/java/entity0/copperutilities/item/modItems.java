package entity0.copperutilities.item;

import entity0.copperutilities.CopperUtilities;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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
    public static void initialize() {}
    public static final Item RODOFLIGHTNING = register(
            new rodOfLightning(new Item.Settings()),
            "rodoflightning"
    );

}
