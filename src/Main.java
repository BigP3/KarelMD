import java.util.*;

public class Main
{
    private static int thinkingCount = 0;
    private static Patient pat;

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
        boolean goodOrBad;
        
        Scanner sc = new Scanner(System.in);
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
                System.out.println("I see. So, you're either a hypochondriac or a masochist who enjoys wasting my time. Goodbye.");
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

        System.out.println("What is your age?");
        age = sc.nextInt();
        System.out.println();
        System.out.println("What is your gender?");
        gender = testGender();
        System.out.println("Do you cough?");
        cough = booleanConverter();
        System.out.println("What is your body temperature?");
        temp = sc.nextDouble();
        System.out.println();
        System.out.println("Do you have a sore throat?");
        soreThroat = booleanConverter();
        System.out.println("Do you have a runny nose?");
        runnyNose = booleanConverter();
        System.out.println("Do you have body chills?");
        chills = booleanConverter();
        System.out.println();
        System.out.println("Well, I think I've reached my quota for stupid questions today. Time to put my genius brain to work and solve this puzzle.\n");
        pat = new Patient(name, age, gender, cough, temp, soreThroat, runnyNose, chills);

        Timer timer = new Timer();
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
                    ArrayList<Disease> diagnosis = results.differentialDiagnosis();
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
                            System.out.println(d.getDiseaseName());
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
                }
            };
            timer2.schedule(task2, 2000);
            timer2.schedule(task3, 4000);

            TimerTask task4 = new TimerTask()
            {
                public void run()
                {
                    timer2.cancel();
                }
            };
            timer2.schedule(task4, 4001);
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
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println();

        if (answer.toLowerCase().equals("yes") ||
            answer.toLowerCase().equals("affirmative") ||
            answer.toLowerCase().equals("y") ||
            answer.toLowerCase().equals("true") ||
            answer.toLowerCase().equals("yep") ||
            answer.toLowerCase().equals("yeah") ||
            answer.toLowerCase().equals("yea") ||
            answer.toLowerCase().equals("definetely") ||
            answer.toLowerCase().equals("hell yeah") ||
            answer.toLowerCase().equals("yessir") ||
            answer.toLowerCase().equals("indeed") ||
            answer.toLowerCase().equals("positive") ||
            answer.toLowerCase().equals("sometimes"))
        {
            return true;
        }
        else if (answer.toLowerCase().equals("no") ||
                 answer.toLowerCase().equals("untrue") ||
                 answer.toLowerCase().equals("n") ||
                 answer.toLowerCase().equals("false") ||
                 answer.toLowerCase().equals("nope") ||
                 answer.toLowerCase().equals("nah") ||
                 answer.toLowerCase().equals("not at all") ||
                 answer.toLowerCase().equals("hell nah") ||
                 answer.toLowerCase().equals("no sir") ||
                 answer.toLowerCase().equals("absolutely not") ||
                 answer.toLowerCase().equals("negative") ||
                 answer.toLowerCase().equals("rarely"))
        {
            return false;
        }
        else
        {
            System.out.println("For syntactical purposes, please enter a valid affirmative response:");
            return booleanConverter();
        }
    }

    public static boolean goodOrBad()
    {
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println();

        if (answer.toLowerCase().equals("well") ||
            answer.toLowerCase().equals("good") ||
            answer.toLowerCase().equals("awsome") ||
            answer.toLowerCase().equals("wonderful") ||
            answer.toLowerCase().equals("great") ||
            answer.toLowerCase().equals("terrific") ||
            answer.toLowerCase().equals("okay") ||
            answer.toLowerCase().equals("ok") ||
            answer.toLowerCase().equals("excellent") ||
            answer.toLowerCase().equals("amazing") ||
            answer.toLowerCase().equals("happy"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}