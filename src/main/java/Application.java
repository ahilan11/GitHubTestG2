import old.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    private final static Logger LOG = LogManager.getLogger("Основной класс");

    public static void main(String[] args) {
        LOG.info("start");


        Map<String, User> userMap = new HashMap<>();

        List<User> users = new ArrayList<>();
        User admin = new User("admin", "123");
        User businessA = new User("businessA", "123qweqwe");
        User customer = new User("customer", "123qw");

        User availableUser = new User();

        userMap.put("admin", admin);
        userMap.put("businessA", businessA);
        userMap.put("customer", customer);


        int[] ints = new int[1];
        try {
            LOG.info(ints[2]);
        } catch (IndexOutOfBoundsException e) {
            LOG.error( "Обращение за пределами массива", e);
        }

        for (String username : userMap.keySet()) {
            User cycleUser = userMap.get(username);
            StringBuilder builder = new StringBuilder();
            builder.append("\nCurrent user data: {")
                    .append("\n")
                    .append("old.models.User id: ")
                    .append(cycleUser.getId())
                    .append("\n")
                    .append("Hidden Password: " )
                    .append(cycleUser.getPassword(true))
                    .append("\n");
                    LOG.info(builder);
        }



    }
}

