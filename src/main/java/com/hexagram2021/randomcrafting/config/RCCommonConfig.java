package com.hexagram2021.randomcrafting.config;

import com.google.common.collect.ImmutableList;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class RCCommonConfig {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<List<? extends String>> WHITELIST_RECIPE_TYPES;
	public static final ModConfigSpec.ConfigValue<List<? extends String>> WHITELIST_RECIPES;
	
	static {
		BUILDER.push("randomcrafting-common-config");
			WHITELIST_RECIPE_TYPES = BUILDER.comment("The whitelist of recipe types that will not be messed up by this mod. For example, \"smithing\" to keep smithing table recipes (upgrading diamond gear to netherite gear) away from messing up.")
					.defineList("WHITELIST_RECIPE_TYPES", ImmutableList.of(
							new ResourceLocation("emeraldcraft", "melter").toString(),
							new ResourceLocation("smithing_trim").toString()
					), o -> ResourceLocation.isValidResourceLocation((String)o));
			WHITELIST_RECIPES = BUILDER.comment("The whitelist of recipes that will not be messed up by this mod. For example, \"minecraft:stick\" to make sure two planks are always crafted into four sticks.")
					.defineList("WHITELIST_RECIPES", ImmutableList.of(
							new ResourceLocation("map").toString()
					), o -> ResourceLocation.isValidResourceLocation((String)o));
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
