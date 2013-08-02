package halliom.core;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;

@Mod(modid = "Backpacked", name = "Backpacked", version = "DEV")
public class Backpacked 
{
	//The mod instance
	@Instance("Backpacked")
	public static Backpacked instance = new Backpacked();
	
	//
	@SidedProxy(clientSide = "halliom.client.ClientProxy", serverSide = "halliom.core.Proxy")
	public static Proxy proxy;
}
