package pandemiconline2.panonlinebackend.DAL.DataModels;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import pandemiconline2.panonlinebackend.DAL.DTO.GameStatisticsDTO;
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
public class UserDataModel implements Serializable
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, nullable = false)
        private Long id;

        @Column(unique = true, nullable = false)
        private String username;

        @Column(nullable = false)
        private String password;

        @Column(unique = true, nullable = false)
        private String email_address;

        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
        private List<GameStatisticsDataModel> gamesPlayed;

        public UserDataModel() { }

        public UserDataModel(UserDTO user)
        {
            username = user.getUsername();
            password = user.getPassword();
            email_address = user.getEmailAddress();
            gamesPlayed = new ArrayList<>();
            for (GameStatisticsDTO game:user.getGamesPlayed())
            {
                gamesPlayed.add(new GameStatisticsDataModel(game));
            }
        }


}
