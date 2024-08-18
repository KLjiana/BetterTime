package com.kljiana.bettertime.mixin.combat;

import com.kljiana.bettertime.BetterTime;
import com.mojang.brigadier.context.CommandContext;
import mcjty.incontrol.commands.CmdDays;
import net.minecraft.commands.CommandSourceStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Pseudo
@Mixin(value = CmdDays.class, remap = false)
public class InControlTimeCommandMixin {
    @Inject(method = "setDays", at = @At(value = "HEAD"))
    private static void changeDays(CommandContext<CommandSourceStack> context, CallbackInfoReturnable<Integer> cir){
        BetterTime.setDay(context.getSource(), context.getArgument("number", Integer.class));
    }
}
