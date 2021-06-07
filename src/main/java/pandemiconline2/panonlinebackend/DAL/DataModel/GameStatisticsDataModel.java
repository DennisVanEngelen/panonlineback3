package pandemiconline2.panonlinebackend.DAL.DataModel;

import lombok.Getter;
import lombok.Setter;
import pandemiconline2.panonlinebackend.Logic.Models.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Getter @Setter
public class GameStatisticsDataModel implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private long ID;

    @Column
    private boolean victorious;

    @Column
    private int diseasesCured;

    @Column
    private int movesMade;

    @ManyToMany(mappedBy = "gamesPlayed")
    private Set<UserDataModel> players = new HashSet<UserDataModel>();



}
