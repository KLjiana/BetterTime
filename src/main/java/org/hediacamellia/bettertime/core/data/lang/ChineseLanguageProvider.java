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
        add("mod.bettertime", "求问时记");
        add("config.bettertime.title", "求问时记 配置");
        add("config.bettertime.showDateHud", "显示日期");
        add("config.bettertime.showDateHud.desc", "如果为true，则日期hud将显示在您的hud上");
        add("config.bettertime.showDayTitle", "显示日期标题");
        add("config.bettertime.showDayTitle.desc", "如果为true，则日期标题将显示在您的屏幕上");
        add("config.bettertime.dateX", "日期Hud X");
        add("config.bettertime.dateY", "日期Hud Y");
        add("config.bettertime.dateColor", "日期Hud 颜色");
        add("config.bettertime.comfirm", "确认");
        add("config.bettertime.hourAdd", "日期Hud 小时增加量");
        add("config.bettertime.minAdd", "日期Hud 分钟增加量");
    }
}