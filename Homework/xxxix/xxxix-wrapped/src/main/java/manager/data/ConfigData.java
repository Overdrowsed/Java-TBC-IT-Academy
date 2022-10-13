package manager.data;

public class ConfigData {
    private String databasePath, username, password;
    private String[] allowedIp;

    //#region getter/setters
    public String getDatabasePath() {
        return databasePath;
    }

    public void setDatabasePath(String databasePath) {
        this.databasePath = databasePath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getAllowedIps() {
        return allowedIp;
    }

    public void setAllowedIp(String[] allowedIp) {
        this.allowedIp = allowedIp;
    }
    //#endregion   
}