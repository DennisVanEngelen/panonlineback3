package pandemiconline2.panonlinebackend.API;

import pandemiconline2.panonlinebackend.API.ViewModel.UserViewModel;
import pandemiconline2.panonlinebackend.Logic.Containers.UserContainer;
import pandemiconline2.panonlinebackend.Logic.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("UserApi")
@CrossOrigin
public class UserAPI {

    UserContainer userContainer;
    @Autowired
    public UserAPI(UserContainer container){
        this.userContainer = container;
    }

    @PostMapping(value= "/post", consumes = "application/json", produces = "application/json")
    public String AddUser(@RequestBody UserViewModel user) {
        try {
            userContainer.SaveUser(new User(user));
            return "User is toegevoegd!";
        } catch (Exception e) {
            return "Oops! Er is iets foutgegaan!";
        }
    }

    @PutMapping(value="/update", consumes="application/json")
    public String UpdateUser(@RequestBody UserViewModel user){
        try{
            userContainer.UpdateUser(new User(user));
            return "User is updated!";
        }
        catch(Exception e){
            return "Oops! Er is iets foutgegaan!";
        }
    }

    @GetMapping("/get")
    public User GetUser(UserViewModel model)
    {
        return new User(model);
    }

    @GetMapping("/getAll")
    public UserContainer GetPatients(){
        return userContainer;
    }
}

