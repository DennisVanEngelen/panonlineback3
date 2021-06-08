package pandemiconline2.panonlinebackend.API;

import org.springframework.web.bind.annotation.*;
import pandemiconline2.panonlinebackend.API.ViewModel.AdminLoginViewModel;
import pandemiconline2.panonlinebackend.API.ViewModel.AdminViewModel;
import pandemiconline2.panonlinebackend.API.ViewModel.UserLoginViewModel;
import pandemiconline2.panonlinebackend.Logic.Models.Admin;
import pandemiconline2.panonlinebackend.Logic.Models.User;
import pandemiconline2.panonlinebackend.Logic.Service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/Login")
@CrossOrigin
public class LoginAPI
{
    private final LoginService loginService;

    public LoginAPI(LoginService _loginService){
        loginService = _loginService;
    }

    @PostMapping(value="/userLogin", consumes = "application/json", produces = "application/json")
    public String UserLogin(@RequestBody UserLoginViewModel info, HttpServletRequest request){
//        HttpSession session = request.getSession();
        User user = loginService.UserLogin(info);
//        session.setAttribute("patientId", user.getId());
//        return session.getId();
        return "Hello";
    }

    @PostMapping(value="/adminLogin", consumes = "application/json", produces = "application/json")
    public AdminViewModel AdminLogin(@RequestBody AdminLoginViewModel info){
//        HttpSession session = request.getSession();
       Admin admin = loginService.AdminLogin(info);
//        session.setAttribute("patientId", admin.getId());
//        return session.getId();
        AdminViewModel model = new AdminViewModel();
        model.setPassword(admin.getPassword());
        model.setUsername(admin.getUsername());
        return model;
    }

}
