package halliom.client;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ResourceLocation;

public class BackItemRenderer extends Render
{
	
	private RenderItem item1 = new RenderItem();
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) 
	{
		item1.doRender(new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ), d0, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity) 
	{
		return null;
	}

}
