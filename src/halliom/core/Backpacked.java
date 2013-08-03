package halliom.core;

import halliom.common.block.Blocks;
import halliom.common.item.Items;
import halliom.core.packet.PacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "Backpacked", name = "Backpacked", version = "DEV")
@NetworkMod(channels = {"DAJO"}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
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
		//Instantiate the items and register them
		Items.initializeItems();
		
		Blocks.initializeBlocks();
		
		//Register the rendering for all entities
		proxy.registerEntityRendering();
		
		//Registers the tile entity special renderers
		proxy.registerTileRendering();
		
		//Register the keybinding handler
		proxy.registerKeyBindingHandler();
		
		//Registers the tickhandler for the backpacks
		proxy.registerTickHandler();
	}
}
