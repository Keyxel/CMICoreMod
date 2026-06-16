package dev.celestiacraft.cmi.common.register.block;

import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import dev.celestiacraft.cmi.Cmi;
import dev.celestiacraft.cmi.common.block.space_elevator_base_console.SpaceElevatorBaseConsoleBlock;
import dev.celestiacraft.cmi.common.block.space_elevator_base_console.SpaceElevatorBaseConsoleBlockItem;
import dev.celestiacraft.cmi.common.block.space_elevator_base_console.io.SpaceElevatorIoPortBlock;
import dev.celestiacraft.cmi.common.block.space_elevator_top.SpaceElevatorTopBlock;
import dev.celestiacraft.cmi.common.block.space_elevator_top.SpaceElevatorTopBlockItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;

public class SpaceElevatorBlocks {
	public static final BlockEntry<SpaceElevatorBaseConsoleBlock> SPACE_ELEVATOR_BASE_CONSOLE;
	public static final BlockEntry<SpaceElevatorIoPortBlock> SPACE_ELEVATOR_IO_PORT;
	public static final BlockEntry<SpaceElevatorTopBlock> SPACE_ELEVATOR_TOP;

	static {
		SPACE_ELEVATOR_BASE_CONSOLE = Cmi.REGISTRATE.block("space_elevator_base_console", SpaceElevatorBaseConsoleBlock::new)
				.initialProperties(SharedProperties::stone)
				.properties(BlockBehaviour.Properties::noOcclusion)
				.item(SpaceElevatorBaseConsoleBlockItem::new)
				.model((context, provider) -> {
					provider.getBuilder(context.getName())
							.parent(new ModelFile.UncheckedModelFile("minecraft:builtin/entity"))
							.transforms()
							.transform(ItemDisplayContext.GUI)
							.rotation(30.0F, 45.0F, 0.0F)
							.translation(0.0F, 0.0F, 0.0F)
							.scale(0.18F)
							.end()
							.transform(ItemDisplayContext.GROUND)
							.rotation(0.0F, 0.0F, 0.0F)
							.translation(0.0F, 2.0F, 0.0F)
							.scale(0.15F)
							.end()
							.transform(ItemDisplayContext.FIXED)
							.rotation(0.0F, 0.0F, 0.0F)
							.translation(0.0F, 0.0F, 0.0F)
							.scale(0.25F)
							.end()
							.transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
							.rotation(75.0F, 45.0F, 0.0F)
							.translation(0.0F, 2.5F, 0.0F)
							.scale(0.20F)
							.end()
							.transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
							.rotation(75.0F, 45.0F, 0.0F)
							.translation(0.0F, 2.5F, 0.0F)
							.scale(0.20F)
							.end()
							.transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
							.rotation(0.0F, 45.0F, 0.0F)
							.translation(0.0F, 4.0F, 2.0F)
							.scale(0.25F)
							.end()
							.transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
							.rotation(0.0F, 225.0F, 0.0F)
							.translation(0.0F, 4.0F, 2.0F)
							.scale(0.25F)
							.end()
							.end();
				})
				.build()
				.tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.tag(BlockTags.NEEDS_IRON_TOOL)
				.tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag)
				.blockstate((context, provider) -> {
					provider.getVariantBuilder(context.get())
							.forAllStatesExcept((state) -> {
								return ConfiguredModel.builder()
										.modelFile(provider.models().getExistingFile(provider.modLoc("block/space_elevator_base_console")))
										.build();
							});
				})
				.register();
		SPACE_ELEVATOR_IO_PORT = Cmi.REGISTRATE.block("space_elevator_io_port", SpaceElevatorIoPortBlock::new)
				.initialProperties(SharedProperties::stone)
				.properties((properties) -> {
					return properties.noOcclusion()
							.noLootTable();
				})
				.blockstate((context, provider) -> {
					provider.simpleBlock(
							context.get(),
							provider.models()
									.withExistingParent(
											context.getName(), provider.mcLoc("block/block"))
					);
				})
				.register();
		SPACE_ELEVATOR_TOP = Cmi.REGISTRATE.block("space_elevator_top", SpaceElevatorTopBlock::new)
				.initialProperties(SharedProperties::stone)
				.properties(BlockBehaviour.Properties::noOcclusion)
				.item(SpaceElevatorTopBlockItem::new)
				.model((context, provider) -> {
					provider.getBuilder(context.getName())
							.parent(new ModelFile.UncheckedModelFile("minecraft:builtin/entity"))
							.transforms()
							.transform(ItemDisplayContext.GUI)
							.rotation(30.0F, 45.0F, 0.0F)
							.translation(0.0F, 0.0F, 0.0F)
							.scale(0.10F)
							.end()
							.transform(ItemDisplayContext.GROUND)
							.rotation(0.0F, 0.0F, 0.0F)
							.translation(0.0F, 2.0F, 0.0F)
							.scale(0.08F)
							.end()
							.transform(ItemDisplayContext.FIXED)
							.rotation(0.0F, 0.0F, 0.0F)
							.translation(0.0F, 0.0F, 0.0F)
							.scale(0.12F)
							.end()
							.transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
							.rotation(75.0F, 45.0F, 0.0F)
							.translation(0.0F, 2.5F, 0.0F)
							.scale(0.10F)
							.end()
							.transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
							.rotation(75.0F, 45.0F, 0.0F)
							.translation(0.0F, 2.5F, 0.0F)
							.scale(0.10F)
							.end()
							.transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
							.rotation(0.0F, 45.0F, 0.0F)
							.translation(0.0F, 4.0F, 2.0F)
							.scale(0.12F)
							.end()
							.transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
							.rotation(0.0F, 225.0F, 0.0F)
							.translation(0.0F, 4.0F, 2.0F)
							.scale(0.12F)
							.end()
							.end();
				})
				.build()
				.tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.tag(BlockTags.NEEDS_IRON_TOOL)
				.tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag)
				.blockstate((context, provider) -> {
					provider.getVariantBuilder(context.get())
							.forAllStatesExcept((state) -> {
								return ConfiguredModel.builder()
										.modelFile(provider.models().getExistingFile(provider.modLoc("block/space_elevator_top")))
										.build();
							});
				})
				.register();
	}

	public static void register() {
		Cmi.LOGGER.info("{} Space Elevator Blocks Registered!", Cmi.MODID);
	}
}