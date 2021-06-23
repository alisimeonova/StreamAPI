package stream;

import java.util.Comparator;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

import stream.Songs;

public class Program {

	public static void main(String[] args) 
	{
		List<Songs> songs = Parser.parse("./src/resources/classic-rock-song-list.csv");
		System.out.println(songs.size());
		
		//first(songs);
		
		//second(songs);
		
		//System.out.println(third(songs));
		
		fourth(songs);
		
		//fifth(songs);
	}
	
	public static void first(List<Songs> songs)
	{
		songs.stream().
		filter(x -> !x.getName().startsWith("A")
				&& !x.getName().startsWith("O")
				&& !x.getName().startsWith("U")
				&& !x.getName().startsWith("E")
				&& !x.getName().startsWith("I")).
		map(x -> x.getName()).
		forEach(x -> System.out.println(x));
	}
	
	public static void second(List<Songs> songs)
	{
		songs.stream().
		filter(x -> x.getPlaysCount() > 100).
		map(x -> x.getArtist()).
		forEach(x -> System.out.println(x));
	}
	
	public static long third(List<Songs> songs)
	{
		long result = songs.stream().
				filter(x -> x.getYear() >= 1975 && x.getYear() <= 1980).
				count();
		
		return result;
	}
	
	public static void fourth(List<Songs> songs)
	{
		Comparator<Songs> c = new Comparator<Songs>() 
		{

			@Override
			public int compare(Songs s1, Songs s2) 
			{
				if(s1.getPlaysCount() > s2.getPlaysCount())
				{
					return -1;
				}
				else if(s1.getPlaysCount() < s2.getPlaysCount())
				{
					return 1;
				}
				else
				{
					for(int i = 0; i < s1.getName().length(); i++)
					{
						if(i < s2.getName().length())
						{
							if(s1.getName().charAt(i) == s2.getName().charAt(i))
							{
								return 0;
							}
							else if(s1.getName().charAt(i) > s2.getName().charAt(i))
							{
								return 1;
							}
							else
							{
								return -1;
							}
						}
					}
				}
				return 2;
			}
			
		};
		
		songs.stream().
		filter(x -> x.getPlaysCount() < 20).
		sorted(c).
		forEach(x -> System.out.println(x.getName() + x.getArtist()));
	}
	
	public static void fifth(List<Songs> songs)
	{
		Comparator<Songs> c = new Comparator<Songs>()
				{

					@Override
					public int compare(Songs s1, Songs s2) 
					{
						if(s1.getPlaysCount() > s2.getPlaysCount())
						{
							return 1;
						}
						else if(s1.getPlaysCount() < s2.getPlaysCount())
						{
							return -1;
						}
						else
						{
							return 0;
						}
					}
			
				};
				
		songs.stream().
		filter(x -> x.getName().split(" ").length > 2).
		sorted(c).map(x -> x.getName()).
		distinct().
		forEach(x -> System.out.println(x));
	}

}
