package org.hediacamellia.bettertime.core.debug;


import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.fml.loading.FMLEnvironment;
import org.hediacamellia.bettertime.BetterTime;
import org.hediacamellia.bettertime.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Debug {

    private static String prefix = "[§a求问史记§r]";
    private static Boolean debugConfig = Config.DEBUG.get();
    private static Logger logger = LoggerFactory.getLogger(BetterTime.MODID);


    public static void debug(String message){
        if(debugConfig)
            logger.debug(message);
    }

    public static void debug(String message, Throwable t){
        if(debugConfig)
            logger.debug(message,t);
    }

    public static void debug(String format, Object arg) {
        if(debugConfig)
            logger.debug(format, arg);
    }

    public static Logger getLogger(){
        return logger;
    }

    //客户端调试信息
    public static void send(String string) {
        if (FMLEnvironment.dist.isClient()) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null && debugConfig) {
                mc.player.sendSystemMessage(Component.literal(prefix + string));
            }
        }
    }

    //服务端调试信息
    public static void send(String string, Player player) {
        Level level = player.level();
        if(!level.isClientSide && debugConfig) {
            player.sendSystemMessage(Component.literal(prefix  + string));
        }
    }
}

