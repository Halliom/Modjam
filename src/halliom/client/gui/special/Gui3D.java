package halliom.client.gui.special;

import halliom.core.util.Box;
import halliom.core.util.Vector3f;

import java.util.ArrayList;

import net.minecraftforge.common.ForgeDirection;

public class Gui3D 
{
	
//	private Vector3f[] rotations = new Vector3f[]{new Vector3f(0,0,1), new Vector3f(1,0,0), new Vector3f(0,0,-1), new Vector3f(-1,0,0)};
	
	public static Gui3D openGUI;
	
	private int face; 
	
	private Vector3f worldPos;
	
	private ArrayList<GuiObject3D> objects = new ArrayList<GuiObject3D>();
	
	public Gui3D(ForgeDirection face, Vector3f worldPos) 
	{
		openGUI = this;
		this.face = face.ordinal();
		this.worldPos = worldPos;
		objects.add(new GuiImage3D(new Box(new Vector3f(0,1,0), new Vector3f(1,1,1)), "textures/gui/container/generic_54.png"));
	}
	
	public void handleClick(Vector3f lookVec, int face)
	{
		for (GuiObject3D comp : objects)
		{
			Vector3f lookShortened = null;
			System.out.println("Face: " + face + " dist " + (worldPos.getZ() - lookVec.getZ()));
			if (face == 0 && worldPos.getZ() - lookVec.getZ() <= 0)
				lookShortened = lookVec.sub(new Vector3f(0, 0, worldPos.getZ() - lookVec.getZ()));
			
			if (lookShortened != null && comp.isVectorInside(lookShortened)) System.out.println("Hoooraaaaayyy");
			System.out.println(lookShortened);
		}
	}
	
	public void draw(double x, double y, double z, float f)
	{
		for (GuiObject3D comp : objects)
		{
			comp.render(x, y, z, f, ForgeDirection.getOrientation(face).getOpposite());
		}
	}
	
}
