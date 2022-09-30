public class SuperMarket
{

    private String name;
    private String email;
    private String password;
    private Memberships memberships;
    private MMSLog mmsLog;

    public SuperMarket(String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.memberships = new Memberships();
        this.mmsLog = new MMSLog();
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPass()
    {
        return this.password;
    }

    public Memberships getMemberships()
    {
        return this.memberships;
    }

    public MMSLog getMmsLog()
    {
        return this.mmsLog;
    }


}
