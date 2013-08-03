package halliom.client.render;

import halliom.client.gui.special.Gui3D;
import halliom.common.tile.TileQuartzCauldron;
import halliom.core.util.Vector3f;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class QuartzCauldronRenderer extends TileEntitySpecialRenderer 
{

	Gui3D gui;
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
	{
		gui = new Gui3D(((TileQuartzCauldron)tileentity).getFacing(), new Vector3f(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord));
		GL11.glPushMatrix();
		gui.draw(x, y, z, f);
		GL11.glPopMatrix();
	}

}
