package pandemiconline2.panonlinebackend.DAL.DataModel;

import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Getter
@Setter
@Table(name = "User")
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

        @ManyToMany(cascade = {CascadeType.ALL})
        @JoinTable(
                name = "User_GamesPlayed",
                joinColumns = {@JoinColumn(name = "user_id")},
                inverseJoinColumns = { @JoinColumn(name = "statistics_id")}
        )
        private Set<GameStatisticsDataModel> gamesPlayed = new HashSet<>();


        public UserDataModel() { }

        public UserDataModel(UserDTO user)
        {
            this.id = user.getId();
            username = user.getUsername();
            password = user.getPassword();
            email_address = user.getEmailAddress();
        }


}
