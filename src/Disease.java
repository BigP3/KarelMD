public class Disease
{
    private int fit;
    private String diseaseName;
    private double temp;
    private boolean[] symptoms;
    private int age;
    private boolean gender;//true = male; false = female

    public Disease(int fit,
                   String diseaseName, 
                   double temp,
                   boolean cough,
                   boolean soreThroat,
                   boolean runnyNose,
                   boolean chills,
                   int age,
                   boolean gender)
    {
        this.fit = fit;
        this.diseaseName = diseaseName;
        this.temp = temp;
        this.symptoms = new boolean[] {cough, soreThroat, runnyNose, chills};
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

    public boolean[] getSymptoms()
    {
        return symptoms;
    }
    
    public int getAge()
    {
        return age;
    }

    public boolean isGender()
    {
        return gender;
    }
}
