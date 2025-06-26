package beanLifeCycle;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyScope implements Scope {

    private Map<String, Map.Entry<LocalDateTime, Object>> beans = new ConcurrentHashMap<>();
    private Map<String, Runnable> destroyCallback = new ConcurrentHashMap<>();


    @Override
    public Object get(final String name, final ObjectFactory<?> objectFactory) {
        beans.computeIfAbsent(name, k -> new AbstractMap.SimpleEntry<>(LocalDateTime.now(), objectFactory.getObject()));

        return beans.computeIfPresent(name, (k, v) -> {
            LocalDateTime time = v.getKey();
            if (time.isBefore(LocalDateTime.now().minusSeconds(5))) {
                return new AbstractMap.SimpleEntry<>(LocalDateTime.now(), objectFactory.getObject());
            }

            return v;
        }).getValue();
    }

    @Override
    public Object remove(final String name) {
        destroyCallback.remove(name);
        return beans.remove(name);
    }

    @Override
    public void registerDestructionCallback(final String name, final Runnable callback) {
        destroyCallback.put(name, callback);

    }

    @Override
    public Object resolveContextualObject(final String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "myScope";
    }
}
