package halliom.client.gui.special;

import halliom.core.util.Box;
import halliom.core.util.Vector3f;

import java.util.ArrayList;

public class Gui3D 
{
	
	private Vector3f[] rotations = new Vector3f[]{new Vector3f(0,0,1), new Vector3f(1,0,0), new Vector3f(0,0,-1), new Vector3f(-1,0,0)};
	private Vector3f pos;
	
	private ArrayList<GuiObject3D> objects = new ArrayList<GuiObject3D>();
	
	public Gui3D(int face) 
	{
		objects.add(new GuiImage3D(new Box(new Vector3f(0,1,0), new Vector3f(1,1,1)), "textures/gui/container/generic_54.png"));
		pos = rotations[face];
	}
	
	public void handleClick(Vector3f lookVec, int face)
	{
		for (GuiObject3D comp : objects)
		{
		}
	}
	
	public void draw(double x, double y, double z, float f)
	{
		for (GuiObject3D comp : objects)
		{
			comp.render(x * pos.getX(), y * pos.getY(), z * pos.getZ(), f);
		}
	}
	
}
