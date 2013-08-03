package halliom.common.backpack.modules;

public class BackpackModule 
{
	public static final int TYPE_STORAGE = 1;
	public static final int TYPE_UP = 2;
	public static final int TYPE_DOWN = 3;
	
	protected final int type;
	
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
}
