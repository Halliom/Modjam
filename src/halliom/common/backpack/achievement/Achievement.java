package halliom.common.backpack.achievement;

public class Achievement
{
	private String name;
	
	private int tier;
	
	public Achievement(String name, int tier)
	{
		this.name = name;
		this.tier = tier;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getTier() 
	{
		return tier;
	}

	public void setTier(int tier) 
	{
		this.tier = tier;
	}
}
