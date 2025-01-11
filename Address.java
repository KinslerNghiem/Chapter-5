//********************************************************************
//  Address.java       Author: Tien Nghiem
//
//  Date: 12/12/24
//  Represents a street address.
//********************************************************************
//poop
public class Address implements Comparable {
    private String streetAddress, city;
    private static String state = "IL";
    private int zipCode;

    /*
     * Sets up this Address object with the specified data.
     * @param String streetAddress, String city, String state, int zipCode
     */
    public Address(String streetAddress, String city, String state, int zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    /*
     * Uses comparable interface to compare streets.
     * @param Object obj
     */
    public int compareTo(Object obj) {
        Address other = (Address) obj;

        String thisStreetName = this.streetAddress.substring(this.streetAddress.indexOf(" ") + 1);
        String otherStreetName = other.streetAddress.substring(other.streetAddress.indexOf(" ") + 1);

        // Compare street names
        int Comparison = thisStreetName.compareTo(otherStreetName);
        if (Comparison != 0) {
            return Comparison;
        }

        // If street names are the same: compare numebrs
        int thisHouseNum = Integer.parseInt(this.streetAddress.substring(0, this.streetAddress.indexOf(" ")));
        int otherHouseNum = Integer.parseInt(other.streetAddress.substring(0, other.streetAddress.indexOf(" ")));

        return Integer.compare(thisHouseNum, otherHouseNum);
    }

    /*
     * Static method to set state with password.
     * @param String password, String st
     */
    public static void setState(String password, String st) {
        if (password.equals("admin123")) {
            state = st;
        } else {
            state = "IL";
            System.out.println("Access Denied.");
        }
    }

    /*
     * A setAddress method to set an address given an object
     * @param Address obj
     */
    public void setAddress(Address obj) {
        this.streetAddress = obj.streetAddress;
        this.city = obj.city;
        this.zipCode = obj.zipCode;
    }

    /*
     * An overloaded setAddress method to set an address given street, city, and zip code
     * @param String street, String city, int zip
     */
    public void setAddress(String street, String city, int zip) {
        this.streetAddress = street;
        this.city = city;
        this.zipCode = zip;
    }

    /*
     *Returns this Address object as a string.
     */
    public String toString() {
        String result;
        result = streetAddress + "\n";
        result += city + ", " + state + "  " + zipCode;
        return result;
    }
}