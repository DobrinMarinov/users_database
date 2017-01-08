package app.terminal;

import app.domain.User;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setUsername("Dobo");
        user.setEmail("dobod@abv.bg");
        user.setPassword("AaBb#Cc23Dd12");
        user.setRegisteredOn(new Date());
        user.setLastTimeLoggedIn(new Date());
        user.setDeleted(false);
        user.setAge(22);

        File pic = new File("res/image.jpg");
        byte[] picBytes = new byte[(int) pic.length()];
        FileInputStream fis = new FileInputStream(pic);
        fis.read(picBytes);
        fis.close();
        user.setProfilePicture(picBytes);

        user.setDeleted(true);

        userService.createUser(user);

        List<User> users = userService.findUsersByEmail("dobod@abv.bg");
        for (User us : users) {
            System.out.println(us.getEmail());
        }

        int count = userService.countOfBigPictures(new byte[100]);
        System.out.println(count);

    }
}
