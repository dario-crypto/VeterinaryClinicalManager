/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.veterinaryclinicmanager.model.Role;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.veterinaryclinicmanager.repositories.BaseService;
import com.mycompany.veterinaryclinicmanager.repositories.RoleService;

/**
 *
 * @author user
 */
public class RoleServiceTest {
    
    RoleService roleService = RoleService.getInstance(new BaseService());
    
    public RoleServiceTest() {
    }
    @Test
    public void addRole() {
        String roleName = "ROLE_ADMIN";
        Role admin = new Role("ROLE_ADMIN");
        
        roleService.save(admin);
        
        Role role = roleService.findByName(roleName);
        assertEquals(roleName, role.getRole());
        
        
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
