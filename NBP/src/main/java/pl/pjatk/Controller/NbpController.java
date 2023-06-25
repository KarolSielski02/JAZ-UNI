package pl.pjatk.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.Model.NbpModel;
import pl.pjatk.Service.NbpService;

@RestController
@RequestMapping("/NBP")
public class NbpController {

    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping("/kursy/{currency}/{startDate}/{endDate}")
    public ResponseEntity<NbpModel> saveToDb(@PathVariable String currency, @PathVariable String startDate, @PathVariable String endDate) throws JsonProcessingException {
        System.out.println("Hello from saveToDb");
        return ResponseEntity.status(HttpStatus.OK).body(nbpService.getInfoFromApiAndSendToDb(currency, startDate, endDate));
    }
}
