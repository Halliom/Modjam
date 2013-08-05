package halliom.core.packet;

import halliom.common.backpack.BackpackData;
import halliom.common.item.ItemBackPlate;
import halliom.core.Backpacked;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.network.Player;

public class PacketOpenBackPack extends PacketBP
{
	
	public PacketOpenBackPack()
	{
	}
	
	@Override
	public void writePacketData(DataOutputStream outputStream) 
	{
	}
	
	@Override
	public void readPacketData(DataInputStream inputStream) 
	{
	}
	
	@Override
	public int getPacketID() 
	{
		return 1;
	}
	
	@Override
	public void performPacketAction(Player player) 
	{
		EntityPlayer s_player = (EntityPlayer) player;
		if (BackpackData.playerData.containsKey(s_player) && s_player.inventory.armorInventory[2].getItem() instanceof ItemBackPlate)
		{
			s_player.openGui(Backpacked.instance, 0, s_player.worldObj, (int)s_player.posX, (int)s_player.posY, (int)s_player.posZ);
		}
	}
	
}
