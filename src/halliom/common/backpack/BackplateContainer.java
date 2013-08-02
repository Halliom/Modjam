package halliom.common.backpack;

import halliom.common.item.ItemBackpack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;


public class BackplateContainer 
{
	
	private ItemStack[] inventory = new ItemStack[2];
	
	public ItemStack performSwitch(int pos, ItemStack item)
	{
		if (item.getItem() instanceof ItemTool)
		{
			if (item.getItem() instanceof ItemBackpack)
				if (inventory[0] == null && inventory[1] == null)
				{
					inventory[0] = item;
					return null;
				}
				else
					return item;
			else
			{
				if (inventory[0].getItem() instanceof ItemBackpack)
				{
					inventory[pos] = item;
					return inventory[0];
				}
				else
				{
					ItemStack res = inventory[pos];
					inventory[pos] = item;
					return res;
				}
			}
		}
		else
			return item;
	}
	
}
