package org.hediacamellia.bettertime.core.time;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

public class B2Time {

    public static int getTodayTime(Level pLevel) {
        return (int) (pLevel.getDayTime() % 24000L);
    }

    public static long getDays(Level pLevel) {
        return pLevel.getDayTime() / 24000L;
    }

    public static long getHours(Level pLevel) {
        return (pLevel.getDayTime() % 24000) / 1000;
    }

    public static long getMinutes(Level pLevel) {
        return (pLevel.getDayTime() % 1000) * 60 / 1000;
    }


    public static int queryTime(CommandSourceStack pSource) {
        Level level = pSource.getLevel();
        pSource.sendSuccess(() -> Component.translatable("commands.bettertime.query", getDays(level), getHours(level), getMinutes(level), getTodayTime(level), level.getGameTime()), false);
        return 0;
    }

    public static int setTime(CommandSourceStack pSource, long pTime) {
        return setTime(pSource, pTime, getDays(pSource.getLevel()));
    }

    public static int setTime(CommandSourceStack pSource, long pTime, long days) {
        Level level = pSource.getLevel();
        for (ServerLevel serverlevel : pSource.getServer().getAllLevels()) {
            serverlevel.setDayTime((days) * 24000L + pTime);
        }
        pSource.sendSuccess(() -> Component.translatable("commands.bettertime.set", days, getHours(level), getMinutes(level), pTime), true);
        return getTodayTime(pSource.getLevel());
    }

    public static int addTime(CommandSourceStack pSource, int pAmount) {
        return addTime(pSource, pAmount, getDays(pSource.getLevel()));
    }

    public static int addTime(CommandSourceStack pSource, int pAmount, long days) {
        Level level = pSource.getLevel();
        for (ServerLevel serverlevel : pSource.getServer().getAllLevels()) {
            serverlevel.setDayTime(serverlevel.getDayTime() + (long) pAmount);
        }

        int i = getTodayTime(pSource.getLevel());
        pSource.sendSuccess(() -> Component.translatable("commands.bettertime.set", days, getHours(level), getMinutes(level), i), true);
        return i;
    }
}
