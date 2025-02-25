package co.edu.uptc.model;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private String synopsis;
    
    public Movie() {
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getSynopsis() {
        return synopsis;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + ", year=" + year + ", genre=" + genre + ", synopsis=" + synopsis + "]";
    }

}
