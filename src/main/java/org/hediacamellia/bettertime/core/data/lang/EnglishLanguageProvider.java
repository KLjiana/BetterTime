package org.hediacamellia.bettertime.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hediacamellia.bettertime.BetterTime;

public class EnglishLanguageProvider extends LanguageProvider {

    public EnglishLanguageProvider(PackOutput output) {
        super(output, BetterTime.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("commands.bettertime.set", "Set the time on Day%s, %02d:%02d (%s ticks)");
        add("commands.bettertime.banvanilla", "Please use command /bettertime !");
        add("commands.bettertime.query", "The time is day %s, %02d:%02d (Daytime: %s ticks, Gametime: %s ticks)");
        add("title.bettertime.day", "Day %s");
        add("hud.bettertime.time", "Day %d, %02d:%02d");
        add("mod.bettertime", "BetterTime");
    }
}