package halliom.client;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

public class BackItemRenderer extends RenderPlayer
{
	
	private RenderItem item1 = new RenderItem();
	
	public BackItemRenderer() 
	{
		item1.setRenderManager(RenderManager.instance);
	}
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) 
	{
		GL11.glPushMatrix();
		{
			EntityItem item = new EntityItem(entity.worldObj);
			item.hoverStart = 0f;
			item.setEntityItemStack(new ItemStack(Block.stone));
			item1.doRender(item, 0, 0, 0, 0, 0);
		}
		GL11.glPopMatrix();
	}

}
