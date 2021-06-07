package pandemiconline2.panonlinebackend.API;

import pandemiconline2.panonlinebackend.API.ViewModel.UserViewModel;
import pandemiconline2.panonlinebackend.DAL.UserDAL;
import pandemiconline2.panonlinebackend.Logic.Containers.UserContainer;
import pandemiconline2.panonlinebackend.Logic.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("UserApi")
@CrossOrigin
public class UserAPI {

    private final UserContainer userContainer;
    @Autowired
    public UserAPI(UserContainer container){
        this.userContainer = container;
    }

    @PostMapping(value= "/post", consumes = "application/json", produces = "application/json")
    public String AddUser(@RequestBody UserViewModel model) {
        try {
            User user = new User(model);
            user.AddUser(new UserDAL());
            return "User is toegevoegd!";
        } catch (Exception e) {
            return "Oops! Er is iets foutgegaan!";
        }
    }

    @PutMapping(value="/update", consumes="application/json", produces = "application/json")
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

    @GetMapping(value ="/get", consumes = "application/json", produces = "application/json")
    public User GetUser(UserViewModel model)
    {
        return userContainer.GetUser(model.getID());
    }

}

