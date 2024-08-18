package org.hediacamellia.bettertime;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.hediacamellia.bettertime.core.config.Config;
import org.hediacamellia.bettertime.core.config.ScreenProvider;
import org.hediacamellia.bettertime.core.data.Data;
import org.hediacamellia.bettertime.core.config.ConfigScreen;

import java.util.function.Supplier;

@Mod(BetterTime.MODID)
public class BetterTime {
    public static final String MODID = "bettertime";

    public BetterTime(IEventBus modEventBus, ModContainer modContainer){
        modEventBus.addListener(Data::onGatherData);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, (Supplier<IConfigScreenFactory>) ScreenProvider::new);
    }
}
