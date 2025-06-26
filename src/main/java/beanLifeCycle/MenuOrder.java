package beanLifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
//@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MenuOrder {

    public MenuOrder() {
        System.out.println("Constructor: Создан заказ, id заказа: " + this.hashCode());
    }

    public void order(String dish) {
        System.out.println("Заказано: " + dish);
    }

//    @PostConstruct
//    public void init() {
//        System.out.println("MenuOrder: call init()");
//    }
}
