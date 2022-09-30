
public class MMSlip
{

    private String name;
    private String type;
    private double totalCredits;
    private double gasDeductionRate;
    private int dollarAvailable;
    // private double deductionRate;
    private double payPerCredit;
    private double expense;

    public MMSlip(Membership m)
    {
        this.name = m.getName();
        this.type = m.getType();
        this.totalCredits = m.getTotalCredits();
        this.gasDeductionRate = m.getGasDeductionRate();
        this.dollarAvailable = m.getDollarAvailable();
        // this.deductionRate = m.getDeductionRate();
        this.payPerCredit = m.getPayPerCredit();
        this.expense = m.getExpence();
    }


}
