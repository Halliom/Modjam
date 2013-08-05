package halliom.core.keybinding;

import halliom.common.backpack.BackpackData;
import halliom.common.item.ItemBackPlate;
import halliom.core.Backpacked;
import halliom.core.packet.PacketHandler;
import halliom.core.packet.PacketOpenBackPack;
import halliom.core.packet.PacketSwitch;

import java.util.ArrayList;
import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;

public class KeyBindingHandler extends KeyHandler
{
	
	private static ArrayList<Boolean> repeatings = new ArrayList<Boolean>();
	private static ArrayList<KeyBinding> keyBinds = new ArrayList<KeyBinding>();

	public KeyBindingHandler() 
	{
		super(getKeys(), getRepeatings());
	}

	@Override
	public String getLabel() 
	{
		return "[BP]" + this.getClass().getName();
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) 
	{
		if (tickEnd && FMLClientHandler.instance().getClient().inGameHasFocus)
		{
			EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
			if (player != null)
			{
				if (kb.keyDescription.equals("Change Slot 1"))
				{
					PacketDispatcher.sendPacketToServer(PacketHandler.getPacket(new PacketSwitch(0)));
				}
				if (kb.keyDescription.equals("Change Slot 2"))
				{
					PacketDispatcher.sendPacketToServer(PacketHandler.getPacket(new PacketSwitch(1)));
				}
				if (kb.keyDescription.equals("Open backpack"))
				{
					EntityPlayer c_player = FMLClientHandler.instance().getClient().thePlayer;
					
					if (BackpackData.playerData.containsKey(c_player) && c_player.inventory.armorInventory[2].getItem() instanceof ItemBackPlate)
					{
						c_player.openGui(Backpacked.instance, 0, c_player.worldObj, (int)c_player.posX, (int)c_player.posY, (int)c_player.posZ);
					}
					
					PacketDispatcher.sendPacketToServer(PacketHandler.getPacket(new PacketOpenBackPack()));
				}
			}
		}
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) 
	{
		
	}

	@Override
	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.CLIENT);
	}
	
	private static KeyBinding[] getKeys()
	{
		keyBinds.add(new KeyBinding("Change Slot 1", Keyboard.KEY_Z));
		keyBinds.add(new KeyBinding("Change Slot 2", Keyboard.KEY_X));
		keyBinds.add(new KeyBinding("Open backpack", Keyboard.KEY_F));
		repeatings.add(false);
		repeatings.add(false);
		repeatings.add(false);
		return keyBinds.toArray(new KeyBinding[keyBinds.size()]);
	}
	
	private static boolean[] getRepeatings()
	{
		boolean[] boolArray = new boolean[repeatings.size()];
		
		for (byte i = 0; i < repeatings.size(); i++)
		{
			boolArray[i] = repeatings.get(0);
		}
		
		return boolArray;
	}
	
}
