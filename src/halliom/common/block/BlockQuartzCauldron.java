package halliom.common.block;

import halliom.client.ClientProxy;
import halliom.common.tile.TileQuartzCauldron;
import halliom.core.Backpacked;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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
