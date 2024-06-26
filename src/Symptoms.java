public class Symptoms
{
    private int age;
    private int gender;//1 = male; 2 = female; -1 = equal
    private boolean[] symptoms;

    public Symptoms(int age,
                    int gender,
                    boolean cough,
                    boolean soreThroat,
                    boolean runnyNose,
                    boolean chills,
                    boolean lossOfTaste,
                    boolean headache,
                    boolean bodyAche,
                    boolean stomachache,
                    boolean skinRashes,
                    boolean jointPain,
                    boolean visionProblem)
    {
        this.age = age;
        this.gender = gender;
        this.symptoms = new boolean[] {cough, soreThroat, runnyNose, chills, lossOfTaste, headache, bodyAche, stomachache, skinRashes, jointPain, visionProblem};
    }

    public int getAge()
    {
        return age;
    }

    public int getGender()
    {
        return gender;
    }

    public boolean[] getSymptoms()
    {
        return symptoms;
    }
}
