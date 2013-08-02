package halliom.common.item;

import net.minecraft.item.EnumArmorMaterial;

public class Items 
{
	
	public static ItemBackPlate backPlate;
	
	public static void initializeItems()
	{
		
		backPlate = new ItemBackPlate(1000, EnumArmorMaterial.CHAIN);
		
	}
	
}
