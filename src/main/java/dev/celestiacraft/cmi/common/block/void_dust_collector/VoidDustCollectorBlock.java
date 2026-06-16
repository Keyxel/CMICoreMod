package dev.celestiacraft.cmi.common.block.void_dust_collector;

import com.simibubi.create.foundation.block.IBE;
import dev.celestiacraft.cmi.common.register.CmiBlockEntity;
import dev.celestiacraft.libs.api.register.block.BasicBlock;
import dev.celestiacraft.libs.api.register.block.BasicBlockFacing;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class VoidDustCollectorBlock extends BasicBlock implements IBE<VoidDustCollectorBlockEnitiy> {
	public VoidDustCollectorBlock(Properties properties) {
		super(Properties.copy(Blocks.IRON_BLOCK)
				.sound(SoundType.NETHERITE_BLOCK));
	}

	@Override
	protected BasicBlockFacing useFacingType() {
		return BasicBlockFacing.HORIZONTAL;
	}

	@Override
	protected boolean useLitState() {
		return true;
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
		if (level.isClientSide()) {
			return null;
		}

		return createTickerHelper(
				type,
				CmiBlockEntity.VOID_DUST_COLLECTOR.get(),
				VoidDustCollectorBlockEnitiy::tick
		);
	}

	@Override
	public Class<VoidDustCollectorBlockEnitiy> getBlockEntityClass() {
		return VoidDustCollectorBlockEnitiy.class;
	}

	@Override
	public BlockEntityType<? extends VoidDustCollectorBlockEnitiy> getBlockEntityType() {
		return CmiBlockEntity.VOID_DUST_COLLECTOR.get();
	}
}