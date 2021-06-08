package pandemiconline2.panonlinebackend.DAL.DataModels;

import lombok.Getter;
import lombok.Setter;
import pandemiconline2.panonlinebackend.DAL.DTO.AdminDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
public class AdminDataModel implements Serializable
{
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public AdminDataModel() {}
    public AdminDataModel(AdminDTO adminDTO){
        this.username = adminDTO.getUsername();
        this.password = adminDTO.getPassword();
    }
}
