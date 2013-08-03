package halliom.common.backpack.modules;

public class BackpackModule 
{
	public static final int TYPE_STORAGE = 0;
	public static final int TYPE_UP = 1;
	public static final int TYPE_DOWN = 2;
	
	protected final int type;
	
	private boolean needsUpdate = false;
	
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

	public boolean getNeedsUpdate() 
	{
		return needsUpdate;
	}

	private void setNeedsUpdate(boolean needsUpdate) 
	{
		this.needsUpdate = needsUpdate;
	}
}
