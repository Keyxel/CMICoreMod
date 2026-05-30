package dev.celestiacraft.cmi.common.block.wind_vane;

import com.simibubi.create.foundation.block.IBE;
import dev.celestiacraft.cmi.common.register.CmiBlockEntity;
import dev.celestiacraft.libs.api.register.block.BasicBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class WindVaneBlock extends BasicBlock implements IBE<WindVaneBlockEntity> {
	public WindVaneBlock(Properties properties) {
		super(Properties.copy(Blocks.COPPER_BLOCK)
				.strength(3.0F, 6.0F)
		);
	}

	@Override
	public Class<WindVaneBlockEntity> getBlockEntityClass() {
		return WindVaneBlockEntity.class;
	}

	@Override
	public BlockEntityType<? extends WindVaneBlockEntity> getBlockEntityType() {
		return CmiBlockEntity.WIND_VANE.get();
	}
}