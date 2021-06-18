package pandemiconline2.panonlinebackend.API;

import org.springframework.web.bind.annotation.*;
import pandemiconline2.panonlinebackend.API.ViewModel.UserViewModel;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.UserDAL;
import pandemiconline2.panonlinebackend.Logic.Containers.AdminContainer;
import pandemiconline2.panonlinebackend.Logic.Containers.UserContainer;
import pandemiconline2.panonlinebackend.Logic.Models.Admin;
import pandemiconline2.panonlinebackend.Logic.Models.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("adminapi")
@CrossOrigin
public class AdminAPI
{
    UserContainer userContainer;
    public AdminAPI(){
        this.userContainer = new UserContainer(new UserDAL());
    }

    @PutMapping(value="/user", consumes="application/json")
    public boolean UpdateUser(@RequestBody UserViewModel model){
        try{
            User user = new User(model);
            user.UpdateUser(new UserDAL());
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    @DeleteMapping (value ="/user/{id}")
    public void DeleteUser(@PathVariable int id)
    {
        User user = new User(id);
        user.DeleteUser(new UserDAL());
    }
    @GetMapping("/user/{id}")
    public User GetUser(@PathVariable int id){
        return userContainer.GetUser(id);
    }

    @GetMapping(value = "/user", produces = "application/json")
    public List<UserViewModel> GetAllUsers()
    {
        List<UserViewModel> models = new ArrayList<>();
        List<User> users= userContainer.GetAllUsers();
        for (User user: users
             )
        {
            UserViewModel model = new UserViewModel();
            model.setUserid(user.getId());
            model.setUsername(user.getUsername());
            model.setEmail(user.getEmailAddress());
            models.add(model);
        }
        return models;

    }

}
