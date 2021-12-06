package old.models;

import old.additional.TestAnnotation;
import old.additional.UserStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class User extends Record {


    private final static Logger LOG = LogManager.getLogger("Пользователь");

    private String username;
    private String password;
    private UserStatus status;
    private Date created;

    private static int countOfUsers = 0;

    public User(String username, String password) {
        super(countOfUsers);
        this.username = username;
        this.password = password;
        this.created = new Date();
        countOfUsers++;
        LOG.debug(String.format("Created user: %s. Created at: %s. Current count of users: %s.", username, created, countOfUsers));
    }

    public User() {
        super(countOfUsers);
        LOG.debug("Created empty user");
    }

    public String getUsername() {
        return username;
    }

    @TestAnnotation(1)
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword(boolean isForReporting) {
        if (isForReporting) {
            return getSecretfield(this.password);
        } else {
            return password;
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void printId() {
        LOG.debug("Id: " + this.getId());
    }
}
