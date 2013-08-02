package halliom.core;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import halliom.common.item.Items;
import halliom.core.keybinding.KeyBindingHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;

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
		//Instantiate the items and register them
		Items.initializeItems();
		
		proxy.registerEntityRendering();
		
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
		{
			KeyBinding[] keybindings = new KeyBinding[]{new KeyBinding("Change Slot 1", Keyboard.KEY_Z), new KeyBinding("Change Slot 2", Keyboard.KEY_X)};
			KeyBindingRegistry.registerKeyBinding(new KeyBindingHandler(keybindings));
		}
	}
}
