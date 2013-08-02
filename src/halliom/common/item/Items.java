package halliom.common.item;

import halliom.core.Backpacked;
import net.minecraft.item.EnumArmorMaterial;
import cpw.mods.fml.common.registry.GameRegistry;

public class Items 
{
	
	public static ItemBackPlate backPlate;
	
	public static void initializeItems()
	{
		backPlate = new ItemBackPlate(1000, EnumArmorMaterial.CHAIN, Backpacked.proxy.getArmourRenderPrefix(""));
		
		GameRegistry.registerItem(backPlate, "itemBackPlate");
	}
	
}
