package de.madluffy.justsomeadditions.listeners;

import de.madluffy.justsomeadditions.JustSomeAdditions;
import de.madluffy.justsomeadditions.commands.uenchant;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JustSomeAdditions.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventListener {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event){
        uenchant.register(event.getDispatcher());
    }
}