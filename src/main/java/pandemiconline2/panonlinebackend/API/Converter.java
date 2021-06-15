package pandemiconline2.panonlinebackend.API;

import pandemiconline2.panonlinebackend.API.ViewModel.UserViewModel;
import pandemiconline2.panonlinebackend.Logic.Models.User;

import java.util.ArrayList;
import java.util.List;

public class Converter
{
    public List<UserViewModel> UserListToViewModels(List<User> users){
        List<UserViewModel> models = new ArrayList<>();
        for (User user:users
             )
        {
            UserViewModel model = new UserViewModel();
            model.setUsername(user.getUsername());
            models.add(model);
        }
        return models;
    }
}
