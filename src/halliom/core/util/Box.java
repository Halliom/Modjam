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
	
	public boolean isVectorInSide(Vector3f vector)
	{
		if (!(vector.getX() >= startPos.getX()) || !(vector.getX() <= endPos.getX())) return false;
		if (!(vector.getY() >= startPos.getY()) || !(vector.getY() <= endPos.getY())) return false;
		if (!(vector.getZ() >= startPos.getZ()) || !(vector.getZ() <= endPos.getZ())) return false;
		return true;
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
