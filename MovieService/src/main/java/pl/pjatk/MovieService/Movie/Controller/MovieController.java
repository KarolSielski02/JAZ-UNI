package pl.pjatk.MovieService.Movie.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.MovieService.Movie.Model.Movie;
import pl.pjatk.MovieService.Movie.Service.MovieService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/MoviesController")
public class MovieController {

    MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> returnMovieList(){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovieList());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findMovie(Integer.parseInt(id)));
    }

    @PostMapping("/addMovie")
    public Movie createCar(@RequestBody Movie movie){
        System.out.println(movie.toString());
        return movieService
    }
}
