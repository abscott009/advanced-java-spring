package platform.codingnomads.co.springdata.example.dml.introducingrepositories.crudrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@SpringBootApplication
public class CrudRepoDemo implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudRepoDemo.class);
    }

    //autowire the UserRepo into the class to gain access to the CRUD methods
    @Autowired
    UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        //create new user
        User user = User.builder().firstName("Bobby").lastName("Bobbert").age(56).weight(210).height(72).bloodType("A-").build();
        User user2 = User.builder().firstName("Joanne").lastName("Joanna").age(36).weight(135).height(59).bloodType("O-").build();
        User user3 = User.builder().firstName("Davey").lastName("Jones").age(100).weight(187).height(63).bloodType("AB+").build();
        User user4 = User.builder().firstName("Phil").lastName("McCracken").age(27).weight(225).height(78).bloodType("B+").build();


        //save user and assign what is returned to the user variable.
        user = userRepo.save(user);
        user2 = userRepo.save(user2);
        user3 = userRepo.save(user3);
        user4 = userRepo.save(user4);


        Iterable<User> users = userRepo.findAll();

        for(User u : users){
            System.out.println(u.toString());
        }

        //delete the user using the id of the inserted user object
//        userRepo.deleteById(user.getId());
//        userRepo.deleteById(user2.getId());
//        userRepo.deleteById(user3.getId());
//        userRepo.deleteById(user4.getId());
    }
}
