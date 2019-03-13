package IncogVito.security.login.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String login, String password);
}
