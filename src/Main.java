
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        String name;
        int age;
        int gender;
        boolean cough;
        double temp;
        boolean soreThroat;
        boolean runnyNose;
        boolean chills;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        name = sc.nextLine();
        System.out.println("What is your age?");
        age = sc.nextInt();
        System.out.println();
        System.out.println("What is your gender?");
        gender = testGender();
        System.out.println("Do you cough?");
        cough = sc.nextBoolean();
        System.out.println();
        System.out.println("What is your body temperature?");
        temp = sc.nextDouble();
        System.out.println();
        System.out.println("Do you have a sore throat?");
        soreThroat = sc.nextBoolean();
        System.out.println();
        System.out.println("Do you have a runny nose?");
        runnyNose = sc.nextBoolean();
        System.out.println();
        System.out.println("Do you have body chills?");
        chills = sc.nextBoolean();
        System.out.println();

        Patient pat = new Patient(name, age, gender, cough, temp, soreThroat, runnyNose, chills);

        //cleDiagnosisEngine results = new DiagnosisEngine(pat);
    }

    public static int testGender()
    {
        Scanner sc = new Scanner(System.in);
        String genderName = sc.nextLine();
        System.out.println();

        if (genderName.equals("Male") ||
            genderName.equals("male") ||
            genderName.equals("Boy") ||
            genderName.equals("boy") ||
            genderName.equals("Man") ||
            genderName.equals("man"))
        {
            return 1;
        }
        else if (genderName.equals("Female") ||
                 genderName.equals("female") ||
                 genderName.equals("Girl") ||
                 genderName.equals("girl") ||
                 genderName.equals("Woman") ||
                 genderName.equals("woman"))
        {
            return 2;
        }
        else
        {
            System.out.println("For purely medical purposes, please enter your biological gender/sex:");
            return testGender();
        }
    }
}