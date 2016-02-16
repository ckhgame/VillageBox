package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.util.helper.PathHelper;
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
	protected ResourceLocation texturem;
	protected ResourceLocation texturef;
	
	//what professions can upgrade from this profession
	protected Class<? extends Profession>[] upgradeToNextOptionClasses;
	protected Profession[] upgradeToNextOptions;//this will be automatically generated based on option classes
	//what items are needed to upgrade to this profession(usually only gems, maximum: 3 stacks)
	protected ItemStack[] upgradeToCurentNeeds;
	
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
	
	public ResourceLocation getTexture(boolean male){
		return male?this.texturem:this.texturef;
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
	
	protected void createTextures(String name){
		this.texturem = new ResourceLocation(PathHelper.full("textures/entity/villager/" + name + "_m.png"));
		this.texturef = new ResourceLocation(PathHelper.full("textures/entity/villager/" + name + "_f.png"));
	}
	
	//abstract functions
	protected abstract void initTradingRecipeList();
	protected abstract void initTexture();
	protected abstract void initUpgradeOptions();
	protected abstract String getUnlocalized();
	
	
	//---------------------------------
	//registry
	public static Registry<Profession> registry = new Registry<Profession>();
	
	public static void init(){
		int id = 0;
		registry.register(id++, new ProVillager0());
		registry.register(id++, new ProVillager1());
		registry.register(id++, new ProVillager2());
		registry.register(id++, new ProPeasant());
		registry.register(id++, new ProMiner());
		registry.register(id++, new ProAdventurer());
		registry.register(id++, new ProAlchemist());
		registry.register(id++, new ProArmorsmith());
		registry.register(id++, new ProGardener());
		registry.register(id++, new ProBlacksmith());
		registry.register(id++, new ProBombmaker());
		registry.register(id++, new ProBowmaker());
		registry.register(id++, new ProCarpenter());
		registry.register(id++, new ProCarpetartist());
		registry.register(id++, new ProCarpetmaker());
		registry.register(id++, new ProFisherman());
		registry.register(id++, new ProFlorist());
		registry.register(id++, new ProFurnituremaker());
		registry.register(id++, new ProGastronomist());
		registry.register(id++, new ProJeweler());
		registry.register(id++, new ProMasterofalchemy());
		registry.register(id++, new ProOrchardist());
		registry.register(id++, new ProPainter());
		registry.register(id++, new ProRancher());
		registry.register(id++, new ProScholar());
		registry.register(id++, new ProCollector());
		registry.register(id++, new ProVintner());
		registry.register(id++, new ProWeaponsmith());
		registry.register(id++, new ProWizard());
		registry.register(id++, new ProGatherer());
		registry.register(id++, new ProWarlock());
		registry.register(id++, new ProCook());
		registry.register(id++, new ProFarmer());
	}

}
