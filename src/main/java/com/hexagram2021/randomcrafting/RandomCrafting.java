package com.hexagram2021.randomcrafting;

import com.hexagram2021.randomcrafting.command.RCCommands;
import com.hexagram2021.randomcrafting.config.RCCommonConfig;
import com.hexagram2021.randomcrafting.config.RCServerConfig;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraftforge.fml.config.ModConfig;

public class RandomCrafting implements ModInitializer {
    public static final String MODID = "randomcrafting";

    public RandomCrafting() {
        ForgeConfigRegistry.INSTANCE.register(MODID, ModConfig.Type.SERVER, RCServerConfig.SPEC);
        ForgeConfigRegistry.INSTANCE.register(MODID, ModConfig.Type.COMMON, RCCommonConfig.SPEC);
    }

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            if(!RCServerConfig.DISABLE.get()) {
                RCCommands.messup(server);
            }
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(RCCommands.register()));
    }
}
