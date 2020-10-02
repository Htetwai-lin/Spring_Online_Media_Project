package coder.daos;

import coder.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    List<User> getAllUser();

    User getUserById(int id);

    User getUserByName(String name);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
