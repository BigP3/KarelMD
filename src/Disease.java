public class Disease extends Symptoms
{
    private int fit;
    private String diseaseName;
    private double minTemp;
    private double maxTemp;

    public Disease(int fit,
                   int age,
                   int gender,
                   String diseaseName, 
                   double minTemp,
                   double maxTemp,
                   boolean cough,
                   boolean soreThroat,
                   boolean runnyNose,
                   boolean chills,
                   boolean lossOfTaste,
                   boolean headache,
                   boolean bodyAche,
                   boolean stomacheAche,
                   boolean skinRashes,
                   boolean jointPain,
                   boolean visionProblem)
    {
        super(age, gender, cough, soreThroat, runnyNose, chills, lossOfTaste, headache, bodyAche, stomacheAche, skinRashes, jointPain, visionProblem);
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.fit = fit;
        this.diseaseName = diseaseName;
    }

    public int getFit()
    {
        return fit;
    }

    public void setFit(int fit)
    {
        this.fit = fit;
    }

    public void fitPlusPlus()
    {
        this.fit++;
    }

    public String getDiseaseName()
    {
        return diseaseName;
    }
    
    public double getMinTemp()
    {
        return minTemp;
    }

    public double getMaxTemp()
    {
        return maxTemp;
    }
}
