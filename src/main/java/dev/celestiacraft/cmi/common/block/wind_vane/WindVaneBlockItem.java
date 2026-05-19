package dev.celestiacraft.cmi.common.block.wind_vane;

import dev.celestiacraft.cmi.api.client.CmiLang;
import dev.celestiacraft.libs.api.client.context.TooltipContext;
import dev.celestiacraft.libs.api.register.block.BasicBlockItem;
import net.minecraft.world.level.block.Block;

public class WindVaneBlockItem extends BasicBlockItem {
	public WindVaneBlockItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public void addTooltips(TooltipContext context) {
		context.add(CmiLang.translateDirect("tooltip.wind_vane.1"));
		context.add(CmiLang.translateDirect("tooltip.wind_vane.2"));
	}
}