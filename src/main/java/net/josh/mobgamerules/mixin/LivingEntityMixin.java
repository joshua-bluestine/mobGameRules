package net.josh.mobgamerules.mixin;

import net.josh.mobgamerules.Mobgamerules;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Objects;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    /**
     * @author
     * @reason
     */
    @Overwrite
    public boolean canTarget(LivingEntity target) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        if (target instanceof PlayerEntity) {
            if (livingEntity.getWorld().getDifficulty() == Difficulty.PEACEFUL) {
                return false;
            } else {
                if (Objects.requireNonNull(livingEntity.getWorld().getServer()).getGameRules().getBoolean(Mobgamerules.DO_MOB_ATTACK)){
                    return target.canTakeDamage();
                } else {
                    return false;
                }
            }
        } else {
            return target.canTakeDamage();
        }    }

}
