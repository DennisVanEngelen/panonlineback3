package pandemiconline2.panonlinebackend.DAL;

import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.DataModels.UserDataModel;

import java.util.ArrayList;
import java.util.List;

public class Converter
{
    List<UserDTO>convertUserDataModelToDTO(List<UserDataModel> models){
        List<UserDTO> dtos = new ArrayList<>();
        for (UserDataModel model :models)
        {
            UserDTO userDTO = new UserDTO(model);
            dtos.add(userDTO);
        }
        return dtos;
    }
}
