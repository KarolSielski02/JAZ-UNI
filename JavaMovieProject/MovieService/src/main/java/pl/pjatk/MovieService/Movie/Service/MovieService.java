package pl.pjatk.MovieService.Movie.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.Movie.Model.Movie;
import pl.pjatk.MovieService.Movie.Repository.MovieRepository;

import java.util.List;
import java.util.Random;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(String name, String category) {
        Movie movie = new Movie(generateId(), name,category,false);
        movieRepository.addMovie(name,category);
        return movie;
    }

    public Movie modifyMovie(int ID, String name, String category) {
        if (movieRepository.getById(ID) != null) {
            Movie movie = movieRepository.getById(ID);
            if (name == null || category == null) {
                throw new NullPointerException();
            }
            movie.setName(name);
            movie.setCategory(category);
            movieRepository.updateMovieByIDAndNameAndCategory(name,category,ID);
            return movie;
        } else {
            throw new NullPointerException("ID doesn't exist");
        }
    }

    public void removeMovie(int ID) {
        if (movieRepository.getById(ID) == null) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            movieRepository.deleteById(ID);
        }
    }

    public Movie findMovie(int ID) {
        if (movieRepository.getById(ID) == null){
            throw new NullPointerException();
        }else {
            return movieRepository.getById(ID);
        }
    }

    public List<Movie> getMovieList() {
        return movieRepository.findAll();
    }

    public Movie changeToAvailable(int ID){
        if (movieRepository.getById(ID) == null) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            movieRepository.changeToAvailableForID(ID);
            return movieRepository.getById(ID);
        }
    }

    public Movie changeToUnavailable(int ID) {
        if (movieRepository.getById(ID) == null) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            movieRepository.changeToUnavailableForID(ID);
            return movieRepository.getById(ID);
        }
    }

    public static int generateId() {
        int idLength = 10;
        int minIdValue = (int) Math.pow(10, idLength - 1);
        int maxIdValue = (int) Math.pow(10, idLength) - 1;

        Random random = new Random();
        return random.nextInt(maxIdValue - minIdValue + 1) + minIdValue;
    }

    public static int generateId(int idLength) {
        int minIdValue = (int) Math.pow(10, idLength - 1);
        int maxIdValue = (int) Math.pow(10, idLength) - 1;

        Random random = new Random();
        return random.nextInt(maxIdValue - minIdValue + 1) + minIdValue;
    }

}
