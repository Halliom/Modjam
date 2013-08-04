package halliom.client.render;

import halliom.core.util.Box;
import halliom.core.util.Vector3f;

public class RayTracer 
{
	
	private double dist;
	private int side;
	
	public void raytraceBox(Box box, Vector3f startPos, Vector3f endPos)
	{
		dist = Double.MAX_VALUE;
		side = -1;
		
		for (byte i = 0; i < 6; i++)
			raytraceSide(i, box, startPos, endPos);
	}

	private void raytraceSide(byte side, Box box, Vector3f startPos, Vector3f endPos) 
	{
		Vector3f result = null;
		switch(side)
		{
			case 0:
				
				break;
		}
	}
	
}