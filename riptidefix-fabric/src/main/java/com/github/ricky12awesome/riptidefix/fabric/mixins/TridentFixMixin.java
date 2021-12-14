package com.github.ricky12awesome.riptidefix.fabric.mixins;

import com.github.ricky12awesome.riptidefix.fabric.RiptideFixClient;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public class TridentFixMixin {
    @Inject(at = @At("RETURN"), method = "getDepthStrider", cancellable = true)
    private static void getDepthStrider(LivingEntity entity, CallbackInfoReturnable<Integer> cir) {
        if (RiptideFixClient.ENABLED && entity.isUsingRiptide()) {
            cir.setReturnValue(0);
        }
    }
}
