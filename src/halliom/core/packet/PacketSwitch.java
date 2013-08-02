package halliom.core.packet;

import halliom.common.backpack.BackpackData;
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
		BackpackData.playerData.containsKey(entPlayer);
	}

	@Override
	public int getPacketID() 
	{
		return PacketType.SWITCH.ordinal();
	}
	
}
