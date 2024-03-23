package de.madluffy.justsomeadditions.utils;

import de.madluffy.justsomeadditions.JustSomeAdditions;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = JustSomeAdditions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue INFINITE_BOW = BUILDER
            .comment("Whether the Infinity Enchantment consumes tipped arrows")
            .define("trueInfinity", true);

    private static final ForgeConfigSpec.BooleanValue UNIVERSAL_BOW_ENCH = BUILDER
            .comment("Whether the Infinity Enchantment can be mixed with Mending")
            .define("universalBowEnch", true);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean trueInfinity;
    public static boolean universalBowEnch;

    @SubscribeEvent
    void onLoad(final ModConfigEvent event) {
        trueInfinity = INFINITE_BOW.get();
        universalBowEnch = UNIVERSAL_BOW_ENCH.get();

    }
}
