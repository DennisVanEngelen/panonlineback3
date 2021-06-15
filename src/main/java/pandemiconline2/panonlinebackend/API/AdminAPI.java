package pandemiconline2.panonlinebackend.API;

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
@RequestMapping("admin")
@CrossOrigin
public class AdminAPI
{
    UserContainer userContainer;
    public AdminAPI(){
        this.userContainer = new UserContainer(new UserDAL());
    }

    @PutMapping(value="/u", consumes="application/json")
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
    @DeleteMapping (value ="/u",consumes = "application/json", produces = "application/json")
    public void DeleteUser(@RequestBody UserViewModel model)
    {
        User user = new User(model);
        user.DeleteUser(new UserDAL());
    }
    @GetMapping("/g")
    public User GetUser(long id){
        return userContainer.GetUser(id);
    }

    @GetMapping("/ga")
    public List<User> GetAllUsers()
    {
        return userContainer.GetAllUsers();
    }

}
