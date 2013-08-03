package halliom.client.gui.special;

import halliom.core.util.Box;
import halliom.core.util.Vector3f;

import java.util.ArrayList;

import net.minecraftforge.common.ForgeDirection;

public class Gui3D 
{
	
//	private Vector3f[] rotations = new Vector3f[]{new Vector3f(0,0,1), new Vector3f(1,0,0), new Vector3f(0,0,-1), new Vector3f(-1,0,0)};
	
	private ForgeDirection face; 
	
	private Vector3f worldPos;
	
	private ArrayList<GuiObject3D> objects = new ArrayList<GuiObject3D>();
	
	public Gui3D(ForgeDirection face, Vector3f worldPos) 
	{
		this.face = face;
		this.worldPos = worldPos;
		objects.add(new GuiImage3D(new Box(new Vector3f(0,1,0), new Vector3f(1,1,1)), "textures/gui/container/generic_54.png"));
		Gui3DHandler.openGui(player, this);
	}
	
	public void handleClick(Vector3f lookVec, int face)
	{
		for (GuiObject3D comp : objects)
		{
			Vector3f lookShortened = null;
			if (face == 0 && worldPos.getZ() - lookVec.getZ() >= 0)
				lookShortened = lookVec.sub(new Vector3f(0, 0, worldPos.getZ() - lookVec.getZ()));
			System.out.println(lookShortened);
		}
	}
	
	public void draw(double x, double y, double z, float f)
	{
		for (GuiObject3D comp : objects)
		{
			comp.render(x, y, z, f, face.getOpposite());
		}
	}
	
}
