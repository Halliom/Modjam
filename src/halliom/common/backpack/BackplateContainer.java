package halliom.common.backpack;

import halliom.common.item.ItemBackpack;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import cpw.mods.fml.common.FMLCommonHandler;


public class BackplateContainer 
{
	
	private ItemStack[] inventory = new ItemStack[2];
	
	public ItemStack performSwitch(int pos, ItemStack item)
	{
		System.out.println(FMLCommonHandler.instance().getEffectiveSide());
		if (item == null)
		{
			ItemStack res = inventory[pos];
			inventory[pos] = null;
			return res;
		}
		if (item.getItem() instanceof ItemTool || item.getItem() instanceof ItemSword || item.getItem() instanceof ItemBow)
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
				if (inventory[0] != null && inventory[0].getItem() instanceof ItemBackpack)
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
	
	public ItemStack getLeftItem()
	{
		return inventory[0];
	}
	
	public ItemStack getRightItem()
	{
		return inventory[1];
	}
	
}
