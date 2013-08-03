package halliom.common.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileQuartzCauldron extends TileEntity
{
	
	private ForgeDirection facing;

	public ForgeDirection getFacing() 
	{
		return facing;
	}

	public void setFacing(ForgeDirection facing) 
	{
		this.facing = facing;
	}
	
}
