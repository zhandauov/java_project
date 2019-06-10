package user_classes;

 abstract  public class User {
    private String login;
    private String password;
    private String id;
    public String firstname;
    public String lastname;

    public User(String login, String password, String id,
                String firstname, String lastname)
    {
        this.login = login; this.password = password;
        this.id = id; this.firstname = firstname; this.lastname = lastname;
    }

    public User()
    {
        login = "";
        password = "";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }
    public String getFullname() { return firstname + ' ' + lastname;}
}
