package pandemiconline2.panonlinebackend.API;

import org.springframework.web.bind.annotation.*;
import pandemiconline2.panonlinebackend.API.ViewModel.AdminLoginViewModel;
import pandemiconline2.panonlinebackend.API.ViewModel.AdminViewModel;
import pandemiconline2.panonlinebackend.API.ViewModel.UserLoginViewModel;
import pandemiconline2.panonlinebackend.DAL.AdminDAL;
import pandemiconline2.panonlinebackend.DAL.UserDAL;
import pandemiconline2.panonlinebackend.Logic.Models.Admin;
import pandemiconline2.panonlinebackend.Logic.Models.User;
import pandemiconline2.panonlinebackend.Logic.Service.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginAPI
{
    private final LoginService loginService;

    public LoginAPI(LoginService _loginService){
        loginService = _loginService;
    }

    @PostMapping(value="/user", consumes = "application/json")
    public long UserLogin(@RequestBody UserLoginViewModel info){

        User user = loginService.UserLogin(info, new UserDAL());
        if(user.getUsername()!=null)
        {
            return user.getId();
        }
        return 0;
    }

    @PostMapping(value="/admin", consumes = "application/json")
    public long AdminLogin(@RequestBody AdminLoginViewModel info)   {
        Admin admin = loginService.AdminLogin(info,new AdminDAL());
        if(admin.getUsername()!=null){

            return admin.getId();
        }
        return 0;
    }

}
