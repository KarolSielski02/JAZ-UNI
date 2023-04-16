package pl.pjatk.MVCProjetct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class testController {

//    @GetMapping("/hello")
//    public ResponseEntity<String> helloWorld(){
//        return ResponseEntity.ok("Hello world");
//    }
//    @GetMapping("/model")
//    public Car returnCar(){
//        return new Car("Clio", "Renault", "Black", 102);
//    }

    @GetMapping("/hello/{testString}")
    public ResponseEntity<String> returnStringFromName(@PathVariable String testString){
        return ResponseEntity.status(HttpStatus.OK).body(testString);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> returnString(@RequestParam String testString){
        return ResponseEntity.status(HttpStatus.OK).body(testString);
    }

    @PostMapping("/CarModel")
    public Car createCar(@RequestBody Car car){
        System.out.println(car);
        return car;
    }
    @PostMapping("/CarModell")
    @ResponseBody
    public String createCar(String car){
        System.out.println(car);
        return car;
    }

}
