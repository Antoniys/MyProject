package model;


public class User {
    private String email;
    private String password;
    protected Role role;
    private int id;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, Role role, String password) {
        this.email = email;
        this.role=role;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        User other = (User) obj;

        if (this.email != other.email)
            return false;
        if (this.id != other.id)
            return false;
        return (this.role == other.role);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + id;
        return result;
    }
}
