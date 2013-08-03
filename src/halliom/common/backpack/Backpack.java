package halliom.common.backpack;

import halliom.common.backpack.modules.BackpackModule;
import net.minecraft.nbt.NBTTagCompound;

public class Backpack 
{
	
	private BackpackModule[] modules;
	
	public Backpack() 
	{
		modules = new BackpackModule[3];
		register(this);
	}
	
	public Backpack(BackpackModule[] modules)
	{
		this.modules = modules;
		register(this);
	}
	
	public void update()
	{
		for (byte i = 0; i < modules.length; i++)
		{
			if (modules[i] != null && modules[i].getNeedsUpdate())
			{
				modules[i].onUpdate();
			}
		}
	}
	
	public void writeToNBT(NBTTagCompound tag)
	{
		for (byte i = 0; i < modules.length; i++)
		{
			if (modules[i] != null)
			{
				NBTTagCompound moduleTag = new NBTTagCompound();
				modules[i].writeToNBT(moduleTag);
				tag.setCompoundTag(String.valueOf(i), moduleTag);
			}
		}
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		for (byte i = 0; i < modules.length; i++)
		{
			
		}
	}
	
	public NBTTagCompound destroy()
	{
		NBTTagCompound result = new NBTTagCompound();
		writeToNBT(result);
		BackpackTickHandler.removeBackpack(this);
		return result;
	}
	
	private static void register(Backpack backpack)
	{
		BackpackTickHandler.addBackpack(backpack);
	}
	
}
