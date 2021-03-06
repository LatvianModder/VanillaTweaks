package io.github.strikerrocker.vt.proxies;

import io.github.strikerrocker.vt.items.VTItems;
import io.github.strikerrocker.vt.misc.BehaviorDispenseDynamite;
import io.github.strikerrocker.vt.misc.VTUtils;
import io.github.strikerrocker.vt.worldgen.NetherPocketer;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * The common (dual-side) proxy for Vanilla Tweaks
 */

public class VTCommonProxy {

    public void registerItemRenderer(Item item, int meta, String id) {
    }
    public void init(FMLInitializationEvent event) {
        MinecraftForge.TERRAIN_GEN_BUS.register(new NetherPocketer());
        VTUtils.registerDispenserBehavior(VTItems.dynamite, new BehaviorDispenseDynamite());
    }

}