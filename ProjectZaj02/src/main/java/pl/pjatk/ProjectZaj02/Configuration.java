package pl.pjatk.ProjectZaj02;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public PojoClass returnPojoClass() {
        return new PojoClass();
    }

    @Bean
    @ConditionalOnProperty(
            name = "spring.boolean.value",
            havingValue = "true")
    public List<String> defaultConfiguration() {
        System.out.println("I hate java, I hate java, I hate java");
        return List.of("One", "Two", "Three", "Four", "Five");
    }


}
