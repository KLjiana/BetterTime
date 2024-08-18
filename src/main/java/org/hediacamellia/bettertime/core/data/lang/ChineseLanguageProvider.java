package org.hediacamellia.bettertime.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hediacamellia.bettertime.BetterTime;

public class ChineseLanguageProvider extends LanguageProvider {

    public ChineseLanguageProvider(PackOutput output) {
        super(output, BetterTime.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add("commands.bettertime.set", "已将时间设为%s天，%02d:%02d （%s刻）");
        add("commands.bettertime.banvanilla", "请使用 /bettertime 指令！");
        add("commands.bettertime.query", "现在是第%s天，%02d:%02d （当日时间为%s刻，游戏时间为%s刻）");
        add("title.bettertime.day", "第%s天");
        add("hud.bettertime.time", "第%d天, %02d:%02d");

    }
}