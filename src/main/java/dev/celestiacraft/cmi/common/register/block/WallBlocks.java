package dev.celestiacraft.cmi.common.register.block;

import com.simibubi.create.AllTags;
import com.tterrag.registrate.util.entry.BlockEntry;
import dev.celestiacraft.cmi.Cmi;
import dev.celestiacraft.cmi.common.block.well.blazing_blood.BlazingBloodWellBlock;
import dev.celestiacraft.cmi.common.block.well.blazing_blood.BlazingBloodWellBlockItem;
import dev.celestiacraft.cmi.common.block.well.lava.LavaWellBlock;
import dev.celestiacraft.cmi.common.block.well.lava.LavaWellBlockItem;
import dev.celestiacraft.cmi.common.block.well.water.WaterWellBlock;
import dev.celestiacraft.cmi.common.block.well.water.WaterWellBlockItem;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.Tags;

public class WallBlocks {
	public static final BlockEntry<WaterWellBlock> WATER_WELL;
	public static final BlockEntry<LavaWellBlock> LAVA_WELL;
	public static final BlockEntry<BlazingBloodWellBlock> BLAZING_BLOOD_WELL;

	static {
		WATER_WELL = Cmi.REGISTRATE.block("water_well", WaterWellBlock::new)
				.item(WaterWellBlockItem::new)
				.model((context, provider) -> {
					provider.withExistingParent(
							context.getName(),
							provider.modLoc("block/well/water")
					);
				})
				.build()
				.tag(BlockTags.MINEABLE_WITH_AXE)
				.tag(Tags.Blocks.NEEDS_WOOD_TOOL)
				.tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag)
				.blockstate((context, provider) -> {
					provider.getVariantBuilder(context.get())
							.forAllStatesExcept((state) -> {
								BlockModelProvider models = provider.models();
								return ConfiguredModel.builder()
										.modelFile(models.getExistingFile(provider.modLoc("block/well/water")))
										.build();
							});
				})
				.register();
		LAVA_WELL = Cmi.REGISTRATE.block("lava_well", LavaWellBlock::new)
				.item(LavaWellBlockItem::new)
				.model((context, provider) -> {
					provider.withExistingParent(
							context.getName(),
							provider.modLoc("block/well/lava")
					);
				})
				.build()
				.tag(BlockTags.MINEABLE_WITH_AXE)
				.tag(Tags.Blocks.NEEDS_WOOD_TOOL)
				.tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag)
				.blockstate((context, provider) -> {
					provider.getVariantBuilder(context.get())
							.forAllStatesExcept((state) -> {
								BlockModelProvider models = provider.models();
								return ConfiguredModel.builder()
										.modelFile(models.getExistingFile(provider.modLoc("block/well/lava")))
										.build();
							});
				})
				.register();
		BLAZING_BLOOD_WELL = Cmi.REGISTRATE.block("blazing_blood_well", BlazingBloodWellBlock::new)
				.item(BlazingBloodWellBlockItem::new)
				.model((context, provider) -> {
					provider.withExistingParent(
							context.getName(),
							provider.modLoc("block/well/blazing_blood")
					);
				})
				.build()
				.tag(BlockTags.MINEABLE_WITH_AXE)
				.tag(Tags.Blocks.NEEDS_WOOD_TOOL)
				.tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag)
				.blockstate((context, provider) -> {
					provider.getVariantBuilder(context.get())
							.forAllStatesExcept((state) -> {
								BlockModelProvider models = provider.models();
								return ConfiguredModel.builder()
										.modelFile(models.getExistingFile(provider.modLoc("block/well/blazing_blood")))
										.build();
							});
				})
				.register();
	}

	public static void register() {
		Cmi.LOGGER.info("{} Wall Blocks Registered!", Cmi.MODID);
	}
}