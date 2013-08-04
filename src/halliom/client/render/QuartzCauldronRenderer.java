package halliom.client.render;

import halliom.client.gui.special.Gui3D;
import halliom.client.gui.special.Gui3DHandler;
import halliom.common.tile.TileQuartzCauldron;
import halliom.core.util.Vector3f;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class QuartzCauldronRenderer extends TileEntitySpecialRenderer 
{

	Gui3D gui;
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
	{
		if (Gui3DHandler.has3DGuiOpen(FMLClientHandler.instance().getClient().thePlayer))
		{
			GL11.glPushMatrix();
			
			Gui3DHandler.getOpenGui(FMLClientHandler.instance().getClient().thePlayer).draw(x, y, z, f);
			GL11.glPopMatrix();
		}
	}

}
