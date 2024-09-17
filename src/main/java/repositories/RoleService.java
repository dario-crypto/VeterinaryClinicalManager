/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import com.mycompany.veterinaryclinicmanager.model.Role;
import com.mycompany.veterinaryclinicmanager.model.User;
import java.lang.Long;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import utils.MyEntityManager;

/**
 *
 * @author user
 */
public class RoleService extends Service implements RoleRepository {

    private static RoleService roleService;

    private RoleService() {

    }

    public static RoleService getInstance() {
        if (roleService == null) {
            roleService = new RoleService();
        }

        return roleService;
    }

    public Role findByName(String roleName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> cr = cb.createQuery(Role.class);
        Root<Role> root = cr.from(Role.class);
        cr.select(root);
        cr.select(root).where(cb.equal(root.get("role"), roleName));
        TypedQuery<Role> query = entityManager.createQuery(cr);
        return query.getSingleResult();

    }

    @Override
    public void save(Role role) {
        entityManager.getTransaction().begin();
        entityManager.persist(role);
        entityManager.getTransaction().commit();

    }

    public static void main(String[] args) {
        RoleRepository roleRepo = RoleService.getInstance();

        /*
        Role r1 = new Role("USER");
        Role r2 = new Role("STAFF");
        Role r3 = new Role("ADMIN");
      
        roleRepo.save(r1);
        roleRepo.save(r2);
        roleRepo.save(r3);

         */
        Role role = roleRepo.findById(1L);
        System.out.println("ROLE FOUND: " + role.getRole());

    }

    @Override
    public Role findById(Long id) {
        entityManager.getTransaction().begin();
        Role role = entityManager.find(Role.class, id);
        entityManager.getTransaction().commit();
        return role;
    }

}
