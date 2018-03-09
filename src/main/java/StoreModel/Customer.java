package StoreModel;

/**
 *
 * @author Mitch
 */
public class Customer {

    private String fName;
    private String lName;
    private String email;
    private String id;
//Customer has a cart.. Figure this out later...

    public Customer(String fName, String lName, String email, String id) {
        setfName(fName);
        setlName(lName);
        setEmail(email);
        setId(id);
    }

    public final String getfName() {
        return fName;
    }

    public final void setfName(String fName) {
        this.fName = fName;
    }

    public final String getlName() {
        return lName;
    }

    public final void setlName(String lName) {
        this.lName = lName;
    }

    public final String getEmail() {
        return email;
    }

    public final void setEmail(String email) {
        this.email = email;
    }

    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        this.id = id;
    }

}
