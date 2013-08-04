package halliom.core.util;

public class Box 
{
	
	private Vector3f startPos;
	private Vector3f endPos;
	
	public Box(Vector3f startPos, Vector3f endPos) 
	{
		this.startPos = startPos;
		this.endPos = endPos;
	}
	
	public float isVectorInSide(Vector3f direction, Vector3f position)
	{
		float f1, f2;
		float tnear = -1000.0f;
		float tfar = 1000.0f;
		float temp, cube;
		
		float[] dir = direction.toArray();
		float[] b1 = startPos.toArray();
		float[] b2 = endPos.toArray();
		float[] start = position.toArray();
		
		boolean intersects = true;
		
		for (byte i = 0; i < 3; i++)
		{
			if (dir[i] == 0)
			{
				if (start[i] < b1[i] || start[i] > b2[i])
					intersects = false;
			}
		}
			
	}

	public Vector3f getStartPos() 
	{
		return startPos;
	}

	public void setStartPos(Vector3f startPos) 
	{
		this.startPos = startPos;
	}

	public Vector3f getEndPos() 
	{
		return endPos;
	}

	public void setEndPos(Vector3f endPos) 
	{
		this.endPos = endPos;
	}
	
}
