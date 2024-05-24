
import java.util.ArrayList;

public class Patient extends Symptoms
{
    private String name;
    //private int age;
    //private int gender;
    private ArrayList<Disease> d;
    //private boolean[] symptoms;

    public Patient(String name, int age, int gender, boolean cough,
                    boolean soreThroat, boolean runnyNose, boolean chills) {
        super(age, gender, cough, soreThroat, runnyNose, chills);
        this.name = name;
        d = new ArrayList<Disease>();
    }

    public String getName() {
        return name;
    }
    public void setName(String n) {
        name = n;
    }
    public void addDisease(Disease s) {
        d.add(s);
    }
    
    
}
