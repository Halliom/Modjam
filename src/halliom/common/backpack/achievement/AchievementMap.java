package halliom.common.backpack.achievement;

import java.util.ArrayList;

public class AchievementMap 
{
	public static ArrayList<Achievement> researches = new ArrayList<Achievement>();
	private ArrayList<Achievement> completed = new ArrayList<Achievement>();
	
	public void completeResearch(Achievement research)
	{
		if (researches.contains(research))
			completed.add(research);
	}

	public ArrayList<Achievement> getCompleted() 
	{
		return completed;
	}
}
