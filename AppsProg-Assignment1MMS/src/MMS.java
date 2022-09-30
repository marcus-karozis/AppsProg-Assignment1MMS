import java.util.ArrayList;


public class MMS
{
    private double totalCredits;
    private double gasDeductionRate;
    private double dollarAvailable;
    private double deductionRate;
    private double payPerCredit;
    private String name;
    private double expense;
    private Memberships memberships;
    private ArrayList<MMSlip> mmSlips;
    private SuperMarket superMarket;

    public MMS(SuperMarket sM, Memberships m)
    {
        this.superMarket = sM;
        this.memberships = m;
    }



}
