package halliom.client.gui.special;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import halliom.core.util.Box;
import halliom.core.util.Vector3f;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeDirection;

public abstract class GuiObject3D 
{
	
	private Box boundingBox;
	
	public GuiObject3D(Box boundingBox)
	{
		this.boundingBox = boundingBox;
	}
	
	public abstract void render(double x, double y, double z, float f, ForgeDirection face);
	
	public boolean isVectorInside(Vector3f vector)
	{
		return boundingBox.isVectorInSide(vector);
	}
	
	public boolean isVectorInside(Box box, Vector3f vector)
	{
		System.out.println("Starting vector maths");
		System.out.println("Vector " + vector);
		System.out.println("StartVec: " + box.getStartPos());
		System.out.println("EndVec: " + box.getEndPos());
		return box.isVectorInSide(vector);
	}
	
	public Box translateBox(Vector3f pos)
	{
		Vector3f startVec = pos.add(boundingBox.getStartPos());
		Vector3f endVec = pos.add(boundingBox.getEndPos());
		return new Box(startVec, endVec);
	}
	
	public abstract void handleClick(Vector3f vector);
	
	protected void drawTextureNorth(float x, float y, float z, float width, float height, String texture)
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
	
	protected void drawTextureNorthFromVector(Box boundingBox, Vector3f translation, String texture)
	{
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(texture));
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		{
			float width = boundingBox.getEndPos().getX() - boundingBox.getStartPos().getX();
			float height = boundingBox.getEndPos().getY() - boundingBox.getStartPos().getY();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Vector3f sumVec = boundingBox.getStartPos().add(translation);
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			GL11.glColor4f(1, 1, 1, 0.7f);
			tessellator.addVertexWithUV(sumVec.getX(), sumVec.getY() + height, sumVec.getZ(), 1, 0);
			tessellator.addVertexWithUV(sumVec.getX() + width, sumVec.getY() + height, sumVec.getZ(), 0, 0);
			tessellator.addVertexWithUV(sumVec.getX() + width, sumVec.getY(), sumVec.getZ(), 0, 1);
			tessellator.addVertexWithUV(sumVec.getX(), sumVec.getY(), sumVec.getZ(), 1, 1);
			tessellator.draw();
			GL11.glDisable(GL11.GL_BLEND);
		}
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glPopMatrix();
	}
	
	protected void drawTextureSouthFromVector(Box boundingBox, Vector3f translation, String texture)
	{
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(texture));
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		{
			float width = boundingBox.getEndPos().getX() - boundingBox.getStartPos().getX();
			float height = boundingBox.getEndPos().getY() - boundingBox.getStartPos().getY(); 
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Vector3f sumVec = boundingBox.getStartPos().add(translation);
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			GL11.glColor4f(1, 1, 1, 0.7f);
			tessellator.addVertexWithUV(sumVec.getX(), sumVec.getY() + height, sumVec.getZ() + width, 1, 0);
			tessellator.addVertexWithUV(sumVec.getX() + width, sumVec.getY() + height, sumVec.getZ() + width, 0, 0);
			tessellator.addVertexWithUV(sumVec.getX() + width, sumVec.getY(), sumVec.getZ() + width, 0, 1);
			tessellator.addVertexWithUV(sumVec.getX(), sumVec.getY(), sumVec.getZ() + width, 1, 1);
			tessellator.draw();
			GL11.glDisable(GL11.GL_BLEND);
		}
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glPopMatrix();
	}
	
	protected void drawTextureWestFromVector(Box boundingBox, Vector3f translation, String texture)
	{
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(texture));
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		{
			float width = boundingBox.getEndPos().getX() - boundingBox.getStartPos().getX();
			float height = boundingBox.getEndPos().getY() - boundingBox.getStartPos().getY();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Vector3f sumVec = boundingBox.getStartPos().add(translation);
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			GL11.glColor4f(1, 1, 1, 0.7f);
			tessellator.addVertexWithUV(sumVec.getX(), sumVec.getY() + height, sumVec.getZ() + width, 1, 0);
			tessellator.addVertexWithUV(sumVec.getX(), sumVec.getY() + height, sumVec.getZ(), 0, 0);
			tessellator.addVertexWithUV(sumVec.getX(), sumVec.getY(), sumVec.getZ(), 0, 1);
			tessellator.addVertexWithUV(sumVec.getX(), sumVec.getY(), sumVec.getZ() + width, 1, 1);
			tessellator.draw();
			GL11.glDisable(GL11.GL_BLEND);
		}
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glPopMatrix();
	}
	
	protected void drawTextureEastFromVector(Box boundingBox, Vector3f translation, String texture)
	{
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(texture));
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		{
			float width = boundingBox.getEndPos().getX() - boundingBox.getStartPos().getX();
			float height = boundingBox.getEndPos().getY() - boundingBox.getStartPos().getY();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Vector3f sumVec = boundingBox.getStartPos().add(translation);
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			GL11.glColor4f(1, 1, 1, 0.7f);
			tessellator.addVertexWithUV(sumVec.getX() + width, sumVec.getY() + height, sumVec.getZ(), 1, 0);
			tessellator.addVertexWithUV(sumVec.getX() + width, sumVec.getY() + height, sumVec.getZ() + width, 0, 0);
			tessellator.addVertexWithUV(sumVec.getX() + width, sumVec.getY(), sumVec.getZ() + width, 0, 1);
			tessellator.addVertexWithUV(sumVec.getX() + width, sumVec.getY(), sumVec.getZ(), 1, 1);
			tessellator.draw();
			GL11.glDisable(GL11.GL_BLEND);
		}
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glPopMatrix();
	}

	public Box getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(Box boundingBox) {
		this.boundingBox = boundingBox;
	}
}
