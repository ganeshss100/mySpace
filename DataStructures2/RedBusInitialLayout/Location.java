package BlueBus;

/**
 * Created by gsrinivasagam on 2/9/2018.
 */
public class Location {

    String name;
    String pincode;
    String conactNumber;
    String address;


    //validate from and to
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }


    public String getConactNumber() {
        return conactNumber;
    }

    public void setConactNumber(String conactNumber) {
        this.conactNumber = conactNumber;
    }


}
