package halliom.client;

import halliom.core.Proxy;
import halliom.core.keybinding.KeyBindingHandler;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
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
	
	@Override
	public void registerKeyBindingHandler() 
	{
		KeyBindingRegistry.registerKeyBinding(new KeyBindingHandler());
	}
	
}
