public class DiagnosisEngine
{
    private Disease[] diseaseDatabase;
    private Patient pat;
    private int bestFit;
   
    public DiagnosisEngine(Patient pat){
        Disease flu = new Disease(0, -1, -1, "Influenza", 38.0, 44.0, true, true, true, true, false, true, true, true, false, true, false);
        Disease cold = new Disease(0, -1, -1, "Common Cold", 35.0, 38.0, true, true, true, true, false, true, true, false, false, false, false);
        Disease covid19 = new Disease(0, -1, -1, "COVID-19", 38.0, 44.0, true, true, true, true, true, true, true, true, false, false, false);
        Disease lupus = new Disease(0, -1, 1, "Lupus", 38.0, 44.0, false, false, false, true, false, true, true, false, true, true, true);
        Disease pneumonia = new Disease(0, -1, -1, "Pneumonia", 38.0, 44.0, true, false, false, true, false, true, true, true, false, false, false);
        Disease bronchitis = new Disease(0, -1, -1, "Bronchitis", 35.0, 38.0, true, true, false, false, false, false, true, false, false, false, false);
        Disease strepThroat= new Disease(0, 2, -1, "Strep Throat", 38.3, 44.0, false, true, false, true, false, true, true, true, false, false, false);
        this.pat = pat;
        diseaseDatabase = new Disease[7];
        diseaseDatabase[0] = flu;
        diseaseDatabase[1] = cold;
        diseaseDatabase[2] = covid19;
        diseaseDatabase[3] = lupus;
        diseaseDatabase[4] = pneumonia;
        diseaseDatabase[5] = bronchitis;
        diseaseDatabase[6] = strepThroat;
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
                Patient.addDisease(disease);
            }
        }
    }
}
