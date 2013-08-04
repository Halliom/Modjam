package halliom.common.tile;

import halliom.client.gui.special.AchievementGui3D;
import halliom.client.gui.special.Gui3D;
import halliom.client.gui.special.Gui3DHandler;
import halliom.core.util.Vector3f;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ForgeDirection;

public class TileQuartzCauldron extends TileEntity
{
	
	private List prevPlayers = new ArrayList();
	private EntityPlayer prevPlayer;
	
	private long ticks;
	
	private ForgeDirection facing = ForgeDirection.NORTH;
	
	public ForgeDirection getFacing()
	{
		return facing;
	}
	
	@Override
	public void updateEntity() 
	{
		//TODO fix this shit
//		List players = worldObj.getEntitiesWithinAABB(EntityLiving.class, getArea());
//		for (Object o : players)
//		if (!players.equals(prevPlayers))
//		{
//			for (int i = 0; i < players.size(); i++)
//			{
//				if (i < prevPlayers.size())
//					if (prevPlayers.get(i) != players.get(i))
//					{
//						if (Gui3DHandler.has3DGuiOpen((EntityPlayer) players.get(i)))
//							Gui3DHandler.closeGui((EntityPlayer) players.get(i));
//						else
//							Gui3DHandler.openGui((EntityPlayer) players.get(i), getGui());
//					}
//			}
//		}
		ticks++;
		if (ticks > 20)
		{
			EntityPlayer player = worldObj.getClosestPlayer(xCoord, yCoord, zCoord, 4);
			if (player != null)
			{
				if (!Gui3DHandler.has3DGuiOpen(player))
					//				Gui3DHandler.closeGui(player);
					Gui3DHandler.openGui(player, getGui());
			}
		}
	}
	
	private Gui3D getGui()
	{
		return new AchievementGui3D(facing, new Vector3f(xCoord, yCoord, zCoord));
	}
	
	private AxisAlignedBB getArea()
	{
		switch(facing)
		{
			case DOWN:
				break;
			case EAST:
				return AxisAlignedBB.getAABBPool().getAABB(xCoord + 1, yCoord, zCoord + 1, xCoord + 3, yCoord + 1, zCoord - 1);
			case NORTH:
				return AxisAlignedBB.getAABBPool().getAABB(xCoord + 1, yCoord, zCoord + 1, xCoord - 1, yCoord + 1, zCoord + 3);
			case SOUTH:
				return AxisAlignedBB.getAABBPool().getAABB(xCoord - 1, yCoord, zCoord - 1, xCoord - 1, yCoord + 1, zCoord - 3);
			case UNKNOWN:
				break;
			case UP:
				return AxisAlignedBB.getAABBPool().getAABB(xCoord - 1, yCoord, zCoord - 1, xCoord - 3, yCoord - 1, zCoord + 1);
			case WEST:
			default:
				break;
		}
		return null;
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
