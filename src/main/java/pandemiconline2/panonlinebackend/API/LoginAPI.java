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

    @PostMapping(value="/u", consumes = "application/json", produces = "application/json")
    public boolean UserLogin(@RequestBody UserLoginViewModel info, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = loginService.UserLogin(info, new UserDAL());
        if(user.getUsername()!=null)
        {
            session.setAttribute("user", user.getId());
            return true;
        }
        return false;

    }

    @PostMapping(value="/a", consumes = "application/json", produces = "application/json")
    public boolean AdminLogin(@RequestBody AdminLoginViewModel info, HttpServletRequest request, HttpServletResponse response)   {
        HttpSession session = request.getSession();
        Admin admin = loginService.AdminLogin(info,new AdminDAL());
        if(admin.getUsername()!=null){
            session.setAttribute("admin", admin.getId());

            return true;
        }
        return false;
    }

}
