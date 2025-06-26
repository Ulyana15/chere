package beanScopes;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.util.function.Supplier;

@Configuration
public class App {
    public static void main(String[] arg) throws InterruptedException {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("beanScopes");
        context.getBeanFactory().registerScope("myScope", new MyScope());

        context.getBean(RestaurantService.class).order("Pizza");
//        context.getBean(RestaurantService.class).order("Pasta");
        context.close();
    }

    @Bean(initMethod = "init1", destroyMethod = "destroy1")
    public RestaurantService restaurantService() {
        return new RestaurantService(menuOrder());
    }

    @Bean(initMethod = "init2", destroyMethod = "destroy2")
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public MenuOrder menuOrder() {
        return new MenuOrder();
    }
}
