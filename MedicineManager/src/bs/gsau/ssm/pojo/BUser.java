package bs.gsau.ssm.pojo;

import java.util.Date;

import javax.validation.constraints.Size;

public class BUser {
    private Integer id;

    @Size(min=1,max=6,message="{user.username.length.error}")
    private String username;

    @Size(min=6,max=10,message="{user.password.length.error}")
    private String password;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}