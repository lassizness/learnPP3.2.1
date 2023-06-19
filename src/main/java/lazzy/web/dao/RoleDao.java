package lazzy.web.dao;

import lazzy.web.entity.RoleEntity;
import java.util.List;

public interface RoleDao{

    List<RoleEntity> getAllRoles();
    RoleEntity getRole(long id);
    void createRole(RoleEntity role) ;
    RoleEntity getRoleById(Long roleId);
    }

