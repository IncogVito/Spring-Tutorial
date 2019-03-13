package IncogVito.security.login.services;


public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
