package pandemiconline2.panonlinebackend.Logic.Models;

import java.sql.ClientInfoStatus;
import java.util.List;

public class Country
{
    List<Country> ConnectedCountries;
    String name;
    boolean hasResearchStation;
    GameColor countryColor;
    List<Infection> infections;
    List<Player> playersInCountry;

    public void Infect(GameColor color)
    {
        for (Infection infection : infections)
        {
            if (infection.diseaseColor == color)
            {
                if (infection.infectionAmount < 3)
                    infection.infectionAmount++;
                else if(infection.infectionAmount == 3){
                    Outbreak(color);
                }
            }
        }
    }

    public void Outbreak(GameColor color){
        for (Country country : ConnectedCountries)
        {
            country.Infect(color);
        }
    }

    public void Cure(GameColor color, Player player)
    {
        for (Infection infection : infections)
        {
            if (infection.diseaseColor == color)
            {
                if (player.playerClass == PlayerClass.Medic)
                {

                }
            }
        }
    }

}
