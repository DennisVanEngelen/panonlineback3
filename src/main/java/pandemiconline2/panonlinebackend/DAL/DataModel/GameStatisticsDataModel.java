package pandemiconline2.panonlinebackend.DAL.DataModel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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



//    @ManyToOne
//    @JoinColumn
//    private UserDataModel GamePlayedUser;
}
