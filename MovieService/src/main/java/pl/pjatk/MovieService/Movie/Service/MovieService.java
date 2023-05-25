package pl.pjatk.MovieService.Movie.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.Movie.Model.Movie;
import pl.pjatk.MovieService.Movie.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(String name, String category) {
        Movie movie = new Movie(Integer.parseInt(UUID.randomUUID().toString()), name, category);
        movieRepository.save(movie);
        return movie;
    }

    public Movie modifyMovie(int ID, String name, String category) {
        if (movieRepository.existsById(ID)) {
            Movie movie = movieRepository.getById(ID);
            if (name == null || category == null) {
                throw new NullPointerException();
            }
            movie.setName(name);
            movie.setCategory(category);
            movieRepository.save(movie);
            return movie;
        } else {
            throw new NullPointerException("ID doesn't exist");
        }
    }

    public void removeMovie(int ID) {
        if (movieRepository.findById(ID).isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            movieRepository.deleteById(ID);
        }
    }

    public Movie findMovie(int ID) {
        return movieRepository.findById(ID).orElseThrow(NullPointerException::new);
    }

    public List<Movie> getMovieList() {
        return movieRepository.findAll();
    }
}
