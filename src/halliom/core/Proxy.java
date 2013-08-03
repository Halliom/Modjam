package halliom.core;

import halliom.common.backpack.BackpackTickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class Proxy
{
	
	public int getArmourRenderPrefix(String path)
	{
		return 0;
	}
	
	public void registerEntityRendering()
	{
		
	}
	
	public void registerTileRendering()
	{
		
	}
	
	public void registerKeyBindingHandler()
	{
		
	}
	
	public void registerTickHandler()
	{	
		TickRegistry.registerTickHandler(new BackpackTickHandler(), Side.SERVER);
	}
	
}
