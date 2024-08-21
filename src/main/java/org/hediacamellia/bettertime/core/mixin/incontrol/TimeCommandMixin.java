package org.hediacamellia.bettertime.core.mixin.incontrol;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import org.hediacamellia.bettertime.core.time.B2Time;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "mcjty.incontrol.commands.CmdDays", remap = false)
public class TimeCommandMixin {
    @Inject(method = "setDays", at = @At(value = "HEAD"))
    private static void changeDays(CommandContext<CommandSourceStack> context, CallbackInfoReturnable<Integer> cir){
        B2Time.setDay(context.getSource(), IntegerArgumentType.getInteger(context, "number"));
    }
}
