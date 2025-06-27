package beanScopes;

import javax.annotation.PostConstruct;

public interface IRestaurantService {
    @PostConstruct
    default void init() {
        System.out.println("IRestaurantService init()");
    }

    @PostConstruct
    void init1();
}
