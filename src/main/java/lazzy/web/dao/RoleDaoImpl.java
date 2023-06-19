package lazzy.web.dao;

import lazzy.web.entity.RoleEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RoleEntity> getAllRoles() {
        TypedQuery<RoleEntity> query = entityManager.createQuery("SELECT r FROM RoleEntity r", RoleEntity.class);
        return query.getResultList();
    }

    @Override
    public RoleEntity getRole(long id) {
        return entityManager.find(RoleEntity.class, id);
    }
    @Override
    public RoleEntity getRoleById(Long roleId) {
        return entityManager.find(RoleEntity.class, roleId);
    }

    @Override
    public void createRole(RoleEntity role) {
        entityManager.persist(role);
    }
}