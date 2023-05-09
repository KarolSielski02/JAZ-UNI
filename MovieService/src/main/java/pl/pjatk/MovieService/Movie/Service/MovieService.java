package pl.pjatk.MovieService.Movie.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.Movie.Model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    static List<Movie> movieList = new ArrayList<>();
    private String category;

    public MovieService() {
        movieList.add(new Movie(0, "Cars", "Action movie"));
        movieList.add(new Movie(1, "Cars 2", "Action movie"));
        movieList.add(new Movie(2, "Cars 3", "Action movie"));
        movieList.add(new Movie(3, "Airplanes", "Action movie"));
    }

    public Movie addMovie(String name, String category) {
        Movie movie = new Movie(movieList.size() - 1, name, category);
        System.out.println(movie);
        movieList.add(movie);
        return movie;
    }

    public Movie modifyMovie(int ID, String name, String category) {
        Movie movie = findMovie(ID);

        if (name == null || category == null) {
            throw new NullPointerException();
        }
        movie.setName(name);
        movie.setCategory(category);
        System.out.println(movie);
        System.out.println(movieList);
        return movie;
    }

    public void removeMovie(int ID) {
        if (ID > movieList.size() || ID < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        movieList.removeIf(movie -> movie.getID() == ID);
        System.out.println(movieList);
    }

    public Movie findMovie(int ID) {
        for (Movie movie : movieList) {
            if (movie.getID() == ID) {
                return movie;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
