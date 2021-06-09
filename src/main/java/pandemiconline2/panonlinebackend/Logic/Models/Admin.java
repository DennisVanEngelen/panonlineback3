package pandemiconline2.panonlinebackend.Logic.Models;

import lombok.Getter;
import lombok.Setter;
import pandemiconline2.panonlinebackend.DAL.DTO.AdminDTO;
@Getter
@Setter
public class Admin
{
    private long id;
    private String username;
    private String password;

    public Admin(AdminDTO dto){
        username = dto.getUsername();
        password = dto.getPassword();
        id = dto.getId();

    }

}
