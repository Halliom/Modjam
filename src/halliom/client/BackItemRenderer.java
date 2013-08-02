package halliom.client;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
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
		super.doRender(entity, d0, d1, d2, f, f1);
		GL11.glPushMatrix();
		{
			EntityItem item = new EntityItem(entity.worldObj);
			item.hoverStart = 0f;
			item.setEntityItemStack(new ItemStack(Item.swordDiamond));
			
			GL11.glScalef(1.2F, 1.2F, 1.2F);
			
			rotateItemAccordingToPlayer((EntityPlayer)entity);
			
			item1.doRender(item, 0, -0.6, -0.2, 1, 1);
		}
		GL11.glPopMatrix();
	}
	
	private void rotateItemAccordingToPlayer(EntityPlayer player)
	{
		System.out.println(player.renderYawOffset);
		float rotationY = player.renderYawOffset;
		if (player.renderYawOffset > 360|| player.renderYawOffset < -360)
			rotationY = player.renderYawOffset % 360;
		GL11.glRotatef(-rotationY, 0, 1, 0);
		
		if (player.isSneaking())
			GL11.glRotatef(20, 1, 0, 0);
	}

}
