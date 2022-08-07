package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;


public class ExampleBiome implements ModInitializer, TerraBlenderApi {
	public static final Logger LOGGER = LoggerFactory.getLogger("example");

	@Override
	public void onInitialize() {
		InitConfigRegister.init();
		InitBiomeObject.init();
		LOGGER.info("Hello Fabric world!");
	}

	@Override
	public void onTerraBlenderInitialized() {
		// Mainly just needed to support locatebiomes and such
		Regions.register(new InitRegionObject(new Identifier("example", "overworld"), 1));

		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "example", InitSurfaceRulesObject.build());
	}

}
