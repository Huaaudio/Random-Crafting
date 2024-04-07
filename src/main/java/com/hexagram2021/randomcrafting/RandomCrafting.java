package com.hexagram2021.randomcrafting;

import com.hexagram2021.randomcrafting.command.RCCommands;
import com.hexagram2021.randomcrafting.config.RCServerConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class RandomCrafting implements ModInitializer {
    public static final String MODID = "randomcrafting";

    public RandomCrafting() {
        ModLoadingContext.registerConfig(MODID, ModConfig.Type.SERVER, RCServerConfig.SPEC);
    }

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            if(!RCServerConfig.DISABLE.get()) {
                RCCommands.messup(server);
            }
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> dispatcher.register(RCCommands.register()));
    }
}
