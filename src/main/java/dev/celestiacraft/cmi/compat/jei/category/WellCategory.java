package dev.celestiacraft.cmi.compat.jei.category;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import dev.celestiacraft.cmi.api.client.CmiLang;
import dev.celestiacraft.cmi.common.recipe.well.SeaWaterWellRecipe;
import dev.celestiacraft.cmi.common.recipe.well.WaterWellRecipe;
import dev.celestiacraft.cmi.common.recipe.well.WellRecipe;
import dev.celestiacraft.cmi.common.register.CmiBlock;
import dev.celestiacraft.cmi.compat.jei.api.CmiGuiTextures;
import dev.celestiacraft.cmi.compat.jei.api.CmiJeiRecipeType;
import dev.celestiacraft.cmi.compat.jei.category.structure.WaterWellStructure;
import dev.celestiacraft.cmi.utils.ModResources;
import dev.celestiacraft.libs.client.ClientRenderUtils;
import dev.celestiacraft.libs.compat.jei.categoty.SimpleJeiCategory;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;

import java.util.Collections;

public class WellCategory {
	private static final WaterWellStructure WATER_WELL = new WaterWellStructure();

	public static SimpleJeiCategory<WellRecipe> builder(IGuiHelper helper) {
		return SimpleJeiCategory.builder(CmiJeiRecipeType.WELL, helper)
				.setTitle(CmiLang.JeiLang.setTranCategoryTitle("well"))
				.setSize(178, 72)
				.setIcon(CmiBlock.WATER_WELL.get().asItem().getDefaultInstance())
				.setBackground(0, 0)
				.setRecipe((builder, recipe, group) -> {
					if (recipe instanceof WaterWellRecipe water) {
						builder.addSlot(RecipeIngredientRole.OUTPUT, 150, 30)
								.setBackground(CreateRecipeCategory.getRenderedSlot(), -1, -1)
								.addFluidStack(Fluids.WATER, Integer.MAX_VALUE)
								.addItemStack(Items.WATER_BUCKET.getDefaultInstance());
					} else if (recipe instanceof SeaWaterWellRecipe seaWater) {
						builder.addSlot(RecipeIngredientRole.OUTPUT, 150, 30)
								.setBackground(CreateRecipeCategory.getRenderedSlot(), -1, -1)
								.addFluidStack(ModResources.SEA_WATER.getFluid(), Integer.MAX_VALUE)
								.addItemStack(ModResources.SEA_WATER.getBucketStack());
					}
				})
				.setTooltips((recipe, view, mouseX, mouseY) -> {
					if (recipe instanceof WaterWellRecipe water) {
						if (ClientRenderUtils.isCursorInsideBounds(102, 21, 14, 14, mouseX, mouseY)) {
							return ImmutableList.of(Component.translatable("jei.category.cmi.water_pump.complete"));
						}
					} else if (recipe instanceof SeaWaterWellRecipe seaWater) {
						if (ClientRenderUtils.isCursorInsideBounds(86, 21, 14, 14, mouseX, mouseY)) {
							return ImmutableList.of(Component.translatable("jei.category.cmi.water_pump.complete"));
						}
						if (ClientRenderUtils.isCursorInsideBounds(102, 21, 14, 14, mouseX, mouseY)) {
							return ImmutableList.of(Component.translatable("jei.category.cmi.water_pump.ocean"));
						}
						if (ClientRenderUtils.isCursorInsideBounds(118, 21, 14, 14, mouseX, mouseY)) {
							return ImmutableList.of(Component.translatable("jei.category.cmi.water_pump.pos"));
						}
					}
					return Collections.emptyList();
				})
				.setDraw((recipe, view, graphics, mouseX, mouseY) -> {
					if (recipe instanceof WaterWellRecipe water) {
						CmiGuiTextures.WATER_PUMP_ARROW.render(graphics, 80, 20);
						WATER_WELL.draw(graphics, 30, 5);
						PoseStack pose = graphics.pose();
						pose.popPose();
					} else if (recipe instanceof SeaWaterWellRecipe seaWater) {
						CmiGuiTextures.WATER_PUMP_SEA_WATER_ARROW.render(graphics, 80, 20);
						WATER_WELL.draw(graphics, 30, 5);
						PoseStack pose = graphics.pose();
						pose.popPose();
					}
				})
				.build();
	}
}