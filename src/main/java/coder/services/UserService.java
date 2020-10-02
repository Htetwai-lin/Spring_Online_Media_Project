package coder.services;

import coder.daos.AuthorityDao;
import coder.daos.UserDao;
import coder.models.Authority;
import coder.models.User;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthorityDao authorityDao;


    public List<User> getAllUser() {
        return userDao.getAllUser();
    }


    public User getUserById(int id) {
       return userDao.getUserById(id);
    }

    public User getUserByName(String name){
        return userDao.getUserByName(name);
    }

    public void addUser(User user) {
       userDao.addUser(user);
    }


    public void updateUser(User user) {
       userDao.updateUser(user);
    }


    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public void addAuthority(Authority authority){
        authorityDao.addAuthority(authority);
    }
}
