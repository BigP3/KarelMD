import java.util.*;

public class Main
{
    private static int thinkingCount;
    private static boolean doneThinking;
    private static Patient pat;

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String name;
        int ageValue;
        int age = -1;
        int gender;
        boolean cough;
        double temp;
        boolean soreThroat;
        boolean runnyNose;
        boolean chills;
        boolean lossOfTaste;
        boolean headache;
        boolean bodyAche;
        boolean stomachache;
        boolean skinRashes;
        boolean jointPain;
        boolean visionProblem;
        boolean goodOrBad;
        boolean wastingTime = false;

        System.out.println("Hello, I am Karel M.D. What is your name?");
        name = sc.nextLine();
        System.out.println();

        System.out.println("How are you feeling today, " + name + "?");
        goodOrBad = goodOrBad();
        if (goodOrBad)
        {
            System.out.println("That's wonderful. Would you still like to take the diagnosis?");
            if (!booleanConverter())
            {
                System.out.println("I see. So, you're either a hypochondriac or a masochist who enjoys wasting my time. Goodbye.\n");
                wastingTime = true;
            }
            else
            {
                System.out.println("Right, because perfectly healthy people always come to see a doctor. Don't worry I'm sure we'll find something wrong with you.");
            }
        }
        else
        {
            System.out.println("You're feeling bad? Congratulations, you've just described 99% of my patients. Now, let's figure out what makes you special.");   
        }

        if (!wastingTime)
        {
            System.out.println("What is your age?");
            ageValue = tryAndCatchWholeNumberInt();
            if (0 <= ageValue && ageValue <= 5)
            {
                age = 1;
            }
            else if (6 <= ageValue && ageValue <= 26)
            {
                age = 2;
            }
            else if (27 <= ageValue && ageValue <= 39)
            {
                age = 3;
            }
            else if (40 <= ageValue && ageValue <= 59)
            {
                age = 4;
            }
            else if (60 <= ageValue)
            {
                age = 5;
            }

            System.out.println("What is your gender?");
            gender = testGender();

            System.out.println("What is your body temperature in Celsius?");
            temp = tryAndCatchDouble();

            System.out.println("Do you cough?");
            cough = booleanConverter();

            System.out.println("Do you have a sore throat?");
            soreThroat = booleanConverter();

            System.out.println("Do you have a runny nose?");
            runnyNose = booleanConverter();

            System.out.println("Do you have body chills?");
            chills = booleanConverter();

            System.out.println("Do you have any loss of taste or smell?");
            lossOfTaste = booleanConverter();

            System.out.println("Do you have headaches?");
            headache = booleanConverter();

            System.out.println("Do you have body aches?");
            bodyAche = booleanConverter();

            System.out.println("Do you have stomachaches?");
            stomachache = booleanConverter();

            System.out.println("Do you have skin rashes?");
            skinRashes = booleanConverter();

            System.out.println("Do you have joint pain?");
            jointPain = booleanConverter();

            System.out.println("Do you have vision problems?");
            visionProblem = booleanConverter();

            System.out.println("Well, I think I've reached my quota for stupid questions today. Time to put my genius brain to work and solve this puzzle.\n");
            pat = new Patient(name, age, gender, cough, temp, soreThroat, runnyNose, chills, lossOfTaste, headache, bodyAche, stomachache, skinRashes, jointPain, visionProblem);

            Timer timer = new Timer();
            thinkingCount = 0;
            doneThinking = false;
            TimerTask task = new TimerTask()
            {
                public void run()
                {
                    System.out.println("Thinking...\n");
                    thinkingCount++;
                }
            };
            timer.scheduleAtFixedRate(task, 2000, 2000);

            while (thinkingCount < 3)
            {
                Thread.sleep(100);
            }

            if (thinkingCount == 3)
            {
                timer.cancel();

                Timer timer2 = new Timer();
                TimerTask task2 = new TimerTask()
                {
                    public void run()
                    {
                        System.out.println("\n\n\nHere you go, " + pat.getName() + ". Here are the results:\n");
                    }
                };

                TimerTask task3 = new TimerTask()
                {
                    public void run()
                    {
                        DiagnosisEngine results = new DiagnosisEngine(pat);
                        results.differentialDiagnosis();
                        ArrayList<Disease> diagnosis = Patient.getDisease();
                        ArrayList<Disease> plausibleDiagnosis = new ArrayList<Disease>();

                        for (int i = 0; i < diagnosis.size(); i++)
                        {
                            if (diagnosis.get(i).getFit() <= 3)
                            {
                                diagnosis.remove(i);
                                i--;
                            }
                            else if (diagnosis.get(i).getFit() > 3 && diagnosis.get(i).getFit() == results.getBestFit() - 1)
                            {
                                plausibleDiagnosis.add(diagnosis.get(i));
                                diagnosis.remove(i);
                                i--;
                            }
                        }

                        if (diagnosis.size() > 0)
                        {
                            System.out.println("You have been diagnosed with:");
                            for (Disease d : diagnosis)
                            {
                                System.out.println(d.getDiseaseName() + ", Fit Value: " + d.getFit());
                            }
                            System.out.println();

                            if (plausibleDiagnosis.size() > 0)
                            {
                                System.out.println("You might also have:");
                                for (Disease d : plausibleDiagnosis)
                                {
                                    System.out.println(d.getDiseaseName() + ", Fit Value: " + d.getFit());
                                }
                                System.out.println();
                            }

                            System.out.println("I hate to admit it, but there's a slim chance I could be wrong. I know, shocking. You better go find a real doctor to confirm it, just in case.\nBye bye.\n");
                        }
                        else
                        {
                            System.out.println("I've got no clue what's wrong with you. I guess you're just a medical mystery. Enjoy your new title.\n(If you're still concerned, go find a real doctor, just in case.)\nBye bye.\n");
                        }

                        doneThinking = true;
                    }
                };
                timer2.schedule(task2, 2000);
                timer2.schedule(task3, 4000);

                while (!doneThinking)
                {
                    Thread.sleep(100);
                }

                if (doneThinking)
                {
                    timer2.cancel();
                }
            }
        }
    }

    public static int testGender()
    {
        Scanner sc = new Scanner(System.in);
        String genderName = sc.nextLine();
        System.out.println();

        if (genderName.toLowerCase().equals("male") ||
            genderName.toLowerCase().equals("man") ||
            genderName.toLowerCase().equals("men") ||
            genderName.toLowerCase().equals("boy"))
        {
            return 1;
        }
        else if (genderName.toLowerCase().equals("female") ||
                 genderName.toLowerCase().equals("woman") ||
                 genderName.toLowerCase().equals("women") ||
                 genderName.toLowerCase().equals("girl"))
        {
            return 2;
        }
        else
        {
            System.out.println("For purely medical purposes, please enter your biological gender/sex:");
            return testGender();
        }
    }

    public static boolean booleanConverter()
    {
        String[] yesVariation = {"yes", "affirmative", "y", "true", "yep", "yeah", "yea", "definetely", "hell yeah", "yessir", "indeed", "positive", "sure", "sometimes", "maybe", "probably"};
        String[] noVariation = {"no", "untrue", "n", "false", "nope", "nah", "not at all", "hell nah", "no sir", "absolutely not", "negative", "not sure", "rarely", "nah sir", "hell no"};
    
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println();

        for (String yes : yesVariation)
        {
            if (answer.toLowerCase().equals(yes))
            {
                return true;
            }
        }
        for (String no : noVariation)
        {
            if (answer.toLowerCase().equals((no)))
            {
                return false;
            }
        }

        System.out.println("For syntactical purposes, please enter a valid affirmative response:");
        return booleanConverter();
    }

    public static boolean goodOrBad()
    {
        String[] goodVariation = {"well", "good", "awsome", "wonderful", "great", "terrific", "okay", "ok", "excellent", "amazing", "skibidi", "happy"};
        
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println();

        for (String good : goodVariation)
        {
            if (answer.toLowerCase().equals(good))
            {
                return true;
            }
        }

        return false;
    }

    public static int tryAndCatchInt()
    {
        Scanner sc = new Scanner(System.in);
        int value = -1;
        try
        {
            value = sc.nextInt();
            System.out.println();
            return value;
        }
        catch (Exception e)
        {
            System.out.println("\nFor syntactical purposes, please enter a whole number age:");
            return tryAndCatchInt();
        }
    }

    public static int tryAndCatchWholeNumberInt()
    {
        Scanner sc = new Scanner(System.in);
        int value = -1;
        try
        {
            value = sc.nextInt();
            System.out.println();
            if (value < 0)
            {
                System.out.println("Please enter a positive whole number age:");
                return tryAndCatchWholeNumberInt();
            }
            return value;
        }
        catch (Exception e)
        {
            System.out.println("\nFor syntactical purposes, please enter a whole number age:");
            return tryAndCatchWholeNumberInt();
        }
    }

    public static double tryAndCatchDouble()
    {
        Scanner sc = new Scanner(System.in);
        double value = -1;
        try
        {
            value = sc.nextDouble();
            System.out.println();
            return value;
        }
        catch (Exception e)
        {
            System.out.println("\nFor syntactical purposes, please enter a whole/decimal number in Celsius:");
            return tryAndCatchDouble();
        }
    }
}