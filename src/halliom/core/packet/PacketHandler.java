package halliom.core.packet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{
	
	public static enum PacketType
	{
		SWITCH(PacketSwitch.class);
		
		private Class clazz;
		
		private PacketType(Class clazz)
		{
			this.clazz = clazz;
		}
		
		public Class getPacketClass()
		{
			return this.clazz;
		}
	}
	
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) 
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		
		try
		{
			int id = data.readInt();
			
			PacketSwitch pkt = new PacketSwitch();
			pkt.readPacketData(data);
			pkt.performPacketAction(player);
//			break;
		}catch(Exception e)
		{
			
		}
	}
	
	private Class getClassFromID(int id) 
	{
		PacketType[] types = PacketType.values();
		
		if (id >= 0 &&  id < types.length)
		{
			return types[id].getClass();
		}
		return null;
	}

	public static Packet getPacket(PacketBP packetBP)
	{
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bo);
		
		try
		{
			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = "DAJO";
			
			data.writeInt(packetBP.getPacketID());
			packetBP.writePacketData(data);
			
			packet.data = bo.toByteArray();
			packet.length = packet.data.length;
			
			return packet;
		}catch(Exception e)
		{
			
		}
		
		return null;
	}
	
}
