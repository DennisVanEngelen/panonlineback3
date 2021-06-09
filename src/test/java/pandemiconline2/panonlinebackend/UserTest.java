package pandemiconline2.panonlinebackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pandemiconline2.panonlinebackend.API.ViewModel.AdminLoginViewModel;
import pandemiconline2.panonlinebackend.API.ViewModel.UserLoginViewModel;
import pandemiconline2.panonlinebackend.DAL.DTO.GameStatisticsDTO;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.Logic.Containers.UserContainer;
import pandemiconline2.panonlinebackend.Logic.Models.Admin;
import pandemiconline2.panonlinebackend.Logic.Models.User;
import pandemiconline2.panonlinebackend.Logic.Service.LoginService;

import java.util.ArrayList;
import java.util.List;

public class UserTest
{
    UserTestRepo repo = new UserTestRepo();
    UserContainer container = new UserContainer(repo);
    @Test
    void GetUserTest(){
        User user = container.GetUser(4);
        Assertions.assertTrue(user.getUsername().equals("testuser4"));
    }

    @Test
    void SaveUserTest(){
        long userID = 6;
        long statsid = 1;
        List<GameStatisticsDTO> stats = new ArrayList<>();
        stats.add(new GameStatisticsDTO(statsid,true,1,1));
        UserDTO userDTO = new UserDTO(userID,"testuser","testpass","testmail",stats);
        User user = new User(userDTO);
        user.AddUser(repo);

        Assertions.assertTrue(container.GetAllUsers().size() > 5);
    }
    @Test
    void UpdateUserTest(){
        User user = container.GetUser(3);
        String currentusername = user.getUsername();
        user.setUsername("SuperUser");
        user.UpdateUser(repo);

        User updatedUser = container.GetUser(3);
        Assertions.assertTrue(!updatedUser.getUsername().equals(currentusername));
    }

    @Test
    void LoginUserTest(){
        LoginService loginService = new LoginService();
        UserLoginViewModel model = new UserLoginViewModel("testuser2", "testpass2");
        User user = loginService.UserLogin(model, repo);

        Assertions.assertNotNull(user);
    }

}
