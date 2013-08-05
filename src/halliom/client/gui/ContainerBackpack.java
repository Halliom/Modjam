package halliom.client.gui;

import halliom.common.backpack.BackpackData;
import halliom.common.backpack.BackplateContainer;
import halliom.common.backpack.modules.BackpackModule;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerBackpack extends Container
{

	public ContainerBackpack(EntityPlayer player) 
	{
		if (BackpackData.playerData.containsKey(player))
		{
			BackplateContainer container = BackpackData.playerData.get(player);
			if (container.getBackpack() != null)
			{
				if (container.getBackpack().getModule(BackpackModule.TYPE_STORAGE) != null)
				{
					BackpackModule storage = container.getBackpack().getModule(BackpackModule.TYPE_STORAGE);
				}
			}
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) 
	{
		return true;
	}

}
