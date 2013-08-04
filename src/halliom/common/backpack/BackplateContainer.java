package halliom.common.backpack;

import halliom.common.item.ItemBackpack;
import halliom.core.LogHelper;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.FMLCommonHandler;


public class BackplateContainer 
{
	
	private ItemStack[] inventory = new ItemStack[2];
	
	private Backpack backpack;
	
	public BackplateContainer() 
	{
		backpack = new Backpack();
	}
	
	public ItemStack performSwitch(int pos, ItemStack item)
	{
		if (item == null)
		{
			ItemStack res = inventory[pos];
			inventory[pos] = null;
			return res;
		}
		if (item.getItem() instanceof ItemTool || item.getItem() instanceof ItemSword || item.getItem() instanceof ItemBow || item.getItem() instanceof ItemBackpack)
		{
			if (item.getItem() instanceof ItemBackpack)
				if (inventory[0] == null && inventory[1] == null)
				{
					inventory[0] = item;
					if (item.getTagCompound() != null)
					{
						backpack = new Backpack();
						backpack.readFromNBT(item.getTagCompound().getCompoundTag("Backpack"));
					}
					else
						LogHelper.logError("Could not read backpack data");
					return null;
				}
				else
					return item;
			else
			{
				if (inventory[0] != null && inventory[0].getItem() instanceof ItemBackpack)
				{
					ItemStack res = inventory[0];
					if (backpack != null)
					{
						if (res.getTagCompound() == null)
							res.setTagCompound(new NBTTagCompound());
						res.getTagCompound().setCompoundTag("Backpack", backpack.destroy());
						backpack = null;
					}
					else
						LogHelper.logError("Could not save backpack data");
					inventory[0] = null;
					inventory[pos] = item;
					return res;
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
	
	public void reset()
	{
		inventory = new ItemStack[2];
	}
	
	public ItemStack getLeftItem()
	{
		return inventory[0];
	}
	
	public ItemStack getRightItem()
	{
		return inventory[1];
	}

	public Backpack getBackpack() 
	{
		return backpack;
	}

	public void setBackpack(Backpack backpack) 
	{
		this.backpack = backpack;
	}
	
}
