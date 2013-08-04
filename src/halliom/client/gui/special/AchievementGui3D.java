package halliom.client.gui.special;

import java.util.ArrayList;

import halliom.common.backpack.achievement.Achievement;
import halliom.common.backpack.achievement.AchievementData;
import halliom.common.backpack.achievement.AchievementMap;
import halliom.core.util.Vector3f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.client.FMLClientHandler;

public class AchievementGui3D extends Gui3D
{
	
	private Achievement[] achievementMap;

	public AchievementGui3D(ForgeDirection face, Vector3f worldPos) 
	{
		super(face, worldPos);
		initilaizeComponents(FMLClientHandler.instance().getClient().thePlayer);
	}

	private void initilaizeComponents(EntityPlayer thePlayer) 
	{
		if (!AchievementData.achievements.containsKey(thePlayer))
		{
			AchievementData.achievements.put(thePlayer, new AchievementMap());
		}
		
		AchievementMap map = AchievementData.achievements.get(thePlayer);
	}

}
