package entity0.copperutilities;

import entity0.copperutilities.blocks.modBlocks;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class CopperUtilitiesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack CopperGen = fabricDataGenerator.createPack();
		CopperGen.addProvider(GeneratorBlockLootTables::new);
	}

	private static class GeneratorBlockLootTables extends FabricBlockLootTableProvider {
		public GeneratorBlockLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
			super(dataOutput, registryLookup);
		}

		@Override
		public void generate() {
			addDrop(modBlocks.COPPERFIEDSCULKCATALYST, modBlocks.COPPERFIEDSCULKCATALYST);
			addDrop(modBlocks.PASSIVEVOIDGENERATOR, modBlocks.PASSIVEVOIDGENERATOR);
			addDrop(modBlocks.SOLARCOPPERGENERATOR, modBlocks.SOLARCOPPERGENERATOR);
			addDrop(modBlocks.THERMOPHOTOVOLTAICGENERATOR, modBlocks.THERMOPHOTOVOLTAICGENERATOR);
		}
	}
}
