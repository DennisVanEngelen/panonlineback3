package pandemiconline2.panonlinebackend.DAL.DataModel;

import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity @Getter
@Setter
public class UserDataModel implements Serializable
{

        @Id
        @GeneratedValue
        @Column(updatable = false, nullable = false)
        private Long id;

        @Column(unique = true, nullable = false)
        private String username;

        @Column(nullable = false)
        private String password;

        @Column(unique = true, nullable = false)
        private String email_address;

//        @OneToMany(mappedBy = "GameStatistics")
//        private List<GameStatisticsDataModel> statistics = new ArrayList<GameStatisticsDataModel>();

        public UserDataModel() { }

        public UserDataModel(UserDTO user)
        {
            this.id = user.getId();
            username = user.getUsername();
            password = user.getPassword();
            email_address = user.getEmailAddress();
        }


}
