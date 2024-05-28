public class DiagnosisEngine
{
    private Disease[] diseaseDatabase;
    private Patient pat;
    private int bestFit;
    public DiagnosisEngine(Patient pat){
        Disease flu = new Disease(0, -1, -1, "Influenza", 38.0, 44.0, true, true, true, true);
        Disease cold = new Disease(0, -1, -1, "Common Cold", 36.0, 38.0, true, true, true, true);
        this.pat = pat;
        diseaseDatabase = new Disease[2];
        diseaseDatabase[0] = flu;
        diseaseDatabase[1] = cold;
        bestFit = 0;
    }
    
    public int getBestFit(){
        return bestFit;
    }

    public void differentialDiagnosis(){

        for (Disease disease : diseaseDatabase){
            // compare ages
            if (pat.getAge() == disease.getAge() || disease.getAge() == -1){
                disease.fitPlusPlus();
            }
            // compare genders
            if (pat.getGender() == disease.getGender() || disease.getGender() == -1){
                disease.fitPlusPlus();
            }
            // checks whether the patient's temperature is within the range
            if (pat.getTemp() >= disease.getMinTemp() && pat.getTemp() <= disease.getMaxTemp()){
                disease.fitPlusPlus();
            }
            for (int i = 0; i < disease.getSymptoms().length; i++){
                if (pat.getSymptoms()[i] == disease.getSymptoms()[i]) {
                    disease.fitPlusPlus();
                }
            }
            if (disease.getFit() > bestFit){
                bestFit = disease.getFit();
            }
        }
        for (Disease disease : diseaseDatabase){
            if (disease.getFit() >= bestFit-1 && disease.getFit() > 0){
                pat.addDisease(disease);
            }
        }
    }
}
