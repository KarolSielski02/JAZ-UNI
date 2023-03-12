package pl.pjatk.sielski.KarSieJazProject;

import org.springframework.stereotype.Component;

@Component
public class FirstComponent {

    public FirstComponent() {

    }

    public String print(){
        return "Hello from the first Component + print(1)";
    }

}
