package beanDefinition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

@Configuration
public class App {
    public static void main(String[] arg) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("beanDefinition");
//        context.getBean(RestaurantService.class).order("Pizza");

//        BeanDefinition beanDefinition = ((GenericApplicationContext)context).getBeanDefinition("restaurantService");
//        System.out.println("beanDefinition " + beanDefinition);
//        System.out.println(beanDefinition.getClass());

        GenericBeanDefinition myBeanDefinition = new GenericBeanDefinition();
        myBeanDefinition.setBeanClass(App.MySuperClass.class);
        myBeanDefinition.setInitMethodName("myInitMethod");
        myBeanDefinition.setDestroyMethodName("myDestroyMethod");
        myBeanDefinition.setPropertyValues(myBeanDefinition.getPropertyValues().add("myProperty", "myValue"));
//        myBeanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);

        ((GenericApplicationContext)context).registerBeanDefinition("mySuperClass", myBeanDefinition);

//        BeanDefinition beanDefinition = ((GenericApplicationContext)context).getBeanDefinition("mySuperClass");
//        System.out.println("beanDefinition " + beanDefinition);
//        System.out.println(beanDefinition.getClass());

        context.getBean(MySuperClass.class).myMethod();
        context.getBean(MySuperClass.class).myMethod();

        context.close();
    }

    @Bean
    public FastCook fastCook() {
        return new FastCook();
    }

    @Bean
    public RestaurantService restaurantService() {
        return new RestaurantService(fastCook());
    }

    static class MySuperClass {
        private String myProperty;
        public MySuperClass() {
            System.out.println("MySuoerClass constructor");
        }

        public void setMyProperty(final String myProperty) {
            this.myProperty = myProperty;
        }

        public void myMethod() {
            System.out.println("It's my method");
            System.out.println("hash: " + this.hashCode());
        }

        public void myInitMethod() {
            System.out.println("It's my init method");
            System.out.println("my property: " + myProperty);
        }

        public void myDestroyMethod() {
            System.out.println("It's my Destroy method");
        }
    }
}
