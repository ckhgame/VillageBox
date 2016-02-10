package ckhbox.villagebento.common.util.tool;

import ckhbox.villagebento.common.item.mail.ItemMail;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.util.math.Rand;
import net.minecraft.item.ItemStack;

public class MailGenerator {
	public static ItemStack generate(){
		
		float r = Rand.get().nextFloat();
		
		//70%: new villager wants to join 
		if(r < 0.7F){
			return ItemMail.generateMail(NameGenerator.getRandomMaleName(), PathHelper.full("mail.newvillager" + Rand.get().nextInt(3) + ".content"), true);
		}
		else{
			return ItemMail.generateMail("Tips", PathHelper.full("mail.tip" + Rand.get().nextInt(3) + ".content"), false);
		}
	}
}
