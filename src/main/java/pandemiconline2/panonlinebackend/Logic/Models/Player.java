package pandemiconline2.panonlinebackend.Logic.Models;

import java.util.List;

enum PlayerClass{
    Dispatcher,
    Medic,
    Researcher,
    Scientist,
    QuarantineSpecialist,
    OperationsExpert,
    ContingencyPlanner
}
public class Player
{
    PlayerClass playerClass;
    List<PlayerCard> hand;

}
