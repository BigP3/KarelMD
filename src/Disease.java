public class Disease extends Symptoms
{
    private int fit;
    private String diseaseName;
    private double temp;
    private int age;
    private int gender;//1 = male; 2 = female; 3 = equal

    public Disease(int fit,
                   String diseaseName, 
                   double temp,
                   boolean cough,
                   boolean soreThroat,
                   boolean runnyNose,
                   boolean chills,
                   int age,
                   int gender)
    {
        super(cough, soreThroat, runnyNose, chills);
        this.fit = fit;
        this.diseaseName = diseaseName;
        this.temp = temp;
        this.age = age;
        this.gender = gender;
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

    public int getAge()
    {
        return age;
    }

    public int isGender()
    {
        return gender;
    }
}
