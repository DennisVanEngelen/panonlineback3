package pandemiconline2.panonlinebackend.DAL.DTO;

import lombok.Getter;
import lombok.Setter;
import pandemiconline2.panonlinebackend.DAL.DataModels.GameStatisticsDataModel;
import pandemiconline2.panonlinebackend.DAL.DataModels.UserDataModel;
import pandemiconline2.panonlinebackend.Logic.Models.GameStatistics;
import pandemiconline2.panonlinebackend.Logic.Models.User;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class GameStatisticsDTO
{
    private long ID;
    private boolean victorious;
    private int diseasesCured;
    private int movesMade;
    private Set<UserDTO> players = new HashSet<UserDTO>();

    public GameStatisticsDTO(GameStatisticsDataModel dataModel)
    {
        this.ID = dataModel.getID();
        this.victorious = dataModel.isVictorious();
        this.diseasesCured = dataModel.getDiseasesCured();
        this.movesMade = dataModel.getMovesMade();
        for (UserDataModel user :dataModel.getPlayers())
        {
            players.add(new UserDTO(user));
        }
    }

    public GameStatisticsDTO(GameStatistics model)
    {
        this.ID = model.getID();
        this.victorious = model.isVictorious();
        this.diseasesCured = model.getDiseasesCured();
        this.movesMade = model.getMovesMade();
        for (User user :model.getPlayers())
        {
            players.add(new UserDTO(user));
        }
    }
}
