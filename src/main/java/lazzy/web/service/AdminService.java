package lazzy.web.service;

import lazzy.web.dao.UserDao;
import lazzy.web.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class AdminService {// UserDetailsService определяет метод loadUserByUsername

    private final UserDao userDao;

    @Autowired
    public AdminService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserEntity addUser(UserEntity user) {
        userDao.saveUser(user);
        return user;
    }

    public UserEntity updateUser(UserEntity user) {
        userDao.updateUser(user);
        return user;
    }

    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    public UserEntity getUser(long id) {
        return userDao.getUser(id);
    }

    public List<UserEntity> getAllUsers() {
        return userDao.getUsers();
    }

}
