package halliom.client.gui.special;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;

public class Gui3DHandler 
{
	
	private static HashMap<EntityPlayer, Gui3D> openGUIs = new HashMap<EntityPlayer, Gui3D>();
	
	public static boolean has3DGuiOpen(EntityPlayer player)
	{
		return openGUIs.containsKey(player);
	}
	
}
