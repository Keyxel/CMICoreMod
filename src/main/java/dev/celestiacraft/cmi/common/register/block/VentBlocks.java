package dev.celestiacraft.cmi.common.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import dev.celestiacraft.cmi.Cmi;
import dev.celestiacraft.cmi.common.block.mars_geothermal_vent.MarsGeothermalVentBlock;
import dev.celestiacraft.cmi.common.block.mercury_geothermal_vent.MercuryGeothermalVentBlock;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.Tags;

public class VentBlocks {
	public static final BlockEntry<MarsGeothermalVentBlock> MARS_GEO;
	public static final BlockEntry<MercuryGeothermalVentBlock> MERCURY_GEO;

	static {
		MARS_GEO = Cmi.REGISTRATE.block("mars_geothermal_vent", MarsGeothermalVentBlock::new)
				.item()
				.model((context, provider) -> {
					provider.withExistingParent(
							context.getName(),
							provider.modLoc("block/mars_geothermal_vent")
					);
				})
				.build()
				.tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.tag(Tags.Blocks.NEEDS_WOOD_TOOL)
				.blockstate((context, provider) -> {
					provider.getVariantBuilder(context.get())
							.forAllStatesExcept((state) -> {
								BlockModelProvider models = provider.models();
								return ConfiguredModel.builder()
										.modelFile(models.getExistingFile(provider.modLoc("block/mars_geothermal_vent")))
										.build();
							});
				})
				.register();
		MERCURY_GEO = Cmi.REGISTRATE.block("mercury_geothermal_vent", MercuryGeothermalVentBlock::new)
				.item()
				.model((context, provider) -> {
					provider.withExistingParent(
							context.getName(),
							provider.modLoc("block/mercury_geothermal_vent")
					);
				})
				.build()
				.tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.tag(Tags.Blocks.NEEDS_WOOD_TOOL)
				.blockstate((context, provider) -> {
					provider.getVariantBuilder(context.get())
							.forAllStatesExcept((state) -> {
								BlockModelProvider models = provider.models();
								return ConfiguredModel.builder()
										.modelFile(models.getExistingFile(provider.modLoc("block/mercury_geothermal_vent")))
										.build();
							});
				})
				.register();
	}

	public static void register() {
		Cmi.LOGGER.info("{} Vent Blocks Registered!", Cmi.MODID);
	}
}