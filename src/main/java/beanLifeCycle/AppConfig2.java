package beanLifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class AppConfig2 {

    @Bean
    public IRestaurantService restaurantService() {
        System.out.println("вызван метод restaurantService() AppConfig2");
        return new RestaurantService();
    }
}
