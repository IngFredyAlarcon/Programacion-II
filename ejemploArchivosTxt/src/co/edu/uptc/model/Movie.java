package co.edu.uptc.model;

public class Movie {
    private String name;
    private String genero;
    private String director;
    private int year;
    private String sinopsis;
    private String image;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return "Movie [name=" + name + ", genero=" + genero + ", director=" + director + ", year=" + year
                + ", sinopsis=" + sinopsis + ", image=" + image + "]";
    }

    
}
