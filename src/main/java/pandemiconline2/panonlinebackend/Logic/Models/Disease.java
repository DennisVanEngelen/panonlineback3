package pandemiconline2.panonlinebackend.Logic.Models;

public class Disease
{
    GameColor diseaseColor;
    int numberOfPathogens;
    boolean isCured = false;

    public Disease(GameColor diseaseColor, int numberOfPathogens, boolean isCured)
    {
        this.diseaseColor = diseaseColor;
        this.numberOfPathogens = numberOfPathogens;
    }
    public void Cure(){
        isCured = true;
    }
}
