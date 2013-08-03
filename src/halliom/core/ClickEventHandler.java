package halliom.core;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ClickEventHandler 
{
	
	@ForgeSubscribe
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if (event.entityPlayer.openContainer == null)
		{
			
		}
	}
	
}
