package chapter03;

public class Song {
	private String Title;
	private String Artist;
	private String Album;
	private String Composer;
	private int Track;
	private int Year;
	
	public Song() {
		
	}
	
	public Song(String title, String artist, String album, String composer,int track, int year) {
		this.Title = title;
		this.Artist = artist;
		this.Album = album;
		this.Composer = composer;
		this.Track = track;
		this.Year = year;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getArtist() {
		return Artist;
	}
	public void setArtist(String artist) {
		Artist = artist;
	}
	public String getAlbum() {
		return Album;
	}
	public void setAlbum(String album) {
		Album = album;
	}
	public String getComposer() {
		return Composer;
	}
	public void setComposer(String composer) {
		Composer = composer;
	}
	public int getTrack() {
		return Track;
	}
	public void setTrack(int track) {
		Track = track;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	
	public void show() {
		System.out.println(Artist + " " + Title + "("+Album+", "+ Composer + ", " +Track + ", " +Year +")");
	}
	
}
