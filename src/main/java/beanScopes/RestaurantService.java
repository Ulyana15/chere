package beanScopes;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class RestaurantService implements IRestaurantService, InitializingBean, DisposableBean, ApplicationContextAware {
    @Value("супер пупер")
    private String restaurantName;

    private MenuOrder menuOrder;

    public RestaurantService(final MenuOrder menuOrder) {
        this.menuOrder = menuOrder;
//        System.out.println("класс menuOrder: " + menuOrder.getClass().getName());
//        System.out.println("RestaurantService: создан ресторан под названием: " + restaurantName);
    }

    public void order(String dish) {
//        System.out.println("ресторан: " + this.hashCode());
        menuOrder.order(dish);
    }

    @PostConstruct
    public void init1() {
        System.out.println("RestaurantService: init1 чере PostConstruct");
    }

//    @PostConstruct
//    public void init1_5() {
//        System.out.println("RestaurantService: init1_5 чере PostConstruct");
//    }

    @PreDestroy
    public void destroy1() {
        System.out.println("RestaurantService: destroy через @PreDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("RestaurantService: init через InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("RestaurantService: destroy через DisposableBean");
    }

    public void init2() {
        System.out.println("RestaurantService: init чере init2()");
    }

    public void destroy2() {
        System.out.println("RestaurantService: destroy через destroy2()");
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        System.out.println("RestaurantService: setApplicationContext()");
        System.out.println("RestaurantService: создан ресторан под названием: " + restaurantName);
    }
}
