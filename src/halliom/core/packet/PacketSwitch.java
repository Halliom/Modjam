package halliom.core.packet;

import halliom.common.backpack.BackpackData;
import halliom.common.backpack.BackplateContainer;
import halliom.core.packet.PacketHandler.PacketType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.Player;

public class PacketSwitch extends PacketBP
{
	
	public int pos;
	 
	public PacketSwitch(int pos) 
	{
		this.pos = pos;
	}
	
	public PacketSwitch() 
	{
	}

	@Override
	public void writePacketData(DataOutputStream outputStream) 
	{
		try 
		{
			outputStream.writeInt(pos);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void readPacketData(DataInputStream inputStream) 
	{
		try 
		{
			pos = inputStream.readInt();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void performPacketAction(Player player) 
	{
		EntityPlayer entPlayer = (EntityPlayer) player;
		if (!BackpackData.playerData.containsKey(entPlayer))
		{
			BackpackData.playerData.put(entPlayer, new BackplateContainer());
		}
		entPlayer.inventory.mainInventory[entPlayer.inventory.currentItem] = BackpackData.playerData.get(entPlayer).performSwitch(pos, entPlayer.getHeldItem());
	}

	@Override
	public int getPacketID() 
	{
		return PacketType.SWITCH.ordinal();
	}
	
}
