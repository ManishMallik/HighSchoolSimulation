import java.io.*;
import java.util.*;

public class NameStats {

	private String name;
	private int totalLevels;
	private int levelsComplete;
	
	public NameStats(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		totalLevels = 16;
		levelsComplete = 0;
	}
	
	public NameStats(String name, int complete)
	{
		this.name = name;
		totalLevels = 16;
		levelsComplete = complete;
	}
	
	public String name()
	{
		return name;
	}
	
	public int total()
	{
		return totalLevels;
	}
	
	public int complete()
	{
		return levelsComplete;
	}
	
	public void levelSuccess()
	{
		levelsComplete++;
	}
	
	public void reset()
	{
		levelsComplete = 0;
	}
	
	public String toString()
	{
		return name + " " + totalLevels + " " + levelsComplete;
	}
	
	public String saveToFile()
	{
		return name + "\n" + totalLevels + "\n" + levelsComplete;
	}
	
	public boolean equals(Object o)
	{
		NameStats other = (NameStats) o;
		return this.name.equals(other.name);
	}

}
