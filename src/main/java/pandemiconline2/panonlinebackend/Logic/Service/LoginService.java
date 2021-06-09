package pandemiconline2.panonlinebackend.Logic.Service;

import org.springframework.stereotype.Service;
import pandemiconline2.panonlinebackend.API.ViewModel.AdminLoginViewModel;
import pandemiconline2.panonlinebackend.API.ViewModel.UserLoginViewModel;
import pandemiconline2.panonlinebackend.DAL.AdminDAL;
import pandemiconline2.panonlinebackend.DAL.Interface.IAdmin;
import pandemiconline2.panonlinebackend.DAL.Interface.IUser;
import pandemiconline2.panonlinebackend.DAL.UserDAL;
import pandemiconline2.panonlinebackend.Logic.Models.Admin;
import pandemiconline2.panonlinebackend.Logic.Models.User;

@Service
public class LoginService
{
    private UserDAL userDAL;
    private AdminDAL adminDAL;

    public User UserLogin(UserLoginViewModel info, IUser userDAL){
        try
        {
            return new User(userDAL.LoginUser(info.getUsername(), info.getPassword()));
        }
        catch (Exception ex){
            return null;
        }
    }

    public Admin AdminLogin(AdminLoginViewModel info, IAdmin adminDAL){
        try
        {
            Admin admin = new Admin(adminDAL.LoginAdmin(info.getUsername(), info.getPassword()));
            return admin;
        }
        catch (Exception ex){
            return null;
        }

    }

}
