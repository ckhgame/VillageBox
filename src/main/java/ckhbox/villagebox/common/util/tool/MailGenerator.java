package ckhbox.villagebox.common.util.tool;

import ckhbox.villagebox.common.item.common.ItemMail;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.util.math.Rand;
import net.minecraft.item.ItemStack;

public class MailGenerator {
	public static ItemStack generate(){
		
		//float r = Rand.get().nextFloat();
		
		//70%: new villager wants to join 
		//if(r < 0.7F){
			boolean male = Rand.get().nextBoolean();
			String name = male?NameGenerator.getRandomMaleName():NameGenerator.getRandomFemaleName();
			int mailType = (male?ItemMail.MailType_NewVillagerMale : ItemMail.MailType_NewVillagerFemale);
			return ItemMail.generateMail(name, PathHelper.full("mail.newvillager" + Rand.get().nextInt(3) + ".content"), mailType);
//		}
//		else{
//			return ItemMail.generateMail("Tips", PathHelper.full("mail.tip" + Rand.get().nextInt(3) + ".content"), ItemMail.MailType_Common);
//		}
	}
}
