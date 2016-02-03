package ckhbox.villagebento.common.entity.villager;

import ckhbox.villagebento.VillageBentoMod;
import ckhbox.villagebento.common.gui.GuiIDs;
import ckhbox.villagebento.common.village.profession.ProFolk;
import ckhbox.villagebento.common.village.profession.Profession;
import ckhbox.villagebento.common.village.trading.ITrading;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import ckhbox.villagebento.common.village.trading.TradingRecipeList;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityVillager extends EntityCreature implements ITrading{

	public EntityPlayer customer;
	public Profession profession;
	
	public EntityVillager(World worldIn) {
		super(worldIn);
		//temp
		profession = Profession.registry.get(ProFolk.class);
	}

	@Override
	protected boolean interact(EntityPlayer player) {
		
		if(!player.worldObj.isRemote){
			player.openGui(VillageBentoMod.instance, GuiIDs.VillagerTrading, player.worldObj, this.dimension, this.getEntityId(), -1);
		}
		
		return super.interact(player);
	}

	@Override
	public TradingRecipeList getTradingRecipeList() {
		return this.profession.getTradingRecipeList();
	}



	
}
