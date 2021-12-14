package com.github.ricky12awesome.riptidefix.forge.mixins;

import com.github.ricky12awesome.riptidefix.forge.RiptideFixMod;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public class TridentFixMixin {
    @Inject(at = @At("RETURN"), method = "getDepthStrider", cancellable = true)
    private static void getDepthStrider(LivingEntity entity, CallbackInfoReturnable<Integer> cir) {
        if (RiptideFixMod.ENABLED && entity.isAutoSpinAttack()) {
            cir.setReturnValue(0);
        }
    }
}
