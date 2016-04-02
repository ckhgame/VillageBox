package ckhbox.villagebox.common.item.weapon;

import java.util.List;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemWaterSword extends ItemSword{

	public ItemWaterSword() {
		super(ModItems.ToolMaterials.STEEL);
		this.setUnlocalizedName(PathHelper.full("waterSword"));
		this.setCreativeTab(ModItems.tabVB);
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		if(entityIn instanceof EntityPlayer){
			EntityPlayer p = (EntityPlayer)entityIn;
			if(p.inventory.currentItem == itemSlot){
				if(!p.isPotionActive(Potion.waterBreathing.id)){
					p.addPotionEffect(new PotionEffect(Potion.waterBreathing.id,40));
				}
				if(!p.isPotionActive(Potion.moveSpeed.id)){
					p.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,40,1));
				}
			}
		}
	}



	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = I18n.format(PathHelper.full("info.item.waterSword"));
		tooltip.add(info);
	}
}
