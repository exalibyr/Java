package logic;

public class Config {
    private String url;
    private String login;
    private String password;

    public Config(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
