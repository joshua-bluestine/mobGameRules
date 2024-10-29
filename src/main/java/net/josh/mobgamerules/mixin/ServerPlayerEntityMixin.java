package net.josh.domobattack.mixin;

import net.josh.domobattack.Domobattack;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {
    @Inject(method="damage", at=@At("HEAD"), cancellable = true)
    void damage(ServerWorld world, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir){
        if (source.getAttacker() instanceof MobEntity && !world.getGameRules().getBoolean(Domobattack.MOB_DAMAGE)) {
            cir.setReturnValue(false);
        }
    }
}
