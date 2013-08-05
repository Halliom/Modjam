package halliom.client.gui.special;

import halliom.core.util.Vector3f;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.client.FMLClientHandler;

public class Gui3D 
{	
	protected ForgeDirection face; 
	
	private Vector3f worldPos;
	
	protected ArrayList<GuiObject3D> objects = new ArrayList<GuiObject3D>();
	
	public Gui3D(ForgeDirection face, Vector3f worldPos) 
	{
		this.face = face;
		this.worldPos = worldPos;
	}
	
	public void handleClick(Vector3f lookVec, int face, EntityPlayer player)
	{
		Vector3f playerPos = new Vector3f((float) player.posX, (float) player.posY + 1, (float) player.posZ);
		float reach = 4.0f;
		Vector3f reachVec = lookVec.mul(reach).add(playerPos);
		
		for (GuiObject3D comp : objects)
		{
//			Box box = comp.getBoundingBox();
//			if (lookVec != null && playerPos != null)
//			{
//				float clickPos = comp.isVectorInside(comp.translateBox(worldPos), lookVec, playerPos);
//				System.out.println(clickPos);
//				if (clickPos != -1) System.out.println("Hoooraaaaayyy");
//			}
		}
	}
	
	public void onOpen()
	{
		
	}
	
	public void onDestroy()
	{
		Gui3DHandler.deleteGui(FMLClientHandler.instance().getClient().thePlayer);
	}
	
	public void draw(double x, double y, double z, float f)
	{
		for (GuiObject3D comp : objects)
		{
			comp.render(x, y, z, f, face.getOpposite());
		}
	}
	
}
