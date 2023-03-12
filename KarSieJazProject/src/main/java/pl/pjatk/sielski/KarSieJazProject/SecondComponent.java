package pl.pjatk.sielski.KarSieJazProject;

import org.springframework.stereotype.Component;

@Component
public class SecondComponent {
    public SecondComponent() {
    }

    public String print(){
        return "Hello from the first Component + print(2)";
    }
}
