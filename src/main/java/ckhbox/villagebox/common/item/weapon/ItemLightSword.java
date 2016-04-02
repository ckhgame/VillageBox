package ckhbox.villagebox.common.item.weapon;

import java.util.List;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.StatCollector;

public class ItemLightSword extends ItemSword{

	public ItemLightSword() {
		super(ModItems.ToolMaterials.STEEL);
		this.setUnlocalizedName(PathHelper.full("lightSword"));
		this.setCreativeTab(ModItems.tabVB);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if(!target.worldObj.isRemote){
			Class c = target.getClass();
			if(c == EntityZombie.class || c == EntitySkeleton.class){
				target.setHealth(0); // one hit kill
			}
		}
		return super.hitEntity(stack, target, attacker);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = StatCollector.translateToLocal(PathHelper.full("info.item.lightSword"));
		tooltip.add(info);
	}
}
