package pandemiconline2.panonlinebackend.API;

import pandemiconline2.panonlinebackend.API.ViewModel.UserRegisterViewModel;
import pandemiconline2.panonlinebackend.API.ViewModel.UserViewModel;
import pandemiconline2.panonlinebackend.DAL.UserDAL;
import pandemiconline2.panonlinebackend.Logic.Containers.UserContainer;
import pandemiconline2.panonlinebackend.Logic.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("user")
@CrossOrigin
public class UserAPI {

    private final UserContainer userContainer;

    public UserAPI(){
        this.userContainer = new UserContainer(new UserDAL());
    }

    @PostMapping(value= "/", consumes = "application/json", produces = "application/json")
    public String AddUser(@RequestBody UserRegisterViewModel model) {

            User user = new User(model);
            if (user.AddUser(new UserDAL())){
                return "User is toegevoegd!";
            }
            return "Oops er is iets foutgegaan!";
    }

    @PutMapping(value="/", consumes="application/json", produces = "application/json")
    public String UpdateUser(@RequestBody UserViewModel model){
        try{
            User user = new User(model);
            user.UpdateUser(new UserDAL());

            return "User is updated!";
        }
        catch(Exception e){
            return "Oops! Er is iets foutgegaan!";
        }
    }

    @GetMapping(value ="/", produces = "application/json")
    public User GetUser(UserViewModel model, HttpServletRequest request)

    {
        User user = userContainer.GetUser((long)request.getSession().getAttribute("user"));
        user.getId();
        return user;
    }
;
}

