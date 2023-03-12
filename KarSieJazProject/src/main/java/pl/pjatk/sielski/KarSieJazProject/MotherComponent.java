package pl.pjatk.sielski.KarSieJazProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MotherComponent {

    FirstComponent firstComponent;
    SecondComponent secondComponent;
    public MotherComponent(ApplicationContext applicationContext) {
        firstComponent = applicationContext.getBean("firstComponent", FirstComponent.class);
        secondComponent = applicationContext.getBean("secondComponent", SecondComponent.class);
    }

    public void print(){
        System.out.println(firstComponent.print());
        System.out.println(secondComponent.print());
    }
}
