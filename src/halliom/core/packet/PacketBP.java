package halliom.core.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import cpw.mods.fml.common.network.Player;

public class PacketBP 
{
	public PacketBP() 
	{
	}
	
	public void writePacketData(DataOutputStream outputStream){}
	
	public void readPacketData(DataInputStream inputStream){}
	
	public void performPacketAction(Player player){}
	
	public int getPacketID(){return 0;}
	
}
