package halliom.client.gui.special;

import halliom.core.util.Vector3f;

public abstract class GuiObject3D 
{
	
	public abstract void render();
	
	public abstract void isVectorInside(Vector3f vector);
	
}
