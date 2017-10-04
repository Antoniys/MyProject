package model;

public class UserClient extends User {
    private String name;
    private String surname;
    private String phoneNumber;


    {
        role=Role.CLIENT;
    }

    public UserClient(String email, String name, String surname, String phoneNumber, String password,Role role) {
        super(email,role,password);
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        UserClient other = (UserClient) obj;

        if (this.name != other.name)
            return false;
        if (this.phoneNumber != other.phoneNumber)
            return false;
        return (this.surname == other.surname);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }
}
