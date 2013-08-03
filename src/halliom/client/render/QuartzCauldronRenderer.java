package halliom.client.render;

import org.lwjgl.opengl.GL11;

import halliom.client.gui.special.Gui3D;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class QuartzCauldronRenderer extends TileEntitySpecialRenderer 
{

	Gui3D gui = new Gui3D();
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		gui.draw(x, y, z, f);
		GL11.glPopMatrix();
	}

}
