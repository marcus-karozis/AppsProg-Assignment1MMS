public class Session
{
    private SuperMarkets superMarkets;

    public static void main(String[] args)
    {
        Session run = new Session();
    }

    public Session()
    {
        superMarkets = new SuperMarkets();
        run();
    }

    public void login()
    {
        while (true)
        {
            char input = Utils.choice("Command (L/X): ");
            if (input == 'L')
            {
                superMarkets.auth();
            }
            else if (input == 'X')
            {
                System.out.print("\nSession Terminated!");
                System.exit(0);
            }
            else
            {
                System.out.print(help());
            }
        }
    }

    public String help()
    {
        return "Membership Management System:\nL- Login\nX- Exit";
    }

    public void run()
    {
        while (true)
        {   
            login();
        }
    }

}
