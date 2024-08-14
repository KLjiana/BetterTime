package com.kljiana.bettertime;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(BetterTime.MODID)
public class BetterTime {
    public static final String MODID = "bettertime";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public static int getToDayTime(ServerLevel pLevel) {
        return (int)(pLevel.getDayTime() % 24000L);
    }

    public static int getDays(ServerLevel pLevel) {
        return (int)(pLevel.getDayTime() / 24000L);
    }

    public static int queryTime(CommandSourceStack pSource) {
        pSource.sendSuccess(() -> Component.translatable("commands.bettertime.query", getDays(pSource.getLevel()), getToDayTime(pSource.getLevel()), pSource.getLevel().getGameTime()), false);
        return 0;
    }

    public static int setTime(CommandSourceStack pSource, int pTime) {
        return setTime(pSource, pTime, getDays(pSource.getLevel()));
    }

    public static int setTime(CommandSourceStack pSource, int pTime, int days) {
        for (ServerLevel serverlevel : pSource.getServer().getAllLevels()) {
            serverlevel.setDayTime((days) * 24000L + pTime);
        }
        pSource.sendSuccess(() -> Component.translatable("commands.bettertime.set", days, pTime), true);
        return getToDayTime(pSource.getLevel());
    }

    public static int addTime(CommandSourceStack pSource, int pAmount) {
        return addTime(pSource, pAmount, getDays(pSource.getLevel()));
    }

    public static int addTime(CommandSourceStack pSource, int pAmount, long days) {
        for(ServerLevel serverlevel : pSource.getServer().getAllLevels()) {
            serverlevel.setDayTime(serverlevel.getDayTime() + (long)pAmount);
        }

        int i = getToDayTime(pSource.getLevel());
        pSource.sendSuccess(() -> Component.translatable("commands.bettertime.set", days, i), true);
        return i;
    }
}
