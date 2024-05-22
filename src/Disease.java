public class Disease
{
    private String diseaseName;
    private boolean fever;
    private double temp;
    private boolean fatigue;
    private boolean cough;
    private boolean shortnessOfBreath;
    private boolean soreThroat;
    private boolean runnyNose;
    private boolean lossOfTasteOrSmell;
    private boolean headache;
    private boolean bodyAche;
    private boolean chills;
    private boolean gastrointestinalSymptoms;
    private boolean closeContact;
    private boolean travelHistory;
    private boolean skinRashes;
    private boolean jointPain;
    private boolean visionProblems;
    private boolean swollenLymphNodes;
    private int age;
    private boolean gender;//true = male; false = female

    public Disease(String diseaseName, 
                   boolean fever,
                   double temp,
                   boolean fatigue,
                   boolean cough,
                   boolean shortnessOfBreath,
                   boolean soreThroat,
                   boolean runnyNose,
                   boolean lossOfTasteOrSmell,
                   boolean headache,
                   boolean bodyAche,
                   boolean chills,
                   boolean gastrointestinalSymptoms,
                   boolean closeContact,
                   boolean travelHistory,
                   boolean skinRashes,
                   boolean jointPain,
                   boolean visionProblems,
                   boolean swollenLymphNodes,
                   int age,
                   boolean gender)
    {
        this.diseaseName = diseaseName;
        this.fever = fever;
        this.temp = temp;
        this.fatigue = fatigue;
        this.cough = cough;
        this.shortnessOfBreath = shortnessOfBreath;
        this.soreThroat = soreThroat;
        this.runnyNose = runnyNose;
        this.lossOfTasteOrSmell = lossOfTasteOrSmell;
        this.headache = headache;
        this.bodyAche = bodyAche;
        this.chills = chills;
        this.gastrointestinalSymptoms = gastrointestinalSymptoms;
        this.closeContact = closeContact;
        this.travelHistory = travelHistory;
        this.skinRashes = skinRashes;
        this.jointPain = jointPain;
        this.visionProblems = visionProblems;
        this.swollenLymphNodes = swollenLymphNodes;
        this.age = age;
        this.gender = gender;
    }
    
}
