/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import com.mycompany.veterinaryclinicmanager.model.Comment;
import com.mycompany.veterinaryclinicmanager.model.Role;
import com.mycompany.veterinaryclinicmanager.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import utils.MyEntityManager;

/**
 *
 * @author user
 */
public class UserService extends Service implements UserRepository {

    private static UserService userService;

    private UserService() {

    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }

        return userService;

    }

    @Override
    public User findById(Long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        return user;
    }

    public void update(Long id, User user) {
        entityManager.getTransaction().begin();
        User u = entityManager.find(User.class, id);
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        entityManager.getTransaction().commit();

    }

    @Override
    public User findByUsername(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root);
        cr.select(root).where(cb.equal(root.get("email"), username));
        TypedQuery<User> query = entityManager.createQuery(cr);

        return query.getSingleResult();
    }

    public void removeById(Long id) {

        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();

    }

    @Override
    public void save(User user) {
        entityManager.getTransaction().begin();
        RoleService roleService =RoleService.getInstance();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        

    }

    public static void addUsers() {
        UserService us = userService.getInstance();
        
        //modifica la relazione in uno a moltro tra utenti e ruoli

        //creazione admin
        User u1 = new User();
        u1.setName("pippo");
        u1.setEmail("pippo@gmail.com");
        u1.setGender("M");
        u1.setPassword("pippo");
        Role r1 = new Role("ROLE_ADMIN");
        u1.addRole(r1);
        us.save(u1);

        //creazione utente generico
        User u2 = new User();
        u2.setName("pluto");
        u2.setEmail("pluto@gmail.com");
        u2.setGender("M");
        u2.setPassword("pluto");
        Role r2 = new Role("ROLE_USER");
        u2.addRole(r2);
        us.save(u2);
        
        User u4 = new User();
        u4.setName("dario");
        u4.setEmail("dario@gmail.com");
        u4.setGender("M");
        u4.setPassword("dario");
        Role r = new Role("ROLE_USER");
        u4.addRole(r);
        us.save(u4);

        //creazione staff
        
        User u3 = new User();
        u3.setName("paperina");
        u3.setEmail("paperina@gmail.com");
        u3.setGender("F");
        u3.setPassword("paperina");
        Role r3 = new Role("ROLE_STAFF");
        u3.addRole(r3);
        us.save(u3);
        

    }

    public static void main(String args[]) {
        //UserService us = userService.getInstance();
        addUsers();

        /*

       
        User user = new User();
        user.setName("pippo");
        user.setEmail("pippo@gmail.com");
        user.setGender("M");
        user.setPassword("pippo");
        RoleRepository roleRepository = RoleService.getInstance();
       // Role role = roleRepository.findById(3L);
        Role role = new Role("ADMIN");
        user.addRole(role);
        us.save(user);
         */
        //User user = us.findById(752L);
        //System.out.println(user.getEmail());
    

    }

}
