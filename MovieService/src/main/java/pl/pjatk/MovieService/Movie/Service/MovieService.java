package pl.pjatk.MovieService.Movie.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.Movie.Model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    static List<Movie> movieList = new ArrayList<>();
    public MovieService() {
        movieList.add(new Movie(0, "Cars", "Action movie"));
        movieList.add(new Movie(1, "Cars 2", "Action movie"));
        movieList.add(new Movie(2, "Cars 3", "Action movie"));
        movieList.add(new Movie(3, "Airplanes", "Action movie"));
    }

    public int addMovie( String name, String category){

        movieList.add(new Movie(movieList.size(), name, category));
        return 0;
    }

    public int removeMovie(int ID){
        for (Movie movie : movieList){
            if (movie.getID() == ID){
                movieList.remove(movie);
                return 0;
            }
        }
        return 1;
    }

    public Movie findMovie(int ID){
        for (Movie movie : movieList){
            if (movie.getID() == ID){
                return movie;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
