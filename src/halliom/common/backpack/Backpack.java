package halliom.common.backpack;

import halliom.common.backpack.modules.BackpackModule;
import halliom.common.backpack.modules.ModuleBucketSupplier;
import halliom.core.LogHelper;
import net.minecraft.nbt.NBTTagCompound;

public class Backpack 
{
	
	private BackpackModule[] modules;
	
	public Backpack() 
	{
		modules = new BackpackModule[3];
		modules[BackpackModule.TYPE_DOWN] = new ModuleBucketSupplier();
		register(this);
	}
	
	public Backpack(BackpackModule[] modules)
	{
		this.modules = modules;
		register(this);
	}
	
	public void render()
	{
		for (int i = 0; i < modules.length; i++)
		{
			if (modules[i] != null)
				modules[i].render();
		}
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
				moduleTag.setString("bp_id_to_class", BackpackModule.getStringFromClass(modules[i].getClass()));
				modules[i].writeToNBT(moduleTag);
				tag.setCompoundTag(String.valueOf(i), moduleTag);
			}
		}
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		for (byte i = 0; i < modules.length; i++)
		{
			if (tag.hasKey(String.valueOf(i)))
			{
				NBTTagCompound moduleTag = tag.getCompoundTag(String.valueOf(i));
				Class clazz = BackpackModule.getClassFromString(moduleTag.getString("bp_id_to_class"));
				try
				{
					BackpackModule bp_module = (BackpackModule) clazz.newInstance();
					modules[i] = bp_module;
					modules[i].readFromNBT(moduleTag);
				}catch(Exception e)
				{
					LogHelper.logWarning("Error while loading a backpack module");
				}
			}
		}
	}
	
	public BackpackModule getModule(int slot)
	{
		return modules != null && slot >= 0 && slot < modules.length ? modules[slot] : null;
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
