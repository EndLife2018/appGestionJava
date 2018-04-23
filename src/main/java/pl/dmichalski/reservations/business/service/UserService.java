package pl.dmichalski.reservations.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.User;
import pl.dmichalski.reservations.business.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    private User currentUser;

    public Boolean loginUser(String username, String password) {
        currentUser = userRepository.findByUsernameEqualsAndPasswordEquals(username, password);
        return currentUser != null;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
