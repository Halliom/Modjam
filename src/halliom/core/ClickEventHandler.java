package halliom.core;

import halliom.client.gui.special.Gui3D;
import halliom.client.gui.special.Gui3DHandler;
import halliom.core.util.Vector3f;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class ClickEventHandler 
{
	
	@ForgeSubscribe
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK)
		{
			int face = MathHelper.floor_double(event.entityPlayer.rotationYaw * 4f / 360f + 0.5d) & 3;
			if (Gui3DHandler.has3DGuiOpen(event.entityPlayer))//event.entityPlayer.openContainer == null && Gui3DHandler.has3DGuiOpen(event.entityPlayer))
			{
				Vector3f lookVec = new Vector3f(event.entityPlayer.getLookVec());
				
//				event.entityPlayer.worldObj.spawnEntityInWorld(new EntityTNTPrimed(event.entityPlayer.worldObj, (float) real.getX(), (float) real.getY(), real.getZ(), event.entityPlayer));
				Gui3DHandler.getOpenGui(event.entityPlayer).handleClick(lookVec, face, event.entityPlayer);
			}
		}
	}
	
}
