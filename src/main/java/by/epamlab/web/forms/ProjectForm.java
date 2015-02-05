package by.epamlab.web.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ProjectForm {

    @NotNull
    @Pattern(regexp = "([\\w\\s]{1,50})")
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String psd;

    @NotNull
    private String ped;

    /*@NotNull
    private String status;*/

    public ProjectForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public String getPed() {
        return ped;
    }

    public void setPed(String ped) {
        this.ped = ped;
    }

    /*public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }*/
}
