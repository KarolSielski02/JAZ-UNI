package pl.pjatk.ProjectZaj02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class MyFirstComponent {
    public MyFirstComponent(@Value("${my.custom.property:AAAAAAAAAAAAAAAAAAA}") String valueFromProperty) {
        System.out.println(valueFromProperty);
    }
}
