package company.service.impl;

import company.dao.UserDao;
import company.model.User;
import company.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
      UserDao userDao=new UserDao() ;

    @Override
    public void add(User user) {
        userDao.getUsers().add(user);
    }

    @Override
    public void delete(int id) throws MyException {
        boolean isTrue = true;
        for (int i = 0; i < userDao.getUsers().size(); i++) {
            if (id == userDao.getUsers().get(i).getId()) {
                userDao.getUsers().remove(userDao.getUsers().get(i));
                isTrue=false;

            }
        }   if(isTrue) {
            throw new MyException("User with this id: " + id + " is not found");
        }
    }

    @Override
    public User getById(int id) throws MyException {
        boolean isTrue = true;
        User user = new User();
        for (int i = 0; i < userDao.getUsers().size(); i++) {
            if (userDao.getUsers().get(i).getId() == id) {
                user = userDao.getUsers().get(i);
                isTrue = false;
                break;
            }
        }
        if (isTrue) {
            throw new MyException("");

        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getUsers();
    }
}
