package hw6.cucumber1.storages;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public enum  UserStorage {
    PITER_CHAILOVSKII("epam","1234");

    UserStorage(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

//    public static Map<String, Pair<String, String>> users = new HashMap<>();
//
//    static {
//        Pair<String, String> pair = new Pair<>("epam", "1234");
//        users.put("PITER CHAILOVSKII", pair);
//    }
}
