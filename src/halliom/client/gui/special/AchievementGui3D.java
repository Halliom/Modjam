package halliom.client.gui.special;

import halliom.common.backpack.achievement.Achievement;
import halliom.common.backpack.achievement.AchievementData;
import halliom.common.backpack.achievement.AchievementMap;
import halliom.core.util.Box;
import halliom.core.util.Vector3f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.client.FMLClientHandler;

public class AchievementGui3D extends Gui3D
{
	
	private int startX, startY;
	private int endX, endY;
	
	private Achievement[][] achievementMap;

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
		
		achievementMap = new Achievement[AchievementMap.researches.size() * 3][0];
		
		AchievementMap map = AchievementData.achievements.get(thePlayer);
		
		for (Integer tier : AchievementMap.researches.keySet())
		{
			achievementMap[tier] = new Achievement[AchievementMap.researches.get(tier).size() * 3];
		}
		
		for (int i = 0; i < achievementMap.length; i += 3)
			for (int j = 0; j < achievementMap[i].length; j += 3)
			{
				achievementMap[i][j] = AchievementMap.researches.get(i / 3).get(j / 3);
//				objects.add(new GuiImage3D(new Box(new Vector3f(), new Vector3f()), "/texture/achievement_icon_background.png"));
			}
		for (int i = 0; i < 18; i += 3)
			for (int j = 0; j < 12; j += 3)
			{
				objects.add(new GuiImage3D(new Box(new Vector3f(-3 + i, -2 + j, -0.2f), new Vector3f(-3 + i + 1, -2 + j + 1, 0.2f)), new ResourceLocation("backpacked", "texture/achievement_icon_background.png")));
			}
	}
	
	@Override
	public void draw(double x, double y, double z, float f) 
	{
		super.draw(x, y, z, f);
//		System.out.println(face);
//		for (int i = startX; i < endX; i += 3)
//			for (int j = startY; j < endY; j += 3)
//				if (achievementMap[i][j] != null)
	}

}
