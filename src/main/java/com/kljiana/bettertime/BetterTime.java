package com.kljiana.bettertime;

import com.kljiana.bettertime.config.Config;
import mcjty.incontrol.data.DataStorage;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(BetterTime.MODID)
public class BetterTime {
    public static final String MODID = "bettertime";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
    public BetterTime(){
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.configSpec);
    }

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
        pSource.sendSuccess(Component.literal("[§a"+Component.translatable("mod.bettertime").getString()+"§r]" +Component.translatable("commands.bettertime.query", getDays(level), getHours(level), getMinutes(level), getTodayTime(level), level.getGameTime()).getString()), true);
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
        inControlSetDay(level, days);
        pSource.sendSuccess(Component.literal("[§a"+Component.translatable("mod.bettertime").getString()+"§r]" +Component.translatable("commands.bettertime.set", days, getHours(level), getMinutes(level), pTime).getString()), true);
        return getTodayTime(pSource.getLevel());
    }

    public static int setDay(CommandSourceStack pSource, long days) {
        Level level = pSource.getLevel();
        long pTime = getTodayTime(pSource.getLevel());
        for (ServerLevel serverlevel : pSource.getServer().getAllLevels()) {
            serverlevel.setDayTime((days) * 24000L + pTime);
        }
        inControlSetDay(level, days);
        pSource.sendSuccess(Component.literal("[§a"+Component.translatable("mod.bettertime").getString()+"§r]" +Component.translatable("commands.bettertime.set", days, getHours(level), getMinutes(level), pTime).getString()), true);
        return getTodayTime(pSource.getLevel());
    }

    public static void inControlSetDay(Level level, long days){
        if (ModList.get().isLoaded("incontrol")){
            DataStorage data = DataStorage.getData(level);
            data.setDaycounter((int) days);
        }
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
        pSource.sendSuccess(Component.literal("[§a"+Component.translatable("mod.bettertime").getString()+"§r]" +Component.translatable("commands.bettertime.set", days, getHours(level), getMinutes(level), i).getString()), true);
        return i;
    }
}
