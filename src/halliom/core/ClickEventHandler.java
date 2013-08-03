package halliom.core;

import halliom.client.gui.special.Gui3DHandler;
import halliom.core.util.Vector3f;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ClickEventHandler 
{
	
	@ForgeSubscribe
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if (event.entityPlayer.openContainer == null && Gui3DHandler.has3DGuiOpen(event.entityPlayer))
		{
			
		}
		float lookDist = 4f;
		Vector3f lookVec = new Vector3f(event.entityPlayer.getLookVec());
		Vector3f real = lookVec.mul(lookDist).add(new Vector3f((float) event.entityPlayer.posX, (float) event.entityPlayer.posY, (float) event.entityPlayer.posZ));
		
		event.entityPlayer.worldObj.spawnEntityInWorld(new EntityTNTPrimed(event.entityPlayer.worldObj, real.getX(), real.getY(), real.getZ(), event.entityPlayer));
	}
	
}
