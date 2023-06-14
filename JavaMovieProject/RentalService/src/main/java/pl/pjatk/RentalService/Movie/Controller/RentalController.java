package pl.pjatk.RentalService.Movie.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
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

    @GetMapping("/changeToAvailable/{id}")
    public ResponseEntity<String> returnMovie(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(rentalService.changeToAvailable(id) + " Availability changed to TRUE");
    }

    @GetMapping("/changeToUnavailable/{id}")
    public ResponseEntity<String> rentMovie(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(rentalService.changeToUnavailable(id) + " Availability changed to FALSE");
    }


}
