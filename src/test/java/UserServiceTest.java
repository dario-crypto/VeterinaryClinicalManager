/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.veterinaryclinicmanager.model.Role;
import com.mycompany.veterinaryclinicmanager.model.User;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.veterinaryclinicmanager.repositories.BaseService;
import com.mycompany.veterinaryclinicmanager.repositories.UserService;

/**
 *
 * @author user
 */
public class UserServiceTest {

    UserService userService = UserService.getInstance(new BaseService());
    

    public UserServiceTest() {
    }

    @Test
    public void findByIdWhenNotExist() {

        User uFound = userService.findById(0L);
        assertEquals(null, uFound);

    }

    @Test
    public void add() {

        User user = new User("Luigi", "Rossi", "M", "0432423432", "luigi@gmail.com", "luigi");
        userService.save(user);
        User uFound = userService.findByUsername("luigi@gmail.com");

        //undo
        userService.removeById(uFound.getId());
        assertEquals(user, uFound);

    }

    @Test
    public void removeById() {

        User user = new User("Luigi", "Rossi", "M", "0432423432", "luigi@gmail.com", "luigi");

        userService.save(user);
        User uFound = userService.findByUsername("luigi@gmail.com");
        userService.removeById(uFound.getId());
        
        User uFound2 = userService.findByUsername("luigi@gmail.com");
        assertEquals(null, uFound2);

    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
