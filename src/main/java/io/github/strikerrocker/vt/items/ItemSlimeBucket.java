package io.github.strikerrocker.vt.items;

import io.github.strikerrocker.vt.handlers.ConfigHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import static io.github.strikerrocker.vt.events.VTEventHandler.isSlimeChunk;
import static net.minecraft.util.text.TextFormatting.AQUA;

public class ItemSlimeBucket extends Item {

    public ItemSlimeBucket(String name) {
        this.setCreativeTab(CreativeTabs.MISC);
        this.setMaxStackSize(1);
        this.setTranslationKey(name);
        this.setRegistryName(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote && ConfigHandler.vanilla_tweaks.slimeChunkFinder) {
            if (playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isItemEqual(new ItemStack(VTItems.slime))) {
                int x = MathHelper.floor(playerIn.posX);
                int y = MathHelper.floor(playerIn.posY);
                boolean slime = isSlimeChunk(worldIn, x, y);
                if (slime) {
                    playerIn.sendStatusMessage(new TextComponentString("Slime Chunk" + AQUA), true);
                }
            }
        }
        return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
