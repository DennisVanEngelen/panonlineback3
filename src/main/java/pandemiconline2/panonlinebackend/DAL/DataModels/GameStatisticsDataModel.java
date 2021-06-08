package pandemiconline2.panonlinebackend.DAL.DataModels;

import lombok.Getter;
import lombok.Setter;
import pandemiconline2.panonlinebackend.DAL.DTO.GameStatisticsDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = true, updatable = false, referencedColumnName = "id")
    private UserDataModel user;

public GameStatisticsDataModel(){}

public GameStatisticsDataModel(GameStatisticsDTO dto){
    this.victorious = dto.isVictorious();
    this.movesMade = dto.getMovesMade();
    this.diseasesCured = dto.getDiseasesCured();
}
}
