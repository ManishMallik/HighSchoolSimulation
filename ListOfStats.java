import java.io.*;
import java.util.*;

public class ListOfStats {
	
	private ArrayList<NameStats> statistics;
	
	public ListOfStats()
	{
		// TODO Auto-generated constructor stub
		statistics = new ArrayList<NameStats>();
	}
	
	public int nameLocation(String name)
	{
		int location = -1;
		NameStats o = new NameStats(name);
		for(int i = 0; i < statistics.size(); i++)
			if(statistics.get(i).equals(o))
				return i;
		return location;
	}
	
	public void add(NameStats o)
	{
		statistics.add(o);
	}
	
	public void set(int index, NameStats n)
	{
		statistics.set(index, n);
	}
	
	public NameStats get(int index)
	{
		return statistics.get(index);
	}
	
	public int indexOf(NameStats n)
	{
		return statistics.indexOf(n);
	}
	
	public String toString()
	{
		String output = "";
		for(NameStats n : statistics)
			output += n.toString() + "\n";
		return output;
	}
	
	public String saveToFile()
	{
		String output = "";
		for(NameStats n : statistics)
			output += n.saveToFile() + "\n";
		return output;
	}

}
