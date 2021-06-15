package pandemiconline2.panonlinebackend;

import pandemiconline2.panonlinebackend.DAL.DTO.AdminDTO;
import pandemiconline2.panonlinebackend.DAL.DTO.GameStatisticsDTO;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.Interface.IUser;
import pandemiconline2.panonlinebackend.DAL.Interface.IUserContainer;

import java.util.ArrayList;
import java.util.List;

public class UserTestRepo implements IUser, IUserContainer
{
    List<UserDTO> users = new ArrayList<>();
    List<GameStatisticsDTO> stats = new ArrayList<>();
    long statsid =1;
    public UserTestRepo()
    {
        stats.add(new GameStatisticsDTO(statsid,true,1,1));
        for (long i = 0; i < 5; i++) {
            users.add(new UserDTO(i,"testuser"+i,"testpass"+i,"testmail"+1,stats));
        }
    }

    public UserDTO LoginUser(String username, String password){
        for (UserDTO userDTO:users)
        {
            if (userDTO.getUsername().equals(username)&&userDTO.getPassword().equals(password)){
                return userDTO;
            }
        }
        return null;
    }

    public boolean SaveUser(UserDTO userDTO)
    {
        users.add(userDTO);
        return true;
    }


    public void DeleteUser(long userID)
    {
        users.removeIf(user -> user.getId() == userID);
    }


    public void UpdateUser(UserDTO userDTO)
    {
        for (UserDTO user :users
        )
        {
            if(user.getId() == userDTO.getId()){
                users.set((int) (user.getId()-1), userDTO);
            }
        }
    }


    public List<UserDTO> GetAllUsers()
    {
        return users;
    }


    public UserDTO GetUser(long id)
    {
        for (UserDTO user :users
             )
        {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
