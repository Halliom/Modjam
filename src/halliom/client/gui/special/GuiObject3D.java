package halliom.client.gui.special;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import halliom.core.util.Box;
import halliom.core.util.Vector3f;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public abstract class GuiObject3D 
{
	
	private Box boundingBox;
	
	public GuiObject3D(Box boundingBox)
	{
		this.boundingBox = boundingBox;
	}
	
	public abstract void render(double x, double y, double z, float f);
	
	public boolean isVectorInside(Vector3f vector)
	{
		return boundingBox.isVectorInSide(vector);
	}
	
	public abstract void handleClick(Vector3f vector);
	
	protected void drawTexture(float x, float y, float z, float width, float height, String texture)
	{
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(texture));
		GL11.glPushMatrix();
		{
			GL11.glDisable(GL11.GL_CULL_FACE);
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(x, y + height, z, 0, 1);
			tessellator.addVertexWithUV(x + width, y + height, z, 1, 1);
			tessellator.addVertexWithUV(x + width, y, z, 1, 0);
			tessellator.addVertexWithUV(x, y, z, 0, 0);
			tessellator.draw();
		}
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glPopMatrix();
	}
	
	protected void drawTextureFromVector(Vector3f vector, float width, float height, String texture)
	{
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(texture));
		GL11.glPushMatrix();
		{
			GL11.glDisable(GL11.GL_CULL_FACE);
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(x, y + height, z, 0, 1);
			tessellator.addVertexWithUV(x + width, y + height, z, 1, 1);
			tessellator.addVertexWithUV(x + width, y, z, 1, 0);
			tessellator.addVertexWithUV(x, y, z, 0, 0);
			tessellator.draw();
		}
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glPopMatrix();
	}
}
