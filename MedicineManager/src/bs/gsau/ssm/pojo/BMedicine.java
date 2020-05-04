package bs.gsau.ssm.pojo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class BMedicine {
    private Integer id;

    private Integer categoryid;

    @NotBlank(message="{medicine.medNo.isNull}")
    private String medno;

    @NotBlank(message="{medicine.name.isNull}")
    private String name;
    
    @NotBlank(message="{medicine.factoryAdd.isNull}")
    private String factoryadd;

    private String description;

    @NotNull(message="{medicine.price.isNull}")
    private Float price;

    private Integer medcount;

    private String photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getMedno() {
        return medno;
    }

    public void setMedno(String medno) {
        this.medno = medno == null ? null : medno.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFactoryadd() {
        return factoryadd;
    }

    public void setFactoryadd(String factoryadd) {
        this.factoryadd = factoryadd == null ? null : factoryadd.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getMedcount() {
        return medcount;
    }

    public void setMedcount(Integer medcount) {
        this.medcount = medcount;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    
}