package pandemiconline2.panonlinebackend.DAL.Interface;

import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;

public interface IUser
{

    boolean SaveUser(UserDTO userDTO);
    void DeleteUser(long userID);
    void UpdateUser(UserDTO userDTO);
    UserDTO LoginUser(String username, String password);
}
