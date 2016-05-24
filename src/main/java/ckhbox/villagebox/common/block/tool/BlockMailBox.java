package ckhbox.villagebox.common.block.tool;

import ckhbox.villagebox.common.block.common.BlockFacing;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.player.ExtendedPlayerProperties;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.util.tool.MailGenerator;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class BlockMailBox extends BlockFacing{
	
	public BlockMailBox() {
		super(Material.wood);
		this.setUnlocalizedName(PathHelper.full("mailbox"));
		this.setHardness(2.5F);
		this.setStepSound(SoundType.WOOD);
		this.setCreativeTab(ModItems.tabVB);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		if(!worldIn.isRemote){		
			if(playerIn.getHeldItem(hand) != null && playerIn.getHeldItem(hand).getItem() == ModItems.invitation){
				if(ExtendedPlayerProperties.get(playerIn).hasSentInvitation){
					playerIn.addChatMessage(new TextComponentTranslation(PathHelper.full("message.mail.invitefailed")));
				}
				else{
					if (!playerIn.capabilities.isCreativeMode)
					{
						ItemStack stack= playerIn.getHeldItem(hand);
						--stack.stackSize;
					
					    if (stack.stackSize <= 0)
					    {
					        playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, (ItemStack)null);
					    }
					}
					ExtendedPlayerProperties.get(playerIn).sendNewVillagerInvitation();
					playerIn.addChatMessage(new TextComponentTranslation(PathHelper.full("message.mail.invitesuccess")));
				}
			}
			else{
				if(ExtendedPlayerProperties.get(playerIn).hasNewVillagerMail()){
					//get mail
					ExtendedPlayerProperties.get(playerIn).receiveNewVillagerMail();
					ItemStack mail = MailGenerator.generate(); 
					//drop mail
		            double x = (double)pos.getX() + 0.5D;
		            double y = (double)pos.getY() + 0.5D;
		            double z = (double)pos.getZ() + 0.5D;
		            EntityItem entityitem = new EntityItem(worldIn, x, y, z, mail);
		            
	                double d1 = playerIn.posX - x;
	                double d3 = playerIn.posY - y;
	                double d5 = playerIn.posZ - z;
	                double d7 = (double)MathHelper.sqrt_double(d1 * d1 + d3 * d3 + d5 * d5);
	                double d9 = 0.08D;
	                entityitem.motionX = d1 * d9;
	                entityitem.motionY = d3 * d9 + (double)MathHelper.sqrt_double(d7) * 0.05D;
	                entityitem.motionZ = d5 * d9;
	                
		            entityitem.setDefaultPickupDelay();
		            worldIn.spawnEntityInWorld(entityitem);
				}
				else{
					playerIn.addChatMessage(new TextComponentTranslation(PathHelper.full("message.mail.nomail")));
				}
			}
			

		}
		
		return true;
	}
	
}
