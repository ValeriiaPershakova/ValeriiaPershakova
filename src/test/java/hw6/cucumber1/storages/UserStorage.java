package hw6.cucumber1.storages;

public enum UserStorage {
    PITER_CHAILOVSKII("epam", "1234");

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

}
