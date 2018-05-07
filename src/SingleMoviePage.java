import java.util.LinkedList;

public class SingleMoviePage {
	String movieName;
	String director;
	String year;
	int id;
	String genre;
	public String getGenre()
	{
		return genre;
	}
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	LinkedList<String> starList = new LinkedList<String>();
	LinkedList<Integer> starId = new LinkedList<Integer>();
	public LinkedList<Integer> getStarId() {
		return starId;
	}
	public void setStarId(int i) {
		starId.add(i);
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public LinkedList<String> getStarList() {
		return starList;
	}
	public void setStarList(String star) {
		starList.add(star);
	}

	
	
	


}
