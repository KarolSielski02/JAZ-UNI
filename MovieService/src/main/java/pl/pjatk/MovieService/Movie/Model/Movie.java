package pl.pjatk.MovieService.Movie.Model;

public class Movie {
    private int ID;
    private String category,name;

    public Movie(int ID, String name, String category) {
        this.ID = ID;
        this.name = name;
        this.category = category;
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
                '}';
    }
}
