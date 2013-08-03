package halliom.common.backpack.modules;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;

public class BackpackModule 
{
	public static final int TYPE_STORAGE = 0;
	public static final int TYPE_UP = 1;
	public static final int TYPE_DOWN = 2;
	
	protected int type;
	
	private static HashMap<String, Class> toClassMap = new HashMap<String, Class>();
	private static HashMap<Class, String> fromClassMap = new HashMap<Class, String>();
	
	private boolean needsUpdate = false;
	
	public BackpackModule() 
	{
	}
	
	public BackpackModule(int type)
	{
		this.type = type;
	}

	public int getType() 
	{
		return type;
	}
	
	public void onUpdate()
	{
		
	}
	
	public void writeToNBT(NBTTagCompound tag)
	{
		tag.setInteger("Type", type);
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		type = tag.getInteger("Type");
	}

	public boolean getNeedsUpdate() 
	{
		return needsUpdate;
	}

	private void setNeedsUpdate(boolean needsUpdate) 
	{
		this.needsUpdate = needsUpdate;
	}
	
	public static void registerModule(String key, Class<? extends BackpackModule> clazz)
	{
		toClassMap.put(key, clazz);
		fromClassMap.put(clazz, key);
	}
	
	public static String getStringFromClass(Class<? extends BackpackModule> clazz)
	{
		return fromClassMap.get(clazz);
	}
	
	public static Class getClassFromString(String id)
	{
		return toClassMap.get(id);
	}
}
