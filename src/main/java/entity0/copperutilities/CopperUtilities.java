package entity0.copperutilities;

import entity0.copperutilities.blocks.modBlocks;
import entity0.copperutilities.blocks.entity.modBlockEntity;
import entity0.copperutilities.item.modItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopperUtilities implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("copperutilities");
	public static final String MOD_ID = "copperutilities";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Initialising copperutilities.");
		modBlocks.initialize();
		modBlockEntity.registerBlockEntities();
		modItems.initialize();
	}
}