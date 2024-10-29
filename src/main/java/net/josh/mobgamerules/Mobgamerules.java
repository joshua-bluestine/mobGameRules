package net.josh.mobgamerules;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class Mobgamerules implements ModInitializer {
    public static GameRules.Key<GameRules.BooleanRule> DO_MOB_ATTACK;
    @Override
    public void onInitialize() {
        DO_MOB_ATTACK =
                GameRuleRegistry.register("doMobAttack",
                        GameRules.Category.MOBS,
                        GameRuleFactory.createBooleanRule(true));
    }
}
