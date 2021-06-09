package pandemiconline2.panonlinebackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pandemiconline2.panonlinebackend.API.ViewModel.AdminLoginViewModel;
import pandemiconline2.panonlinebackend.DAL.DTO.AdminDTO;
import pandemiconline2.panonlinebackend.Logic.Containers.UserContainer;
import pandemiconline2.panonlinebackend.Logic.Models.Admin;
import pandemiconline2.panonlinebackend.Logic.Models.User;
import pandemiconline2.panonlinebackend.Logic.Service.LoginService;

import java.util.List;

public class AdminTest
{
    AdminTestRepo repo = new AdminTestRepo();
    UserTestRepo userRepo = new UserTestRepo();
    UserContainer container = new UserContainer(userRepo);
    @Test
    void AdminGetUsersTest(){

        List<User> users = container.GetAllUsers();
        Assertions.assertEquals(users.size(), 5);

    }
    @Test
    void AdminUpdateUserTest(){
        User user = container.GetUser(3);
        String currentusername = user.getUsername();
        user.setUsername("AdminUser");
        user.UpdateUser(userRepo);

        User updatedUser = container.GetUser(3);
        Assertions.assertTrue(!updatedUser.getUsername().equals(currentusername));
    }
    @Test
    void AdminDeleteUserTest(){
        User user = container.GetUser(3);
        user.DeleteUser(userRepo);

        Assertions.assertNull(container.GetUser(3));
    }

    @Test
    void AdminLoginTest(){
        LoginService loginService = new LoginService();
        AdminLoginViewModel model = new AdminLoginViewModel();
        model.setUsername("testadmin1");
        model.setPassword("testpass1");
        Admin admin = loginService.AdminLogin(model, repo);

        Assertions.assertNotNull(admin);
    }
}
