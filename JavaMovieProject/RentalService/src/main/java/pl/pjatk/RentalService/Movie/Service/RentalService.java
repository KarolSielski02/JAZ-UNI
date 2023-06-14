package pl.pjatk.RentalService.Movie.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import pl.pjatk.RentalService.Movie.Advice.RentalAdvisor;
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

    Map<String, String> pathVariables = new HashMap<>();

    public Movie getMovie(Long id) {
        String url = "http://localhost:8080/MoviesController/movies/{id}";
        pathVariables.clear();
        pathVariables.put("id", id.toString());
        ResponseEntity<Movie> response = restTemplate.getForEntity(url, Movie.class, pathVariables);

        HttpStatusCode statusCode = response.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            return response.getBody();
        } else {
            statusHandler(statusCode);
        }
        return null;
    }

    public Movie changeToAvailable(Long id) {
        String url = "http://localhost:8080/MoviesController/changeToAvailable/{id}";
        pathVariables.clear();
        pathVariables.put("id", id.toString());
        ResponseEntity<Movie> response = restTemplate.getForEntity(url, Movie.class, pathVariables);

        HttpStatusCode statusCode = response.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            return response.getBody();
        } else {
            statusHandler(statusCode);
        }
        return null;
    }

    public Movie changeToUnavailable(Long id) {
        String url = "http://localhost:8080/MoviesController/changeToUnavailable/{id}";
        pathVariables.clear();
        pathVariables.put("id", id.toString());
        ResponseEntity<Movie> response = restTemplate.getForEntity(url, Movie.class, pathVariables);
        HttpStatusCode statusCode = response.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            return response.getBody();
        } else {
            statusHandler(statusCode);
        }
        return null;
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
