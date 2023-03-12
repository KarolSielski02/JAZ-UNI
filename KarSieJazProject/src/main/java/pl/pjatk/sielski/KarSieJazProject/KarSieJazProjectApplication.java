package pl.pjatk.sielski.KarSieJazProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KarSieJazProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(KarSieJazProjectApplication.class, args);
	}

	public KarSieJazProjectApplication(MotherComponent motherComponent) {
		motherComponent.print();
	}
}
