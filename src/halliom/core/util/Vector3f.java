package halliom.core.util;

import net.minecraft.util.Vec3;

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
	
	public Vector3f(Vec3 vec)
	{
		this.x = (float) vec.xCoord;
		this.y = (float) vec.yCoord;
		this.z = (float) vec.zCoord;
	}
	
	public float dot(Vector3f vec)
	{
		return x * vec.getX() + y * vec.getY() + z * vec.getZ();
	}
	
	public Vector3f cross(Vector3f vec)
	{
		float x_ = y * vec.getZ() - z * vec.getY();
		float y_ = z * vec.getX() - x * vec.getZ();
		float z_ = x * vec.getY() - y * vec.getX();
		
		return new Vector3f(x_, y_, z_);
	}
	
	public float length()
	{
		return (float) Math.sqrt(x * x + y * y + z * z);
	}
	
	public Vector3f interceptsOnAxisXY(Vector3f endPos, float posZ)
	{
		float distX = endPos.x - x;
		float distY = endPos.y - y;
		float distZ = endPos.z - z;
		
		
		return this;
	}
	
	public Vector3f normalize()
	{
		float length = length();
		System.out.println("VecLook normalize: " + this);
		
		return new Vector3f(x / length, y / length, z / length);
	}
	
	public Vector3f shorten(Vector3f vector)
	{
		Vector3f vec = new Vector3f(x,y,z);
		vec = vec.normalize();
		vec.mul(vector);
		return new Vector3f(x,y,z).sub(vec);
	}
	
	public Vector3f shorten(float amount)
	{
		Vector3f vec = new Vector3f(x,y,z);
		vec = vec.normalize();
		vec.mul(amount);
		return new Vector3f(x,y,z).sub(vec);
	}
	
	public float[] toArray()
	{
		return new float[]{x,y,z};
	}
	
	public Vector3f add(Vector3f vector)
	{
		 return new Vector3f(x + vector.getX(), y + vector.getY(), z + vector.getZ());
	}
	
	public Vector3f add(float amount)
	{
		return new Vector3f(x + amount, y + amount, z + amount);
	}
	
	public Vector3f sub(Vector3f vector)
	{
		 return new Vector3f(x - vector.getX(), y - vector.getY(), z - vector.getZ());
	}
	
	public Vector3f sub(float amount)
	{
		return new Vector3f(x - amount, y - amount, z - amount);
	}
	
	public Vector3f mul(Vector3f vector)
	{
		 return new Vector3f(x * vector.getX(), y * vector.getY(), z * vector.getZ());
	}
	
	public Vector3f mul(float amount)
	{
		return new Vector3f(x * amount, y * amount, z * amount);
	}
	
	public Vector3f div(Vector3f vector)
	{
		 return new Vector3f(x / vector.getX(), y / vector.getY(), z / vector.getZ());
	}
	
	public Vector3f div(float amount)
	{
		return new Vector3f(x / amount, y / amount, z / amount);
	}
	
	@Override
	public String toString() 
	{
		return String.format("Vector3f @: x:%f y:%f z:%f", x, y, z);
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
