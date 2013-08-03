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
		for (int i = 0; i < modules.length; i++)
		{
			if (modules[i].getNeedsUpdate())
			{
				modules[i].onUpdate();
			}
		}
	}
	
	public void writeToNBT(NBTTagCompound tag)
	{
		
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		
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
