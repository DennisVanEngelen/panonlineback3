package pandemiconline2.panonlinebackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pandemiconline2.panonlinebackend.API.AdminAPI;
import pandemiconline2.panonlinebackend.API.LoginAPI;
import pandemiconline2.panonlinebackend.API.ViewModel.AdminLoginViewModel;
import pandemiconline2.panonlinebackend.API.ViewModel.AdminViewModel;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.UserDAL;
import pandemiconline2.panonlinebackend.Logic.Service.LoginService;

public class APItest
{
    @Test
    void testAdminLogin()
    {
        LoginAPI api = new LoginAPI(new LoginService());
        AdminLoginViewModel model = new AdminLoginViewModel();
        model.setPassword("test123");

        model.setUsername("test");
        AdminViewModel viewmodel = api.AdminLogin(model);

        Assertions.assertTrue(viewmodel.getUsername().equals("test"));

    }

    @Test
    void  testAddUser(){
        UserDAL dal = new UserDAL();
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword("Boterham");
        userDTO.setUsername("Jan");
        userDTO.setEmailAddress("Jantje@Mail.com");
        dal.SaveUser(userDTO);;
    }
}
