package halliom.common.backpack.achievement;

import java.util.ArrayList;
import java.util.HashMap;

public class AchievementMap 
{
	public static HashMap<Integer, ArrayList<Achievement>> researches = new HashMap<Integer, ArrayList<Achievement>>();

	private ArrayList<Achievement> completed = new ArrayList<Achievement>();
	
	public void completeResearch(Achievement research)
	{
		if (researches.containsKey(research.getTier()))
		{
			ArrayList<Achievement> achievementsInTier = researches.get(research.getTier());
			if (achievementsInTier.contains(research));
				researches.get(research.getTier()).add(research);
		}
	}
	
	public static void addAchievement(Achievement achievement)
	{
		if (!researches.containsKey(achievement.getTier()))
			researches.put(achievement.getTier(), new ArrayList<Achievement>());
		
		researches.get(achievement.getTier()).add(achievement);
	}

	public ArrayList<Achievement> getCompleted() 
	{
		return completed;
	}
	
	public static HashMap<Integer, ArrayList<Achievement>> getResearches() 
	{
		return researches;
	}
}
