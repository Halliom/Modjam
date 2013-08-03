package halliom.core.util;

public class Vector3f 
{
	
	private float x;
	private float y;
	private float z;
	
	public Vector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float length()
	{
		return (float) Math.sqrt(x * x + y * y + z * z);
	}
	
	public Vector3f normalize()
	{
		float length = length();
		
		return new Vector3f(x / length, y / length, z / length);
	}
	
	public Vector3f add(Vector3f vector)
	{
		 return new Vector3f(x + vector.getX(), y + vector.getY(), z + vector.getZ());
	}
	
	public float getX() 
	{
		return x;
	}

	public void setX(float x) 
	{
		this.x = x;
	}

	public float getY() 
	{
		return y;
	}

	public void setY(float y) 
	{
		this.y = y;
	}

	public float getZ() 
	{
		return z;
	}

	public void setZ(float z) 
	{
		this.z = z;
	}
	
}
