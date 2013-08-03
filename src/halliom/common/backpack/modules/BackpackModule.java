package halliom.common.backpack.modules;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;

public class BackpackModule 
{
	public static final int TYPE_STORAGE = 0;
	public static final int TYPE_UP = 1;
	public static final int TYPE_DOWN = 2;
	
	protected final int type;
	
	private static HashMap<String, Class> classMap = new HashMap<String, Class>();
	
	private boolean needsUpdate = false;
	
	public BackpackModule(int type)
	{
		this.type = type;
		register(this);
	}

	public int getType() 
	{
		return type;
	}
	
	public String getUID()
	{
		return this.getClass().getName();
	}
	
	public void onUpdate()
	{
		
	}
	
	public void writeToNBT(NBTTagCompound tag)
	{
		
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		
	}

	public boolean getNeedsUpdate() 
	{
		return needsUpdate;
	}

	private void setNeedsUpdate(boolean needsUpdate) 
	{
		this.needsUpdate = needsUpdate;
	}
	
	private static void register(BackpackModule module)
	{
		if (classMap.containsKey(module.getUID()))
		{
			
		}
	}
}
