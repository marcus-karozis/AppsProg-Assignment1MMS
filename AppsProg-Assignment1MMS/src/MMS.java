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
    private static ArrayList<String> names = new ArrayList<String>();

    public MMS(SuperMarket sM, Memberships m)
    {
        this.superMarket = sM;
        this.memberships = m;
        this.mmSlips = new ArrayList<MMSlip>();
        generateSlips();
        calculateTotals();
    }

    public String getName()
    {
        if (this.name == null)
        {
            generateName();
        }
        return this.name;
    }

    public void generateSlips()
    {
        for (Membership m : this.memberships.getMembershipsList())
        {
            this.mmSlips.add(new MMSlip(m));
        }
    }

    public void calculateTotals()
    {
        double totalE = 0;
        double totalC = 0;
        double totalD = 0;
        double totalPPC = 0;
        double totalDR = 0;
        double totalGDR = 0;
        for (MMSlip s : mmSlips)
        {
            totalE += s.getExpence();
            totalC += s.getTotalCredits();
            totalD += s.getDollarAvailable();
            totalPPC += s.getPayPerCredit();
            totalDR += s.getDeductionRate();
            totalGDR += s.getGasDeductionRate();
        }
        double avgPPC = totalPPC / mmSlips.size();
        double avgDR = totalDR / mmSlips.size();
        double avgGDR = totalGDR / mmSlips.size();

        this.totalCredits = totalC;
        this.gasDeductionRate = avgGDR;
        this.dollarAvailable = totalD;
        this.deductionRate = avgDR;
        this.payPerCredit = avgPPC;
        this.expense = totalE;
    }

    public void generateName()
    {
        int i = 1;
        while (true)
        {
            if (!names.contains((this.superMarket.getName() + i)))
            {
                names.add((this.superMarket.getName() + i));
                this.name = (this.superMarket.getName() + i);
                break;
            }
            else
            {
                i++;
            }
        }
    }

    public void printMMS()
    {
        Utils.Totalslipheader();
        for (MMSlip s : mmSlips)
        {
            System.out.format(Utils.mmsFormat, s.getName(), s.getExpence(), s.getTotalCredits(),
                    s.getDollarAvailable(), s.getType());
        }
        Utils.TotalslipTableEnd();
        System.out.print("\n");
        Utils.TotalSumHeader();
        System.out.format(Utils.sumFormat, "Total expense", this.expense);
        System.out.format(Utils.sumFormat, "Total credits", this.totalCredits);
        System.out.format(Utils.sumFormat, "Total dollars", this.dollarAvailable);
        System.out.format(Utils.sumFormat, "Average pay per credit", this.payPerCredit);
        System.out.format(Utils.sumFormat, "Average deduction rate", this.deductionRate);
        System.out.format(Utils.sumFormat, "Average gas deduction rate", this.gasDeductionRate);
        Utils.TotalSumTableEnd();
    }



}
