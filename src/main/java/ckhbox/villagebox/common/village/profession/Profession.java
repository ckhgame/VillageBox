package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.config.VBConfig;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.util.math.Rand;
import ckhbox.villagebox.common.util.registry.IRegistrable;
import ckhbox.villagebox.common.util.registry.Registry;
import ckhbox.villagebox.common.village.trading.TradingRecipeList;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public abstract class Profession implements IRegistrable{
	
	private int regID;
	//trading recipe list
	protected TradingRecipeList tradingRecipeList = new TradingRecipeList();
	//texture
	protected ResourceLocation texturem;
	protected ResourceLocation texturef;
	
	//what professions can upgrade from this profession
	protected Class<? extends Profession>[] upgradeToNextOptionClasses;
	protected Profession[] upgradeToNextOptions;//this will be automatically generated based on option classes
	//what items are needed to upgrade to this profession(usually only gems, maximum: 3 stacks)
	protected ItemStack[] upgradeToCurentNeeds;
	//what items the villager will hold (will randomly select if there are more than 1 items in the list)
	protected ItemStack[] holdItems;
	
	@Override
	public int getRegID() {
		return regID;
	}

	@Override
	public void setRegID(int regID) {
		this.regID = regID;
	}
	
	public Profession(){
		this.initTradingRecipeList();
		this.initTexture();
		this.initUpgradeOptions();
		this.initHoldItems();
	}
	
	public Profession[] getUpgradeToNextOptions(){
		if(this.upgradeToNextOptions == null){
			if(this.upgradeToNextOptionClasses != null && this.upgradeToNextOptionClasses.length > 0){
				ArrayList<Profession> list = new ArrayList<Profession>();
				for(int i = 0;i<this.upgradeToNextOptionClasses.length;i++){
					Profession p = Profession.registry.get(this.upgradeToNextOptionClasses[i]);		
					if(!isProIDBanned(p.getRegID())){
						list.add(p);
					}

				}
				if(list.size() > 0){
					this.upgradeToNextOptions = list.toArray(new Profession[list.size()]);
				}
			}
		}
		return this.upgradeToNextOptions;
	}
	
	private boolean isProIDBanned(int proid){
		if(VBConfig.proIDBanList == null)
			return false;
		else{
			for(int i =0;i<VBConfig.proIDBanList.length;i++){
				if(proid == VBConfig.proIDBanList[i])
					return true;
			}
			return false;
		}
	}
	
	public ItemStack[] getUpgradeToCurentNeeds(){
		return VBConfig.freeUpgrading?null:this.upgradeToCurentNeeds;
	}
	
	public ResourceLocation getTexture(boolean male){
		return male?this.texturem:this.texturef;
	}
	
	public TradingRecipeList getTradingRecipeList(){
		return this.tradingRecipeList;
	}
	
	public ItemStack getRandomHoldItem(){
		if(Rand.get().nextFloat() < 0.6F || this.holdItems == null || this.holdItems.length < 1)
			return null;
		else
			return this.holdItems[Rand.get().nextInt(this.holdItems.length)];
	}
	
	public String getDisplayName(){
		String name = I18n.format(this.getUnlocalized() + ".name");
		if(VBConfig.displayExtraInfo) name += "(ID:" + this.getRegID() + ")";
		return name;
	}
	
	public String getDescription(){
		return I18n.format(this.getUnlocalized() + ".desc");
	}
	
	protected void createTextures(String name){
		this.texturem = new ResourceLocation(PathHelper.full("textures/entity/villager/" + name + "_m.png"));
		this.texturef = new ResourceLocation(PathHelper.full("textures/entity/villager/" + name + "_f.png"));
	}
	
	//abstract functions
	protected abstract void initTradingRecipeList();
	protected abstract void initTexture();
	protected abstract void initUpgradeOptions();
	protected abstract void initHoldItems();
	protected abstract String getUnlocalized();
	
	
	//---------------------------------
	//registry
	public static Registry<Profession> registry = new Registry<Profession>();
	
	public static void init(){
		registry.register(0, new ProVillager0());
		registry.register(1, new ProVillager1());
		registry.register(2, new ProVillager2());
		registry.register(3, new ProPeasant());
		registry.register(4, new ProMiner());
		registry.register(5, new ProAlchemist());
		registry.register(6, new ProShaman());
		registry.register(7, new ProArmorsmith());
		registry.register(8, new ProBlacksmith());
		registry.register(9, new ProToolsmith());
		registry.register(10, new ProBowmaker());
		registry.register(11, new ProCarpenter());
		registry.register(12, new ProCarpetMakerAdevanced());
		registry.register(13, new ProCarpetMakerCartoony());
		registry.register(14, new ProCarpetmaker());
		registry.register(15, new ProFisherman());
		registry.register(16, new ProFlorist());
		registry.register(17, new ProFurnituremaker());
		registry.register(18, new ProOrchardist());
		registry.register(19, new ProPainter());
		registry.register(20, new ProRancher());
		registry.register(21, new ProScholar());
		registry.register(22, new ProVintner());
		registry.register(23, new ProWeaponsmith());
		registry.register(24, new ProMage());
		registry.register(25, new ProWorker());
		registry.register(26, new ProCookAssistant());
		registry.register(27, new ProFarmer());
		registry.register(28, new ProBookseller());
		registry.register(29, new ProBanker());
		registry.register(30, new ProChef());
		registry.register(31, new ProChefDessert());
		registry.register(32, new ProBuilder());
		registry.register(33, new ProMagicCrafter());
		
				
		//caveman
		registry.register(99999, new ProCaveman());
	}

}
