package org.hediacamellia.bettertime.core.mixin.incontrol;

import mcjty.incontrol.data.DataStorage;
import net.minecraft.world.level.Level;
import org.hediacamellia.bettertime.core.time.B2Time;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Pseudo
@Mixin(value = DataStorage.class, remap = false)
public class TimeDataMixin {
    @Shadow
    private int daycounter;

    @Inject(method = "tickTime", at = @At(value = "RETURN"))
    private void dataTime(Level world, CallbackInfo ci){
        this.daycounter = (int) B2Time.getDays(world);
    }
}