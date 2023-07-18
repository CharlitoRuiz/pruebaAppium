package POJO;

public class LoginData {
    private String username;
    private String password;

    public LoginData(String _username, String _password){
        this.username = _username;
        this.password = _password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
