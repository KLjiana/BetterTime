package com.kljiana.bettertime.config;

import com.kljiana.bettertime.BetterTime;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterTime.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static ForgeConfigSpec configSpec;
    public static ForgeConfigSpec.BooleanValue showDateHud, showDayTitle;
    public static ForgeConfigSpec.ConfigValue<Integer> dateX, dateY, dateColor;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("Better Time");
        System.out.println(ModList.get().getMods());
        showDateHud = builder.comment("If true, a date hud will show on your hud").define("Show Date Hud", true);
        dateX = builder.define("Date Hud X", 10);
        dateY = builder.define("Date Hud Y", 10);
        dateColor = builder.define("Date Hud Color", -1);
        showDayTitle = builder.comment("If true, a day title will show on your screen next days").define("Show day title", true);
        configSpec = builder.build();
    }
}
