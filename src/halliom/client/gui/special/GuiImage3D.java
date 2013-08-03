package halliom.client.gui.special;

import halliom.core.util.Box;
import halliom.core.util.Vector3f;
import net.minecraftforge.common.ForgeDirection;

public class GuiImage3D extends GuiObject3D
{

	private String image;
	
	public GuiImage3D(Box boundingBox, String image) 
	{
		super(boundingBox);
		this.image = image;
	}

	@Override
	public void render(double x, double y, double z, float f, ForgeDirection face) 
	{
//		System.out.println(face);
		switch(face)
		{
			case NORTH:
				drawTextureNorthFromVector(getBoundingBox(), new Vector3f((float) x, (float) y, (float) z), image);
				break;
			case SOUTH:
				drawTextureSouthFromVector(getBoundingBox(), new Vector3f((float) x, (float) y, (float) z), image);
				break;
			case WEST:
				drawTextureWestFromVector(getBoundingBox(), new Vector3f((float) x, (float) y, (float) z), image);
				break;
			case EAST:
				drawTextureEastFromVector(getBoundingBox(), new Vector3f((float) x, (float) y, (float) z), image);
		}
	}

	@Override
	public void handleClick(Vector3f vector) 
	{
		
	}

}
