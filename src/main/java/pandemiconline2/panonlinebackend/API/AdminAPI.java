package pandemiconline2.panonlinebackend.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pandemiconline2.panonlinebackend.API.ViewModel.UserViewModel;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.UserDAL;
import pandemiconline2.panonlinebackend.Logic.Containers.AdminContainer;
import pandemiconline2.panonlinebackend.Logic.Containers.UserContainer;
import pandemiconline2.panonlinebackend.Logic.Models.Admin;
import pandemiconline2.panonlinebackend.Logic.Models.User;

import java.util.List;

@RestController
@RequestMapping("AdminApi")
@CrossOrigin
public class AdminAPI
{
    UserContainer userContainer;
    @Autowired
    public AdminAPI(UserContainer container){
        this.userContainer = container;
    }

    @PutMapping(value="/update", consumes="application/json")
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
    @DeleteMapping (value ="deleteUser",consumes = "application/json", produces = "application/json")
    public void DeleteUser(@RequestBody UserViewModel model)
    {
        User user = new User(model);
        user.DeleteUser(new UserDAL());
    }
    @GetMapping("/getUser")
    public User GetUser(long id){
        return userContainer.GetUser(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> GetAllUsers()
    {
        return userContainer.GetAllUsers();
    }

}
