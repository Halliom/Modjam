package halliom.core.keybinding;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeyBindingHandler extends KeyHandler
{

	public KeyBindingHandler(KeyBinding[] keyBindings) 
	{
		super(keyBindings);
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
					System.out.println(kb.keyDescription);
				}
				if (kb.keyDescription.equals("Change Slot 1"))
				{
					System.out.println(kb.keyDescription);
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
	
}
