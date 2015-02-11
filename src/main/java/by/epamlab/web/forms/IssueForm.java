package by.epamlab.web.forms;

import javax.validation.constraints.NotNull;

public class IssueForm {
    @NotNull
    private int project;
    @NotNull
    private String description;
    @NotNull
    private String summary;
    @NotNull
    private String psd;
    @NotNull
    private String ped;

    public IssueForm() {
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
}
