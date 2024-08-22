package com.kljiana.bettertime.mixin.combat;

import com.kljiana.bettertime.BetterTime;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "mcjty.incontrol.commands.CmdDays", remap = false)
public class InControlTimeCommandMixin {
    @Inject(method = "setDays", at = @At(value = "HEAD"))
    private static void changeDays(CommandContext<CommandSourceStack> context, CallbackInfoReturnable<Integer> cir){
        BetterTime.setDay(context.getSource(), IntegerArgumentType.getInteger(context, "number"));
    }
}
