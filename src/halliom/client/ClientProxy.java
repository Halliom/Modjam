package halliom.client;

import halliom.client.render.QuartzCauldronRenderer;
import halliom.common.tile.TileQuartzCauldron;
import halliom.core.Proxy;
import halliom.core.keybinding.KeyBindingHandler;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends Proxy
{

	public static int QUARTZ_CAULDRON_RENDER_ID;
	
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
	public void registerTileRendering() 
	{
		QUARTZ_CAULDRON_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileQuartzCauldron.class, new QuartzCauldronRenderer());
	}
	
	@Override
	public void registerKeyBindingHandler() 
	{
		KeyBindingRegistry.registerKeyBinding(new KeyBindingHandler());
	}
	
}
