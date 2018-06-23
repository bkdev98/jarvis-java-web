package khanhbq.dtos;

public class AvengerDTO {
    int id;
    String loginName, password, realName, madeUpName, avatarUrl, abilities, role;

    public AvengerDTO() {
    }

    public AvengerDTO(int id, String loginName, String realName, String madeUpName, String avatarUrl, String abilities, String role) {
        this.id = id;
        this.loginName = loginName;
        this.realName = realName;
        this.madeUpName = madeUpName;
        this.avatarUrl = avatarUrl;
        this.abilities = abilities;
        this.role = role;
    }

    public AvengerDTO(int id, String loginName, String password, String realName, String madeUpName, String avatarUrl, String abilities, String role) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.realName = realName;
        this.madeUpName = madeUpName;
        this.avatarUrl = avatarUrl;
        this.abilities = abilities;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMadeUpName() {
        return madeUpName;
    }

    public void setMadeUpName(String madeUpName) {
        this.madeUpName = madeUpName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
