package ckhbox.villagebox.common.item.weapon;

import java.util.List;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemNatureSword extends ItemSword{

	public ItemNatureSword() {
		super(ModItems.ToolMaterials.STEEL);
		this.setUnlocalizedName(PathHelper.full("natureSword"));
		this.setCreativeTab(ModItems.tabVB);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if(!target.worldObj.isRemote){		
			if(target instanceof EntityMob){
				target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,160,2));
				target.addPotionEffect(new PotionEffect(Potion.poison.id,160,2));
			}
		}
		return super.hitEntity(stack, target, attacker);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = I18n.format(PathHelper.full("info.item.natureSword"));
		tooltip.add(info);
	}
}
