package pl.pjatk.MovieService.Movie.Model;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String name;
    private String category;
    private Boolean is_available;

    public Movie(int ID, String name, String category, Boolean is_available) {
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.is_available = is_available;
    }

    public Movie() {

    }

    public Boolean getAvailable() {
        return is_available;
    }

    public void setAvailable(Boolean available) {
        is_available = available;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", is_available=" + is_available +
                '}';
    }
}
