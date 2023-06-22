package pl.pjatk.MovieService.Movie.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.MovieService.Movie.Model.Movie;
import pl.pjatk.MovieService.Movie.Service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/MoviesController")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> returnMovieList() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovieList());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findMovie(Integer.parseInt(id)));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        if (movie.getCategory() == null || movie.getName() == null) {
            throw new NullPointerException("Wrong object");
        }
        String category = movie.getCategory();
        String name = movie.getName();
        return ResponseEntity.status(HttpStatus.OK).body(movieService.addMovie(name, category));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> modifyMovie(@RequestBody Movie movie, @PathVariable String id) {
        String category = movie.getCategory();
        String name = movie.getName();
        return ResponseEntity.status(HttpStatus.OK).body(movieService.modifyMovie(Integer.parseInt(id), name, category));
    }

    @PutMapping("/changeToAvailable/{id}")
    public ResponseEntity<Movie> changeToAvailable(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.changeToAvailable(Integer.parseInt(id)));
    }

    @PutMapping("/changeToUnavailable/{id}")
    public ResponseEntity<Movie> changeToUnavailable(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.changeToUnavailable(Integer.parseInt(id)));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> modifyMovie(@PathVariable String id) {
        movieService.removeMovie(Integer.parseInt(id));
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
