
import java.util.ArrayList;

public class Memberships
{

    private ArrayList<Membership> memberships;

    public Memberships()
    {
        this.memberships = new ArrayList<Membership>();
        this.memberships.add(new Membership("13697480", "Thomas Muller", "thomas.muller@uts.com", 
                "99991111", "3 Byern St. Sydney 2001", 2134.5));

        this.memberships.add(new Membership("14517880", "Alice Stefan", "alice.stefan@uts.com",
                "88881111", "24 Pitt St. Sydney", 4512.2));

        this.memberships.add(new Membership("13267102", "Lucy Lu", "lucy.lu@uts.com",
                "98981100", "11 Hunter St. Sydney 2100", 158.4));

        this.memberships.add(new Membership("13678020", "Andreas Brehme", "andreas.b@uts.com",
                "90001222", "91 Sussex St. Sydney 2100", 7596.3));

        this.memberships.add(new Membership("13972870", "Ruddy Voller", "ruddy.v@uts.com",
                "98980000", "15 Stan St. Sydney 2100", 1100.0));

        this.memberships.add(new Membership("13859610", "Monica Shwarz", "monica.s@uts.com",
                "92241188", "155 Jones St. Sydney 2001", 6741.2));
    }

    public Membership getMembership(String name)
    {
        for (Membership m : memberships)
        {
            if(m.getName().equals(name))
            {
                return m;
            }
        }
        return null;
    }

    public void createMembership()
    {
        String newName = Utils.string("Name: ");
        String newEmail = Utils.string("Email: ");
        String newPhone = Utils.string("Phone: ");
        String newAddress = Utils.string("Address: ");
        String newID = Utils.string("ID: ");
        double newExpence = Utils.amount("expence: ");

        this.memberships.add(new Membership(newID, newName, newEmail, newPhone, newAddress, newExpence));
        System.out.println(newName+" record has been created.");
    }

    public void updateMembership(Membership m)
    {
        String newName = Utils.string("Name: ");
        String newEmail = Utils.string("Email: ");
        String newPhone = Utils.string("Phone: ");
        String newAddress = Utils.string("Address: ");
        String newID = Utils.string("ID: ");
        double newExpence = Utils.amount("expence: ");

        this.memberships
                .set(memberships.indexOf(m),new Membership(newID, newName, newEmail, newPhone, newAddress, newExpence));
        System.out.println(newName + " record has been created.");
    }
    
    public void deleteMembership(Membership m)
    {
        this.memberships.remove(memberships.indexOf(m));
    }

    public void printMemberships()
    {
        Utils.membershipHeader();
        for (Membership m : memberships)
        {
            System.out.print(m.membershipFormat());
        }
        Utils.membershipTableEnd();
    }
}