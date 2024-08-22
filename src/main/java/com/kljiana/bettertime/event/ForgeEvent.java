package com.kljiana.bettertime.event;

import com.kljiana.bettertime.BetterTime;
import com.kljiana.bettertime.command.BetterTimeCommand;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.kljiana.bettertime.BetterTime.*;
import static com.kljiana.bettertime.config.Config.*;

@Mod.EventBusSubscriber(modid = BetterTime.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEvent {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        BetterTimeCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void showTime(RenderGuiEvent.Pre event){
        if (!showDateHud.get()) return;
        event.getPoseStack();
        PoseStack guiGraphics = event.getPoseStack();;
        Minecraft minecraft = Minecraft.getInstance();
        Level level = minecraft.level;
        Font font = minecraft.font;

        if (level == null) return;
        MutableComponent time = Component.translatable("hud.bettertime.time", getDays(level), getHours(level), getMinutes(level));
        font.draw(
                guiGraphics,
                time,
                dateX.get(),
                dateY.get(),
                dateColor.get()
        );
    }
}
