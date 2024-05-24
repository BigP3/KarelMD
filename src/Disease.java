public class Disease extends Symptoms
{
    private int fit;
    private String diseaseName;
    private double temp;
    private int age;
    private int gender;//1 = male; 2 = female; 3 = equal

    public Disease(int fit,
                   int age,
                   int gender,
                   String diseaseName, 
                   double temp,
                   boolean cough,
                   boolean soreThroat,
                   boolean runnyNose,
                   boolean chills)
    {
        super(age, gender, cough, soreThroat, runnyNose, chills);
        this.fit = fit;
        this.diseaseName = diseaseName;
        this.temp = temp;
    }

    public int getFit()
    {
        return fit;
    }

    public String getDiseaseName()
    {
        return diseaseName;
    }
    
    public double getTemp()
    {
        return temp;
    }
}
