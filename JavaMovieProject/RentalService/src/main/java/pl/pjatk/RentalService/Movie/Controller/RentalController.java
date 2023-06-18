package pl.pjatk.RentalService.Movie.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.RentalService.Movie.Model.Movie;
import pl.pjatk.RentalService.Movie.Service.RentalService;

@RestController
@RequestMapping("/RentalController")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(rentalService.getMovie(id));
    }

    @PostMapping("/changeToAvailable/{id}")
    public ResponseEntity returnMovie(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(rentalService.changeToAvailable(id));
    }

    @PostMapping("/changeToUnavailable/{id}")
    public ResponseEntity rentMovie(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(rentalService.changeToUnavailable(id));
    }


}
