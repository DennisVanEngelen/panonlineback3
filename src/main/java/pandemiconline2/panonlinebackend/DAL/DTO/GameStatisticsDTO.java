package pandemiconline2.panonlinebackend.DAL.DTO;

import lombok.Getter;
import lombok.Setter;
import pandemiconline2.panonlinebackend.DAL.DataModels.GameStatisticsDataModel;
import pandemiconline2.panonlinebackend.DAL.DataModels.UserDataModel;
import pandemiconline2.panonlinebackend.Logic.Models.GameStatistics;
import pandemiconline2.panonlinebackend.Logic.Models.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class GameStatisticsDTO
{
    private long ID;
    private boolean victorious;
    private int diseasesCured;
    private int movesMade;

    public GameStatisticsDTO(GameStatisticsDataModel dataModel)
    {
        this.ID = dataModel.getID();
        this.victorious = dataModel.isVictorious();
        this.diseasesCured = dataModel.getDiseasesCured();
        this.movesMade = dataModel.getMovesMade();
    }

    public GameStatisticsDTO(GameStatistics model)
    {
        this.ID = model.getID();
        this.victorious = model.isVictorious();
        this.diseasesCured = model.getDiseasesCured();
        this.movesMade = model.getMovesMade();
    }
    public GameStatisticsDTO(){}

    public GameStatisticsDTO(long id, boolean victorious, int cured, int moves){
        this.ID = id;
        this.victorious = victorious;
        this.diseasesCured=cured;
        this.movesMade = moves;
    }
}
