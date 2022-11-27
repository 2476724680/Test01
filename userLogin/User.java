package userLogin;

public class User {
    private String name;
    private String password;
    private String idCardNumber;
    private String telephoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCard) {
        this.idCardNumber = idCard;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public User(String name, String password, String idCardNumber, String telephoneNumber) {
        this.name = name;
        this.password = password;
        this.idCardNumber = idCardNumber;
        this.telephoneNumber = telephoneNumber;
    }

    public User() {
    }
}
