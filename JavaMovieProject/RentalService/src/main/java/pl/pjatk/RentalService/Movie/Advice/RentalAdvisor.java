package pl.pjatk.RentalService.Movie.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.net.ConnectException;

@RestControllerAdvice
public class RentalAdvisor {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleStatus(ResponseStatusException exception) {
        HttpStatus statusCode = (HttpStatus) exception.getStatusCode();
        if (statusCode == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (statusCode == HttpStatus.BAD_REQUEST) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Undefined error");
        }
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> handleConnectException(){
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).build();
    }
}


