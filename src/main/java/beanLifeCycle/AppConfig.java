package beanLifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
@Import(AppConfig2.class)
public class AppConfig {

    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public MenuOrder menuOrder() {
        System.out.println("вызван метод manuOrder()");
        return new MenuOrder();
    }

    @Bean
    public IRestaurantService restaurantService() {
        System.out.println("вызван метод restaurantService()");
        MenuOrder menuOrder = menuOrder();
        return new RestaurantService(menuOrder);
    }
}
