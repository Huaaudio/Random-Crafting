package com.hexagram2021.randomcrafting;

import com.hexagram2021.randomcrafting.command.RCCommands;
import com.hexagram2021.randomcrafting.config.RCCommonConfig;
import com.hexagram2021.randomcrafting.config.RCServerConfig;
import com.hexagram2021.randomcrafting.util.RCLogger;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import org.apache.logging.log4j.LogManager;

@Mod(RandomCrafting.MODID)
public class RandomCrafting {
    public static final String MODID = "randomcrafting";

    @SuppressWarnings("unused")
    public RandomCrafting(IEventBus modEventBus) {
        RCLogger.logger = LogManager.getLogger(MODID);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RCCommonConfig.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, RCServerConfig.SPEC);
        NeoForge.EVENT_BUS.addListener(RCCommands::registerCommands);
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarted(ServerStartedEvent event) {
        if(!RCServerConfig.DISABLE.get()) {
            RCCommands.messup(event.getServer());
        }
    }
}
