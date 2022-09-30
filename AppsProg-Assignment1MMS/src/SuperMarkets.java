
import java.util.ArrayList;

public class SuperMarkets
{

    private ArrayList<SuperMarket> superMarkets;
    private SuperMarket user;

    public SuperMarkets()
    {
        superMarkets = new ArrayList<SuperMarket>();
        superMarkets.add(new SuperMarket("John Smith", "john.smith@uts.com", "user222"));
        superMarkets.add(new SuperMarket("Jane Tyler", "jane.tyler@uts.com", "super123"));
    }

    public void auth()
    {

        String em = Utils.string("Email: ");
        String pass = Utils.string("Password: ");
        boolean found = false;
        for (SuperMarket sm : superMarkets)
        {
            if (sm.getEmail().equals(em))
            {
                if (sm.getPass().equals(pass))
                {
                    found = true;
                    this.user = sm;
                    run();
                }
            }
        }
        if (!found)
        {
            System.out.println("Invalid Login!");
        }
    }

    public void run()
    {
        adminHelp();
        while (true)
        {
            char choice = Utils.choice(
                    "Session Admin: " + this.user.getName() + " - Menu Commands (C/R/U/D/V/M/X): ");
            if (choice == 'C')
            {
                this.user.getMemberships().createMembership();
            }
            else if ((choice == 'R') || (choice == 'U') || (choice == 'D'))
            {
                String n = Utils.string("Name: ");
                Membership m = this.user.getMemberships().getMembership(n);
                if (m.equals(null))
                {
                    System.out.println(n + " record does not exist!");
                }
                else
                {
                    if (choice == 'R')
                    {
                        m.printMembership();
                    }
                    else if (choice == 'U')
                    {
                        this.user.getMemberships().updateMembership(m);
                    }
                    else if (choice == 'D')
                    {
                        this.user.getMemberships().deleteMembership(m);
                    }
                    
                }
                
            }
            else if (choice == 'V')
            {
                this.user.getMemberships().printMemberships();
            }
            else if (choice == 'M')
            {
                this.user.getMmsLog().run(this.user);
            }
            else if (choice == 'X')
            {
                break;
            }
            else
            {
                adminHelp();
            }
        }
    }
    
    public void adminHelp()
    {
        System.out.println("Admin Menu:");
        System.out.println("C- Add Membership");
        System.out.println("R- View Membership");
        System.out.println("U- Update Membership");
        System.out.println("D- Delete Membership");
        System.out.println("V- View Memberships");
        System.out.println("M- MMS Menu");
        System.out.println("X- Logout");
    }

}

