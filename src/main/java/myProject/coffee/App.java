package myProject.coffee;

import myProject.coffee.App.RestaurantService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class App {
    public static void main(String[] arg) {
        // 1-й способ через xml
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        reader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
//        RestaurantService restaurantService = beanFactory.getBean(RestaurantService.class);
//        restaurantService.cook("Pizza");

        // 2-й способ через Java Config
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 3-й способ через аннотации
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("myProject.coffee");


        RestaurantService restaurantService = context.getBean(RestaurantService.class);
        restaurantService.cook("Pasta");
    }

    @Configuration
    static class AppConfig {
        @Bean
        public FastCook fastCook() {
            System.out.println("Calling fastCook()");
            return new FastCook();
        }

        @Bean
        public RestaurantService restaurantService() {
            System.out.println("Calling restaurantService()");
            return new RestaurantService(fastCook());
        }
    }

    static class RestaurantService {
        private FastCook fastCook;

        public RestaurantService(final FastCook fastCook) {
            this.fastCook = fastCook;
        }

        private void cook(String dish) {
            fastCook.cook(dish);
        }
    }

    static class FastCook {
        private void cook(String dish) {
            System.out.println("Cooking: " + dish);
        }
    }
}
