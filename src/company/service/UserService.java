package company.service;

import company.model.User;
import company.service.impl.MyException;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(int id) throws MyException;
    User getById(int id) throws MyException;
    List<User> getAllUsers();

}
