package app.serviceImpl;

import app.domain.User;
import app.repositories.UserDao;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void createUser(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    public List<User> findUsersByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public int countOfBigPictures(byte[] size) {
        return userDao.countByProfilePictureGreaterThan(size);
    }
}
