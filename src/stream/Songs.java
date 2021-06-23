package stream;

public class Songs 
{
	private String name;
	private String artist;
	private int year;
	private String combined;
	private int playsCount;
	private int worldwidePlaysCount;

	public Songs() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCombined() {
		return combined;
	}
	public void setCombined(String combined) {
		this.combined = combined;
	}
	public int getPlaysCount() {
		return playsCount;
	}
	public void setPlaysCount(int playsCount) {
		this.playsCount = playsCount;
	}
	public int getWorldwidePlaysCount() {
		return worldwidePlaysCount;
	}
	public void setWorldwidePlaysCount(int worldwidePlaysCount) {
		this.worldwidePlaysCount = worldwidePlaysCount;
	}

}
