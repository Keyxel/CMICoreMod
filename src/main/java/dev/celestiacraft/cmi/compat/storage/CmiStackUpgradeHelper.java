package dev.celestiacraft.cmi.compat.storage;

import dev.celestiacraft.cmi.tags.CmiItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * 判定 ItemStack / Item 是否带 {@link CmiItemTags#NO_STACK_UPGRADE} 标签。
 * <p>
 * 带此标签的物品将绕过 Sophisticated Backpacks 与 Functional Storage 的堆叠/容量倍率，
 * 表现得像目标存储未安装任何 Stack Upgrade。
 */
public final class CmiStackUpgradeHelper {
	private CmiStackUpgradeHelper() {
	}

	public static boolean isNoStackUpgrade(ItemStack stack) {
		return !stack.isEmpty() && stack.is(CmiItemTags.NO_STACK_UPGRADE);
	}

	public static boolean isNoStackUpgrade(Item item) {
		return item != null && item.builtInRegistryHolder().is(CmiItemTags.NO_STACK_UPGRADE);
	}
}
