package org.hediacamellia.bettertime.core.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hediacamellia.bettertime.core.config.Config;
import org.hediacamellia.bettertime.core.command.B2TimeCommand;
import org.hediacamellia.bettertime.core.time.B2Time;


@EventBusSubscriber
public final class NeoForgeEvent {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        B2TimeCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void showTime(RenderGuiEvent.Pre event){
        if (!Config.showDateHud.get()) return;
        GuiGraphics guiGraphics = event.getGuiGraphics();
        Minecraft minecraft = Minecraft.getInstance();
        Level level = minecraft.level;
        Font font = minecraft.font;

        if (level == null) return;
        MutableComponent time = Component.translatable("hud.bettertime.time", B2Time.getDays(level), B2Time.getHours(level), B2Time.getMinutes(level));
        guiGraphics.drawString(
                font,
                time,
                Config.dateX.get(),
                Config.dateY.get(),
                Config.dateColor.get()
        );
    }
}
