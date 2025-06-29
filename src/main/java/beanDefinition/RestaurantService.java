package beanDefinition;

import org.springframework.stereotype.Component;

@Component
public class RestaurantService {
    private FastCook fastCook;

    public RestaurantService(final FastCook fastCook) {
        this.fastCook = fastCook;
    }

    public void order(String dish) {
        fastCook.cook(dish);
    }
}
