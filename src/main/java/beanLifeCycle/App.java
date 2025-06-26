package beanLifeCycle;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@Configuration
public class App {
    public static void main(String[] arg) throws InterruptedException {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        context.getBean(IRestaurantService.class).order("pizza");
        context.getBean(IRestaurantService.class).order("pasta");

        context.close();
    }
}
