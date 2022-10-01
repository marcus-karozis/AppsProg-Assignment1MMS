
public class MMSlip
{

    private String name;
    private String type;
    private double totalCredits;
    private double gasDeductionRate;
    private int dollarAvailable;
    private double deductionRate;
    private double payPerCredit;
    private double expense;

    public MMSlip(Membership m)
    {
        this.name = m.getName();
        this.type = m.getType();
        this.totalCredits = m.getTotalCredits();
        this.gasDeductionRate = m.getGasDeductionRate();
        this.dollarAvailable = m.getDollarAvailable();
        this.deductionRate = m.getDeductionRate();
        this.payPerCredit = m.getPayPerCredit();
        this.expense = m.getExpence();
    }

    public void printSlip()
    {
        Utils.slipHeader();
        System.out.format(Utils.mmsFormat, this.name, this.expense, this.totalCredits,
                this.dollarAvailable, this.type);
        Utils.slipTableEnd();
    }

    public String getName()
    {
        return this.name;
    }

    public String getType()
    {
        return this.type;
    }

    public double getTotalCredits()
    {
        return this.totalCredits;
    }

    public double getGasDeductionRate()
    {
        return this.gasDeductionRate;
    }

    public int getDollarAvailable()
    {
        return this.dollarAvailable;
    }

    public double getDeductionRate()
    {
        return this.deductionRate;
    }

    public double getPayPerCredit()
    {
        return this.payPerCredit;
    }

    public double getExpence()
    {
        return this.expense;
    }


}
