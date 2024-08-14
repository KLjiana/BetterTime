package com.kljiana.bettertime.event;

import com.kljiana.bettertime.BetterTime;
import com.kljiana.bettertime.command.BetterTimeCommand;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterTime.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEvent {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        BetterTimeCommand.register(event.getDispatcher());
    }
}
