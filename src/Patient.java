
import java.util.ArrayList;

public class Patient extends Symptoms
{
    private String name;
    //private int age;
    //private int gender;
    private static ArrayList<Disease> d;
    private double temp;
    //private boolean[] symptoms;

    public Patient(String name, int age, int gender, boolean cough, double temp, 
                    boolean soreThroat, boolean runnyNose, boolean chills) {
        super(age, gender, cough, soreThroat, runnyNose, chills);
        this.name = name;
        this.temp = temp;
        d = new ArrayList<Disease>();
    }

    public String getName() {
        return name;
    }
    public void setName(String n) {
        name = n;
    }
    public static void addDisease(Disease s) {
        d.add(s);
    }

    public static ArrayList<Disease> getDisease() {
        return d;
    }

    public void setTemp(double t) {
        temp =t;

    }
    public double getTemp() {
        return temp;
    }
    
}
