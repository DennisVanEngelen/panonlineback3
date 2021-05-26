package pandemiconline2.panonlinebackend.Logic.Models;

import java.util.List;

public class GameManager{
    Map map;

    List<InfectionCard> infectionCardDeck;
    List<PlayerCard> playerCardDeck;

    List<InfectionCard> drawnInfectionCards;
    List<InfectionCard> discardedInfectionCards;
    List<PlayerCard> discardedPlayerCards;

    List<Player> players;

    Player activePlayer;
    int activePlayerNumber;

    public void NextTurn()
    {
      if (activePlayerNumber == players.size()-1)
      {
          activePlayerNumber++;
          activePlayer = players.get(activePlayerNumber);
      }

    }

    public void DrawInfectionCard()
    {
        InfectionCard drawnCard = infectionCardDeck.get(0);
        infectionCardDeck.remove(drawnCard);
        drawnCard.country.Infect(drawnCard.country.countryColor);
        drawnInfectionCards.add((drawnCard));

    }

    public void DiscardInfectionCard()
    {

    }

    public void DrawPlayerCard()
    {

    }

    public void DiscardPlayerCard()
    {

    }

}
