package dev.celestiacraft.cmi.client.menu;

import cc.sighs.auratip.api.action.Actions;
import cc.sighs.auratip.api.radiamenu.RadialMenuBuilder;
import cc.sighs.auratip.api.radiamenu.RadialMenuRegistry;
import cc.sighs.auratip.data.RadialMenuData;
import com.simibubi.create.AllItems;
import dev.celestiacraft.cmi.Cmi;
import dev.celestiacraft.cmi.event.radial.CmiRadialAction;
import dev.celestiacraft.cmi.utils.ModResources;
import mekanism.common.registries.MekanismItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Map;

public class CmiRadialMenu {
	public static ResourceLocation MENU = Cmi.loadResource("radial");

	public static void register() {
		RadialMenuBuilder builder = new RadialMenuBuilder(MENU)
				.radii(55, 100)
				.animationSpeed(1.0F)
				.ringColors(List.of("#1A366699", "#D93A6EA5"));

		builder.slot(
				"Open Quests",
				ResourceLocation.parse("ftbquests:textures/item/book.png"),
				Actions.runCommand("ftbquests open_book"),
				Component.translatable("radial.cmi.open_quest"),
				"#77FFFFFF"
		);
		builder.slot(
				"Open Guide",
				ResourceLocation.parse("ae2:textures/item/guide.png"),
				Actions.runCommand("guideme open @s ae2:guide"),
				Component.translatable("radial.cmi.open_guide"),
				"#77FFFFFF"
		);
		builder.slot(
				"Open Ponder",
				ResourceLocation.parse("ponder:textures/gui/logo.png"),
				Actions.runCommand("ponder tags"),
				Component.translatable("radial.cmi.open_ponder"),
				"#77FFFFFF"
		);
		builder.slot(
				"Pickup A Wrench",
				AllItems.WRENCH.asStack(),
				Actions.script(CmiRadialAction.WRENCH, Map.of()),
				Component.translatable("radial.cmi.wrench"),
				"#77FFFFFF"
		);
		builder.slot(
				"Pickup A Network Tool",
				ModResources.NETWORK_TOOL.getItemStack(),
				Actions.script(CmiRadialAction.NETTOOL, Map.of()),
				Component.translatable("radial.cmi.net_tool"),
				"#77FFFFFF"
		);
		builder.slot(
				"Pickup A Configurator",
				MekanismItems.CONFIGURATOR.getItemStack(),
				Actions.script(CmiRadialAction.CONFIGURATOR, Map.of()),
				Component.translatable("radial.cmi.configurator"),
				"#77FFFFFF"
		);

		RadialMenuData menu = builder.build();
		RadialMenuRegistry.setMenus(Cmi.MODID, List.of(menu));
	}
}