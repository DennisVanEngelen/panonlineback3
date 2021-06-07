package pandemiconline2.panonlinebackend.DAL.Interface;

import org.springframework.stereotype.Component;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;

import javax.persistence.Column;
import java.util.List;
@Component
public interface IUserContainer
{
    List<UserDTO> GetAllUsers();
    UserDTO GetUser(long id);

}
