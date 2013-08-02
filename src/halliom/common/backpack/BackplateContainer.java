package halliom.common.backpack;

import halliom.common.item.ItemBackpack;
import net.minecraft.item.ItemStack;


public class BackplateContainer 
{
	
	private ItemStack[] inventory = new ItemStack[2];
	
	public ItemStack performSwitch(int pos, ItemStack item)
	{
		if (item.getItem() instanceof ItemBackpack)
	}
}
