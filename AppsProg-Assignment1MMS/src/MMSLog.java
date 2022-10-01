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
        while (true)
        {
            char choice = Utils.choice(
                    "Session Admin: " + superMarket.getName() + " - Menu Commands (F/V/A/R/S/X)");
            if (choice == 'F')
            {
                String n = Utils.string("Name");
                Membership m = superMarket.getMemberships().getMembership(n);
                if (m == null)
                {
                    System.out.println("Slip details does not exist for " + n + "!");
                }
                else
                {
                    MMSlip s = new MMSlip(m);
                    s.printSlip();

                }
            }
            else if (choice == 'V')
            {
                MMS tempMMS = new MMS(superMarket, superMarket.getMemberships());
                tempMMS.printMMS();
            }
            else if (choice == 'A')
            {
                MMS newMMS = new MMS(superMarket, superMarket.getMemberships());
                for (MMS m : mmsLog)
                {
                    if (newMMS.matchMMS(m))
                    {
                        m.setName(newMMS.getName());
                    }
                }
                mmsLog.add(newMMS);
                System.out.println("MMS record is created as:" + newMMS.getName());
            }
            else if (choice == 'R')
            {
                String record = Utils.string("RecordID");
                boolean found = false;
                for (MMS entry : mmsLog)
                {
                    if (entry.getName().equals(record))
                    {
                        found = true;
                        entry.printMMS();
                        break;
                    }
                }
                if (!found)
                {
                    System.out.println("No MMS is recorded as: " + record);
                }
            }
            else if (choice == 'S')
            {
                this.printLog();
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

    public void printLog()
    {
        Utils.logHeader();
        for (int i = 0; i < mmsLog.size(); i++)
        {
            System.out.format(Utils.logFormat, ("MMS " + (i + 1)), mmsLog.get(i).getName());
        }
        Utils.LogTableEnd();
    }

    public void mmsHelp()
    {
        System.out.println("MMS Menu: ");
        System.out.println("F- Find Slip Details");
        System.out.println("V- View MMS Report");
        System.out.println("A- Archive MMS Report");
        System.out.println("R- Retrieve MMS Report");
        System.out.println("S- Show MMS Log");
        System.out.println("X- Close");
    }

}
