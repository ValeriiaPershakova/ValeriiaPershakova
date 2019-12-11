package hw6.cucumber1.storages;

import java.util.HashMap;
import java.util.Map;

public enum TestStorage {
    INSTANCE;

    private Map<String, Object> storage = new HashMap<>();

    public void setData(String key, Object data) {
        storage.put(key, data);
    }

    public <V> V getData(String key) {
        return (V) storage.get(key);
    }
}
