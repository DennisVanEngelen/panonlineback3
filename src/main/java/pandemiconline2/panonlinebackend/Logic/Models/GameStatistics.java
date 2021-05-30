package pandemiconline2.panonlinebackend.Logic.Models;

import lombok.Getter;
import lombok.Setter;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;

import java.util.HashSet;
import java.util.Set;
@Getter @Setter
public class GameStatistics
{
    private long ID;
    private boolean victorious;
    private int diseasesCured;
    private int movesMade;
    private Set<User> players = new HashSet<User>();

}
