package service;

import model.Gender;
import model.Response;
import model.User;

public interface UserService {
    Response<User> login(String username, String pass);
    Response<User> register(User user);
}
