package halliom.core;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "Backpacked", name = "Backpacked", version = "DEV")
public class Backpacked 
{
	//The mod instance
	@Instance("Backpacked")
	public static Backpacked instance = new Backpacked();
	
	//Sided proxy for client and server
	@SidedProxy(clientSide = "halliom.client.ClientProxy", serverSide = "halliom.core.Proxy")
	public static Proxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		
	}
}
