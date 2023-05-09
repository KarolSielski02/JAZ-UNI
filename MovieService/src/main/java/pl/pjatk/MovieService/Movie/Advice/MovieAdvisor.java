package pl.pjatk.MovieService.Movie.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MovieAdvisor {

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleRuntimeException(ArrayIndexOutOfBoundsException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception occurred: " + e.getLocalizedMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> NullPointerException(NullPointerException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occurred: " + e.getLocalizedMessage());
    }
}
