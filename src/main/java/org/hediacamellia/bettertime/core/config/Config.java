package org.hediacamellia.bettertime.core.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue DEBUG = BUILDER
            .comment("Set to true to enable debug info")
            .comment("设置为true以启用调试信息")
            .define("debug", true);


    public static final ModConfigSpec.BooleanValue showDateHud = BUILDER
            .comment("If true, a date hud will show on your hud")
            .comment("如果为true，则日期hud将显示在您的hud上")
            .define("Show Date Hud", true);


    public static final ModConfigSpec.BooleanValue showDayTitle = BUILDER
            .comment("If true, a day title will show on your screen")
            .comment("如果为true，则日期标题将显示在您的屏幕上")
            .define("Show day title", true);


    // dateX, dateY, dateColor;
    public static final ModConfigSpec.ConfigValue<Integer> dateX = BUILDER
            .comment("Date Hud X")
            .comment("日期Hud X")
            .define("Date Hud X", 10);

    public static final ModConfigSpec.ConfigValue<Integer> dateY = BUILDER
            .comment("Date Hud Y")
            .comment("日期Hud Y")
            .define("Date Hud Y", 10);

    public static final ModConfigSpec.ConfigValue<Integer> dateColor = BUILDER
            .comment("Date Hud Color")
            .comment("日期Hud 颜色")
            .define("Date Hud Color", -1);


    public static final ModConfigSpec SPEC = BUILDER.build();
}

