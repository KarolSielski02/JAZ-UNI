package pl.pjatk.MVCProjetct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class MsvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcProjectApplication.class, args);
	}

}
