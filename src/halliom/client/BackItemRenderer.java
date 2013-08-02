package halliom.client;

import halliom.common.backpack.BackpackData;
import halliom.common.backpack.BackplateContainer;
import halliom.common.item.ItemBackpack;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BackItemRenderer extends RenderPlayer
{
	
	private RenderItem item1Renderer = new RenderItem();
	private RenderItem item2Renderer = new RenderItem();
	
	private IModelCustom backPackModel = AdvancedModelLoader.loadModel("/Backpack.obj");
	
	public BackItemRenderer() 
	{
		item1Renderer.setRenderManager(RenderManager.instance);
		item2Renderer.setRenderManager(RenderManager.instance);
	}
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) 
	{
		super.doRender(entity, d0, d1, d2, f, f1);
		GL11.glPushMatrix();
		{
			if (!BackpackData.playerData.containsKey((EntityPlayer)entity))
			{
				BackpackData.playerData.put((EntityPlayer)entity, new BackplateContainer());
			}
			
			BackplateContainer container = BackpackData.playerData.get((EntityPlayer)entity);
			
			GL11.glScalef(1.2F, 1.2F, 1.2F);
			rotateItemAccordingToPlayer((EntityPlayer)entity);
			
			if (container.getLeftItem().getItem() instanceof ItemBackpack)
			{
				backPackModel.renderAll();
			}
			else
			{
				if (container.getLeftItem() != null)
				{
					EntityItem item1 = new EntityItem(entity.worldObj);
					item1.hoverStart = 0f;
					item1.setEntityItemStack(container.getLeftItem());
					item1Renderer.doRender(item1, 0, -0.6, -0.15, 1, 1);
				}
				if (container.getRightItem() != null)
				{
					EntityItem item2 = new EntityItem(entity.worldObj);
					item2.hoverStart = 0f;
					item2.setEntityItemStack(container.getRightItem());
					GL11.glRotatef(270, 0, 0, 1);
					item2Renderer.doRender(item2, 0.4, -0.2, -0.2, 1, 1);
				}
			}
		}
		GL11.glPopMatrix();
	}
	
	private void rotateItemAccordingToPlayer(EntityPlayer player)
	{
		float rotationY = player.renderYawOffset;
		if (player.renderYawOffset > 360|| player.renderYawOffset < -360)
			rotationY = player.renderYawOffset % 360;
		GL11.glRotatef(-rotationY, 0, 1, 0);
		
		if (player.isSneaking())
			GL11.glRotatef(20, 1, 0, 0);
	}

}
