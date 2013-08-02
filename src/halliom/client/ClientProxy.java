package halliom.client;

import halliom.core.Proxy;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends Proxy
{

	@Override
	public int getArmourRenderPrefix(String path) 
	{
		return RenderingRegistry.addNewArmourRendererPrefix(path);
	}
	
	@Override
	public void registerEntityRendering() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new BackItemRenderer());
	}
	
}
