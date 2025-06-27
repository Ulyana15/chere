package beanLifeCycle;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@InitMethod("init")
//@Component
public class RestaurantService implements IRestaurantService {
    @Autowired
    private MenuOrder menuOrder;

    public RestaurantService(MenuOrder menuOrder) {
        this.menuOrder = menuOrder;
        System.out.println("RestaurantService: создан ресторан под названием: " + this.getClass() + " - " + this.hashCode());
        System.out.println("RestaurantService: MenuOrder: " + menuOrder.getClass());
    }

    public RestaurantService() {
        System.out.println("RestaurantService: создан ресторан под названием: " + this.getClass() + " - " + this.hashCode());
    }

    @SneakyThrows
    @Override
    public void order(String dish) {
        menuOrder.order(dish);
    }
}
