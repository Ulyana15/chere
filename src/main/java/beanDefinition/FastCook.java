package beanDefinition;

import org.springframework.stereotype.Component;

@Component
public class FastCook {
    public void cook(String dish) {
        System.out.println("я быстрый повар");
        System.out.println("Cooking: " + dish);
    }
}
