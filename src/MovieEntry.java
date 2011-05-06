public class MovieEntry {
	private String movieTitle;
	private int releaseYear;
	private String director;
	public MovieEntry(String movieTitle, int releaseYear, String director){
		this.movieTitle = movieTitle;
		this.releaseYear = releaseYear;
		this.director = director;
	}
	public String toString(){
		return movieTitle+"---"+releaseYear+"---"+director;
	}
	public boolean equals(Object o){
		return (movieTitle.compareToIgnoreCase(((MovieEntry)o).movieTitle) == 0);
	}
}
