public class Symptoms
{
    private boolean[] symptoms;

    public Symptoms(boolean cough,
                    boolean soreThroat,
                    boolean runnyNose,
                    boolean chills)
    {
        this.symptoms = new boolean[] {cough, soreThroat, runnyNose, chills};
    }

    public boolean[] getSymptoms()
    {
        return symptoms;
    }
}
