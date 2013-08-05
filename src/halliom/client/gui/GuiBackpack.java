package halliom.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public class GuiBackpack extends GuiContainer 
{
	
	private EntityPlayer player;

	public GuiBackpack(EntityPlayer player) 
	{
		super(new ContainerBackpack(player));
		this.player = player;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) 
	{
		int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

}
