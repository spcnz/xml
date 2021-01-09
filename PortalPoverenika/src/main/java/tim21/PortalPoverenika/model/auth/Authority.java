package tim21.PortalPoverenika.model.auth;

import org.springframework.security.core.GrantedAuthority;

// POJO koji implementira Spring Security GrantedAuthority kojim se mogu definisati role u aplikaciji
public class Authority implements GrantedAuthority {

    String name;

    public Authority(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
