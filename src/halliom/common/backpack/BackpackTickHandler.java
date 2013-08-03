package halliom.common.backpack;

import java.util.ArrayList;
import java.util.EnumSet;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class BackpackTickHandler implements ITickHandler
{

	private static ArrayList<Backpack> backpacks = new ArrayList<Backpack>();
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) 
	{
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) 
	{
		for (Backpack backpack : backpacks)
		{
			backpack.update();
		}
	}

	@Override
	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel() 
	{
		return this.getClass().getName();
	}
	
	public static void addBackpack(Backpack backpack)
	{
		backpacks.add(backpack);
	}
	
	public static void removeBackpack(Backpack backpack)
	{
		backpacks.remove(backpack);
	}

}
