import java.util.ArrayList;

public class MMSLog
{
    private ArrayList<MMS> mmsLog;

    public MMSLog()
    {
        mmsLog = new ArrayList<MMS>();
    }

    public void run(SuperMarket superMarket)
    {
        mmsHelp();
        while(true)
        {
            char choice = Utils.choice(
                    "Session Admin: " + superMarket.getName() + " - Menu Commands (F/V/A/R/S/X): ");
            if (choice == 'F')
            {
                String n = Utils.string("Name: ");
                Membership m = superMarket.getMemberships().getMembership(n);
                if (m.equals(null))
                {
                    System.out.println(n + " record does not exist!");
                }
                else
                {

                }
            }
            else if (choice == 'V')
            {

            }
            else if (choice == 'A')
            {

            }
            else if (choice == 'R')
            {

            }
            else if (choice == 'S')
            {

            }
            else if (choice == 'X')
            {
                System.out.println("\nSuperMarket Menu:");
                break;
            }
            else
            {
                mmsHelp();
            }
        }
    }

    public void addLog(MMS entry)
    {
        mmsLog.add(entry);
    }

    public void mmsHelp()
    {
        System.out.println("MMS Menu:");
        System.out.println("F- Find Slip Details");
        System.out.println("V- View MMS Report");
        System.out.println("A- Archive MMS Report");
        System.out.println("R- Retrieve MMS Report");
        System.out.println("S- Show MMS Log");
        System.out.println("X- Close");
    }

}
