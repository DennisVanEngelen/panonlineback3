package pandemiconline2.panonlinebackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pandemiconline2.panonlinebackend.API.AdminAPI;
import pandemiconline2.panonlinebackend.API.LoginAPI;
import pandemiconline2.panonlinebackend.API.ViewModel.AdminLoginViewModel;
import pandemiconline2.panonlinebackend.API.ViewModel.AdminViewModel;
import pandemiconline2.panonlinebackend.DAL.DTO.GameStatisticsDTO;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.UserDAL;
import pandemiconline2.panonlinebackend.Logic.Service.LoginService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class APItest
{
    @Test
    void testAdminLogin()
    {

    }

    @Test
    void  testAddUser(){
        UserDAL dal = new UserDAL();
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword("Boterham");
        userDTO.setUsername("JanKlaasenPeter");
        userDTO.setEmailAddress("Jantjesbesteemail@Mail.com");
        List<GameStatisticsDTO> games = new ArrayList<>();
        games.add(new GameStatisticsDTO());
        userDTO.setGamesPlayed(games);
        dal.SaveUser(userDTO);;
    }
}
