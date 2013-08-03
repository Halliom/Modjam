package halliom.common.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileQuartzCauldron extends TileEntity
{
	
	private ForgeDirection facing = ForgeDirection.NORTH;

	public ForgeDirection getFacing()
	{
		return facing;
	}

	public void setFacing(ForgeDirection facing) 
	{
		this.facing = facing;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) 
	{
		super.writeToNBT(tag);
		
		tag.setInteger("Facing", facing != null ? facing.ordinal() : 6);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) 
	{
		super.readFromNBT(tag);
		
		facing = ForgeDirection.getOrientation(tag.getInteger("Facing"));
	}
	
}
