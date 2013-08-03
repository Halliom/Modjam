package halliom.client.gui.special;

import halliom.core.util.Box;
import halliom.core.util.Vector3f;

public class GuiImage3D extends GuiObject3D
{

	private String image;
	
	public GuiImage3D(Box boundingBox, String image) 
	{
		super(boundingBox);
		this.image = image;
	}

	@Override
	public void render(double x, double y, double z, float f) 
	{
		drawTextureFromVector(getBoundingBox(), new Vector3f((float) x, (float) y, (float) z), 1, 1, image);
	}

	@Override
	public void handleClick(Vector3f vector) 
	{
		
	}

}
