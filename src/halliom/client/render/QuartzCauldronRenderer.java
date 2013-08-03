package halliom.client.render;

import halliom.client.gui.special.Gui3D;
import halliom.common.tile.TileQuartzCauldron;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class QuartzCauldronRenderer extends TileEntitySpecialRenderer 
{

	Gui3D gui;
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
	{
		gui = new Gui3D(((TileQuartzCauldron)tileentity).getFacing());
		GL11.glPushMatrix();
		gui.draw(x, y, z, f);
		GL11.glPopMatrix();
	}

}
