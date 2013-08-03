package halliom.common.block;

import halliom.common.tile.TileQuartzCauldron;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blocks 
{
	
	public static Block quartzCauldron;
	
	public static void initializeBlocks()
	{
		quartzCauldron = new BlockQuartzCauldron(499, Material.rock);
		GameRegistry.registerBlock(quartzCauldron, "bpblock_cauldron_quartz");
		GameRegistry.registerTileEntity(TileQuartzCauldron.class, "bptile_cauldron_quartz");
	}
	
}
