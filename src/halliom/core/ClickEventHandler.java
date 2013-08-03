package halliom.core;

import halliom.client.gui.special.Gui3DHandler;
import halliom.core.util.Vector3f;
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
			if (event.entityPlayer.openContainer == null && Gui3DHandler.has3DGuiOpen(event.entityPlayer))
			{
				float lookDist = 4f;
				Vector3f lookVec = new Vector3f(event.entityPlayer.getLookVec());
				Vector3f real = lookVec.mul(lookDist).add(new Vector3f((float) event.entityPlayer.posX, (float) event.entityPlayer.posY, (float) event.entityPlayer.posZ));
				
				Gui3DHandler.getOpenGui(event.entityPlayer).handleClick(real, face);
			}
		}
	}
	
}
