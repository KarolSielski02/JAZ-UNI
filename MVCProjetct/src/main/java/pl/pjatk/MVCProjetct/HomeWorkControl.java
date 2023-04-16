package pl.pjatk.MVCProjetct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homework")
public class HomeWorkControl {

    @GetMapping("/hello1/{testString}")
    public ResponseEntity<String> returnStringFromName(@PathVariable String testString){
        return ResponseEntity.status(HttpStatus.OK).body(testString);
    }

    @GetMapping("/hello2")
    public ResponseEntity<String> returnString(@RequestParam String testString){
        return ResponseEntity.status(HttpStatus.OK).body(testString);
    }
}
