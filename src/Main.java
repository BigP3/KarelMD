import java.util.*;
import javax.lang.model.util.ElementScanner14;

public class Main
{
    private static int thinkingCount;
    private static boolean doneThinking;
    private static boolean developerMode;
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
        developerMode = false;

        System.out.println("Hello, I am Karel M.D. What is your name?");
        name = sc.nextLine();
        System.out.println();
        if (name.equals("developerMode = true"))
        {
            developerMode = true;
            System.out.println("Developer mode has been enabled. Please re-enter desired value:");
            name = sc.nextLine();
            System.out.println();
        }
        else if (name.toLowerCase().equals("skibidi"))
        {
            System.out.println("You have been diagnosed with brain rot. Ur not the sigma. Please go see doctor I cannot help you.\n");
            System.exit(10);
        }

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
            while (doneThinking = false)
            {

            }
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

                        //Developer mode
                        if (developerMode)
                        {
                            System.out.println ("- This segment is for developer mode -");
                            for (Disease d : results.getDiseaseDatabase())
                            {
                                System.out.println(d.getDiseaseName() + ", " + d.getFit());
                            }
                            System.out.println("- End of developer mode -\n");
                        }
                        //End of developer mode

                        ArrayList<Disease> diagnosis = Patient.getDisease();
                        ArrayList<Disease> plausibleDiagnosis = new ArrayList<Disease>();

                        for (int i = 0; i < diagnosis.size(); i++)
                        {
                            if (diagnosis.get(i).getFit() < results.getBestFit())
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
                                if (developerMode)
                                {
                                    System.out.println(d.getDiseaseName() + ", Fit Value: " + d.getFit());
                                }
                                else
                                {
                                    System.out.println(d.getDiseaseName());
                                }
                            }
                            System.out.println();

                            if (plausibleDiagnosis.size() > 0)
                            {
                                System.out.println("You might also have:");
                                for (Disease d : plausibleDiagnosis)
                                {
                                    if (developerMode)
                                    {
                                        System.out.println(d.getDiseaseName() + ", Fit Value: " + d.getFit());
                                    }
                                    else
                                    {
                                        System.out.println(d.getDiseaseName());
                                    }
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
        String[] maleVariation = {"male", "man", "men", "boy"};
        String[] femaleVariation = {"female", "woman", "women", "girl"};
        
        Scanner sc = new Scanner(System.in);
        String genderName = sc.nextLine();
        System.out.println();

        for (String male : maleVariation)
        {
            if (doesItContain(genderName.toLowerCase(), male))
            {
                return 1;
            }
        }
        for (String female : femaleVariation)
        {
            if (doesItContain(genderName.toLowerCase(), female))
            {
                return 2;
            }
        }

        if (doesItContain(genderName.toLowerCase(), "skibidi"))
        {
            System.out.println("You have been diagnosed with brain rot. Ur not the sigma. Please go see doctor I cannot help you.\n");
            System.exit(10);
            return Integer.MAX_VALUE;
        }
        else if (genderName.equals("developerMode = true"))
        {
            developerMode = true;
            System.out.println("Developer mode has been enabled. Please re-enter desired value:");
            return testGender();
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
            if (doesItContain(answer.toLowerCase(), yes))
            {
                return true;
            }
        }
        for (String no : noVariation)
        {
            if (doesItContain(answer.toLowerCase(), no))
            {
                return false;
            }
        }

        if (doesItContain(answer.toLowerCase(), "skibidi"))
        {
            System.out.println("You have been diagnosed with brain rot. Ur not the sigma. Please go see doctor I cannot help you.\n");
            System.exit(10);
        }
        else if (answer.equals("developerMode = true"))
        {
            developerMode = true;
            System.out.println("Developer mode has been enabled. Please re-enter desired value:");
            return booleanConverter();
        }

        System.out.println("For syntactical purposes, please enter a valid affirmative response:");
        return booleanConverter();
    }

    public static boolean goodOrBad()
    {
        String[] goodVariation = {"well", "good", "awsome", "wonderful", "great", "terrific", "okay", "ok", "excellent", "amazing", "happy"};
        
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println();

        for (String good : goodVariation)
        {
            if (doesItContain(answer.toLowerCase(), good))
            {
                return true;
            }
        }

        if (doesItContain(answer.toLowerCase(), "skibidi"))
        {
            System.out.println("You have been diagnosed with brain rot. Ur not the sigma. Please go see doctor I cannot help you.\n");
            System.exit(10);
        }
        else if (answer.equals("developerMode = true"))
        {
            developerMode = true;
            System.out.println("Developer mode has been enabled. Please re-enter desired value:");
            return goodOrBad();
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

    public static boolean doesItContain(String inputString, String findString)
    {
        String input = inputString.toLowerCase();
        String find = findString.toLowerCase();
        int position = input.indexOf(find);
        
        if (position == -1)
        {
            return false;
        }
        else if (position == 0)
        {
            if (position + find.length() <= input.length() - 1)
            {
                String after = input.substring(position + find.length());
                if ((after.compareTo("a") > 0 && after.compareTo("z") < 0))
                {
                    return doesItContain(input.substring(position + find.length()), find);
                }
                else
                {
                    return true;
                }
            }
            else
            {
                return true;
            }
        }
        else
        {
            if (position + find.length() <= input.length() - 1)
            {
                String before = input.substring(position - 1, position);
                String after = input.substring(position + find.length());
                if ((before.compareTo("a") > 0 && before.compareTo("z") < 0) || (after.compareTo("a") > 0 && after.compareTo("z") < 0))
                {
                    return doesItContain(input.substring(0, position) + input.substring(position + find.length()), find);
                }
                else
                {
                    return true;
                }
            }
            else
            {
                String before = input.substring(position - 1, position);
                if ((before.compareTo("a") > 0 && before.compareTo("z") < 0))
                {
                    return doesItContain(input.substring(0, position), find);
                }
                else
                {
                    return true;
                }
            }
        }
    }
}