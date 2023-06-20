package lazzy.web.service;

import lazzy.web.dao.RoleDao;
import lazzy.web.dao.UserDao;
import lazzy.web.entity.RoleEntity;
import lazzy.web.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    private final UserDao userDao;
    private final RoleDao roleDao;

    public RoleService(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    public List<RoleEntity> getAllRoles() {
        return roleDao.getAllRoles();
    }

    public void assignRole(Long userId, Long roleId) {
        UserEntity user = userDao.getUser(userId);
        RoleEntity role = roleDao.getRoleById(roleId);
        user.addRole(role);
        userDao.updateUser(user);
    }

    public void removeRole(Long userId, Long roleId) {
        UserEntity user = userDao.getUser(userId);
        RoleEntity role = roleDao.getRoleById(roleId);
        user.removeRole(role);
        userDao.updateUser(user);
    }

    public void createRole(String roleName) {
        RoleEntity role = new RoleEntity(roleName);
        roleDao.createRole(role);
    }

    public void deleteRole(Long roleId) {
        roleDao.delete(roleId);
    }
}
