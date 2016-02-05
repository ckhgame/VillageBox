package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.util.registry.IRegistrable;
import ckhbox.villagebento.common.util.registry.Registry;
import ckhbox.villagebento.common.village.trading.TradingRecipeList;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public abstract class Profession implements IRegistrable{
	
	private int regID;
	//trading recipe list
	protected TradingRecipeList tradingRecipeList = new TradingRecipeList();
	//texture
	protected ResourceLocation texture;
	
	//what professions can upgrade from this profession
	protected Class<? extends Profession>[] upgradeToNextOptionClasses;
	protected Profession[] upgradeToNextOptions;//this will be automatically generated based on option classes
	//what items are needed to upgrade to this profession(usually only gems, maximum: 3 stacks)
	protected ItemStack[] upgradeToCurentNeeds;
	
	protected int maxEnegy;
	protected int maxProficiency;
	
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
		this.initAttributes();
		this.initTexture();
		this.initUpgradeOptions();
	}
	
	public Profession[] getUpgradeToNextOptions(){
		if(this.upgradeToNextOptions == null){
			if(this.upgradeToNextOptionClasses != null && this.upgradeToNextOptionClasses.length > 0){
				this.upgradeToNextOptions = new Profession[this.upgradeToNextOptionClasses.length];
				for(int i = 0;i<this.upgradeToNextOptionClasses.length;i++){
					this.upgradeToNextOptions[i] = Profession.registry.get(this.upgradeToNextOptionClasses[i]);
				}
			}
		}
		return this.upgradeToNextOptions;
	}
	
	public ItemStack[] getUpgradeToCurentNeeds(){
		return this.upgradeToCurentNeeds;
	}
	
	public int getMaxEnegy(){
		return this.maxEnegy;
	}
	
	public int getMaxProficiency(){
		return this.maxProficiency;
	}
	
	public ResourceLocation getTexture(){
		return this.texture;
	}
	
	public TradingRecipeList getTradingRecipeList(){
		return this.tradingRecipeList;
	}
	
	public String getDisplayName(){
		return StatCollector.translateToLocal(this.getUnlocalized() + ".name");
	}
	
	public String getDescription(){
		return StatCollector.translateToLocal(this.getUnlocalized() + ".desc");
	}
	
	
	//abstract functions
	protected abstract void initTradingRecipeList();
	protected abstract void initAttributes();
	protected abstract void initTexture();
	protected abstract void initUpgradeOptions();
	protected abstract String getUnlocalized();
	
	
	//---------------------------------
	//registry
	public static Registry<Profession> registry = new Registry<Profession>();
	
	public static void init(){
		int id = 0;
		registry.register(id++, new ProVillager());
		registry.register(id++, new ProFarmer());
		registry.register(id++, new ProMiner());
	}

}
