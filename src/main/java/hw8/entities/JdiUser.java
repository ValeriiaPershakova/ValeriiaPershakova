package hw8.entities;

import static java.lang.String.format;

public class JdiUser {
    public static final JdiUser ROMAN = new JdiUser("Roman", "Jdi1234", "ROMAN IOVLEV");

    private final String login;
    private final String password;
    private final String fullName;

    public JdiUser(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return format("%s:%s %s", login, password, fullName);
    }

}
