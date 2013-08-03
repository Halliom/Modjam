package halliom.common.block;

import halliom.client.ClientProxy;
import halliom.common.tile.TileQuartzCauldron;
import halliom.core.Backpacked;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockQuartzCauldron extends BlockContainer
{

	protected BlockQuartzCauldron(int id, Material material) 
	{
		super(id, material);
		setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
		return new TileQuartzCauldron();
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack item) 
	{
		int rotation = MathHelper.floor_double(entityLiving.rotationYaw * 4f / 360f + 0.5d) & 3;
		TileQuartzCauldron tile = (TileQuartzCauldron) world.getBlockTileEntity(x, y, z);
		
		switch(rotation)
		{
			case 0:
				tile.setFacing(ForgeDirection.NORTH);
				break;
			case 1:
				tile.setFacing(ForgeDirection.EAST);
				break;
			case 2:
				tile.setFacing(ForgeDirection.SOUTH);
				break;
			case 3:
				tile.setFacing(ForgeDirection.WEST);
				break;
		}
	}
	
	@Override
	public boolean isOpaqueCube() 
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() 
	{
		return false;
	}
	
	@Override
	public int getRenderType() 
	{
		return ClientProxy.QUARTZ_CAULDRON_RENDER_ID;
	}
	
}
