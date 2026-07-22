package models;

public class SoftwareProject {
    private String projectCode;
    private String projectName;
    private ProjectMetrics metrics;
    private int priority;


    public SoftwareProject(String projectCode, String projectName, ProjectMetrics metrics, int priority) {
      this.projectCode = projectCode;
      this.projectName = projectName;
      this.metrics = metrics;
      this.priority = priority;
    }


    public String getProjectCode() {
      return projectCode;
    }

    public String getProjectName() {
      return projectName;
    }

    public ProjectMetrics getMetrics() {
      return metrics;
    }

    public int getPriority() {
      return priority;
    }
    

}
