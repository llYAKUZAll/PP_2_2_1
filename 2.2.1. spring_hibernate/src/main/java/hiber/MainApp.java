package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("HONDA CIVIC", 13);
        Car car2 = new Car("BMW M3", 154);
        Car car3 = new Car("MAZDA RX-7", 654);
        Car car4 = new Car("NISSAN GTR", 1435);

        userService.add(new User("Niko", "Belich", "user1@mail.ru", car1));
        userService.add(new User("Tommy", "Vercetti", "user2@mail.ru", car2));
        userService.add(new User("Carl", "Johnson", "user3@mail.ru", car3));
        userService.add(new User("John", "Snow", "user4@mail.ru", car4));

        List<User> users = userService.getListUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());

            System.out.println(userService.getUserByCar("HONDA CIVIC", 13));
        }

        context.close();
    }
}
