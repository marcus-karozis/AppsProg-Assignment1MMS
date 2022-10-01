public class Membership
{
    private String ID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String type;
    private double expense;
    private int payPerCredit;
    private double totalCredits;
    private double GasdeductionRate;
    private int DollarAvailable;

    private double deductionRate;
    // private SuperMarket SuperMarket;

    public Membership(String ID, String name, String email, String phone, String address,
            double expense)
    {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.expense = expense;
        // this.SuperMarket = SuperMarket;

        if (this.expense < 500)
        {
            this.type = "Bronze";
            this.payPerCredit = 20;
            this.deductionRate = 0.05;
            this.GasdeductionRate = 0.1;
        }
        else if (this.expense >= 500 && this.expense < 1500)
        {
            this.type = "Silver";
            this.payPerCredit = 10;
            this.deductionRate = 0.1;
            this.GasdeductionRate = 0.15;
        }
        else if (this.expense >= 1500 && this.expense < 3000)
        {
            this.type = "Gold";
            this.payPerCredit = 8;
            this.deductionRate = 0.15;
            this.GasdeductionRate = 0.2;
        }
        else if (this.expense >= 3000 && this.expense < 5000)
        {
            this.type = "Diamond";
            this.payPerCredit = 6;
            this.deductionRate = 0.2;
            this.GasdeductionRate = 0.25;
        }
        else
        {
            this.type = "Platinum";
            this.payPerCredit = 4;
            this.deductionRate = 0.25;
            this.GasdeductionRate = 0.3;
        }

        this.totalCredits = this.payPerCredit * this.expense;
        this.DollarAvailable = (int) (this.totalCredits / 200);
    }

    public String getID()
    {
        return this.ID;
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public String getAddress()
    {
        return this.address;
    }

    public String getType()
    {
        return this.type;
    }

    public double getExpence()
    {
        return this.expense;
    }

    public int getPayPerCredit()
    {
        return this.payPerCredit;
    }

    public double getTotalCredits()
    {
        return this.totalCredits;
    }

    public double getGasDeductionRate()
    {
        return this.GasdeductionRate;
    }

    public int getDollarAvailable()
    {
        return this.DollarAvailable;
    }

    public double getDeductionRate()
    {
        return this.deductionRate;
    }

    // public SuperMarket getSuperMarket()
    // {
    // return this.SuperMarket;
    // }


    public String membershipFormat()
    {
        return String.format(Utils.membershipFormat, this.name, this.email, this.phone, this.type);
    }

    public String mmsFormat()
    {
        return String.format(Utils.mmsFormat, this.name, this.expense, this.totalCredits,
                this.DollarAvailable, this.type);
    }

    public void printMembership()
    {
        Utils.membershipHeader();
        System.out.format(Utils.membershipFormat, this.name, this.email, this.phone, this.type);
        Utils.membershipTableEnd();
    }

}
