package io.github.strikerrocker.vt.items;


import io.github.strikerrocker.vt.VT;
import io.github.strikerrocker.vt.VTModInfo;
import io.github.strikerrocker.vt.compat.baubles.BaubleTools;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

/**
 * Contains, initializes, and registers all of VanillaTweaks's items
 */
public class VTItems {

    public static final ItemCraftingPad pad = new ItemCraftingPad("pad");
    public static final ItemDynamite dynamite = new ItemDynamite("dynamite");
    public static final Item fried_egg = new ItemFood(3, 0.6f, false).setRegistryName("friedegg").setTranslationKey("friedegg");
    public static final ItemSlimeBucket slime = new ItemSlimeBucket("slime");
    private static final ItemArmor.ArmorMaterial binocular_material = EnumHelper.addArmorMaterial("binoculars", VTModInfo.MODID + ":binoculars", 0, new int[]{0, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static final ItemArmor binocular = new ItemArmor(binocular_material, EntityEquipmentSlot.HEAD, "binoculars");
    private static final Item lens = new Item().setTranslationKey("lens").setRegistryName("lens");
    public static Item bb;
    public static ArrayList<Item> items = new ArrayList<>();


    public static void init() {
        if (VT.baubles) {
            bb = BaubleTools.initBinocularBauble();
            items.add(bb);
        }
        items.add(pad);
        items.add(dynamite);
        items.add(fried_egg);
        items.add(slime);
        items.add(binocular);
        items.add(lens);
    }

    public static void register(IForgeRegistry<Item> registry) {
        for (Item item : items) {
            registry.register(item);
        }
    }
}
