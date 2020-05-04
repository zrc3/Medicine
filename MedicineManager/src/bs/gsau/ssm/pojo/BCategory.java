package bs.gsau.ssm.pojo;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class BCategory {
    private Integer id;

    @NotBlank(message="{category.name.isNull}")
    private String name;

    private String description;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	@Override
	public String toString() {
		return "BCategory [id=" + id + ", name=" + name + ", description=" + description + ", createtime=" + createtime
				+ "]";
	}
    
    
}