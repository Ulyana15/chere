package beanScopes;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.StreamHandler;

//@Component
//@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MenuOrder implements InitializingBean, DisposableBean {

    public MenuOrder() {
        System.out.println("Constructor: Создан заказ, id заказа: " + this.hashCode());
    }

    public void order(String dish) {
        System.out.println("Заказано: " + dish);
    }

    @PostConstruct
    public void init1() {
        System.out.println("MenuOrder: init чере PostConstruct");
        System.out.println("класс MenuOrder: " + this.getClass());
    }

    @PreDestroy
    public void destroy1() {
        System.out.println("MenuOrder: destroy через @PreDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MenuOrder: init через InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MenuOrder: destroy через DisposableBean");
    }

    public void init2() {
        System.out.println("MenuOrder: init чере init2()");
    }

    public void destroy2() {
        System.out.println("MenuOrder: destroy через destroy2()");
    }
}
