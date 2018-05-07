import java.util.LinkedList;

public class SingleStarPage {
	int id;
	String firstName;
	String lastName;
	LinkedList<String> movies = new LinkedList<>();
	LinkedList<Integer> moviekey = new LinkedList<>();
	String photoURL;
	String dob;
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	public LinkedList<Integer> getMoviekey() {
		return moviekey;
	}
	public void setMoviekey(int i) {
		moviekey.add(i);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LinkedList<String> getMovies() {
		return movies;
	}
	public void setMovies(String movie) {
		movies.add(movie);
	}
	

}
