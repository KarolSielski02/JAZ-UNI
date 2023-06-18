package pl.pjatk.RentalService.Movie.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.net.ConnectException;

@RestControllerAdvice
public class RentControllerAdvice {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> errorHandler(ResponseStatusException ex){
        HttpStatusCode statusCode = ex.getStatusCode();
        if (HttpStatus.NOT_FOUND.equals(statusCode)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.toString());
        } else if (HttpStatus.BAD_REQUEST.equals(statusCode)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("XD" + ex.toString());
        } else if (HttpStatus.INTERNAL_SERVER_ERROR.equals(statusCode)) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(ex.toString());
        }


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.toString());
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> errorHandlerConnect(ResponseStatusException ex){
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(ex.toString());
    }
}