package pl.pjatk.RentalService.Movie.Service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import pl.pjatk.RentalService.Movie.Advice.RentControllerAdvice;
import pl.pjatk.RentalService.Movie.Model.Movie;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        ResponseEntity<Movie> response = restTemplate.getForEntity("http://localhost:8080/MoviesController/movies/" + id, Movie.class);

        HttpStatusCode statusCode = response.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            return response.getBody();
        } else {
            statusHandler(statusCode);
        }
        return null;
    }

    public int changeToAvailable(Long id) {
        Movie someMovie = new Movie();
        someMovie.setAvailable(false);
        HttpEntity<Movie> entity = new HttpEntity<>(someMovie);
        ResponseEntity response = restTemplate.exchange("http://localhost:8080/MoviesController/changeToAvailable/" + id, HttpMethod.PUT, entity  ,Void.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return 0;
        } else {
            statusHandler(response.getStatusCode());
        }
        return 1;
    }

    public int changeToUnavailable(Long id) {
        Movie someMovie = new Movie();
        someMovie.setAvailable(true);
        HttpEntity<Movie> entity = new HttpEntity<>(someMovie);
        ResponseEntity response = restTemplate.exchange("http://localhost:8080/MoviesController/changeToUnavailable/" + id, HttpMethod.PUT, entity  ,Void.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return 0;
        } else {
            statusHandler(response.getStatusCode());
        }
        return 1;
    }

    private void statusHandler(HttpStatusCode statusCode) {
        if (statusCode == HttpStatus.NOT_FOUND) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else if (statusCode == HttpStatus.BAD_REQUEST) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
