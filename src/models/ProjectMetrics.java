package models;

public class ProjectMetrics {

    private double estimatedHours;
    private int teamSize;
    private int completedTasks;
    private int pendingTasks;

    public ProjectMetrics(double estimatedHours, int teamSize, int completedTasks, int pendingTasks) {
      this.estimatedHours = estimatedHours;
      this.teamSize = teamSize;
      this.completedTasks = completedTasks;
      this.pendingTasks = pendingTasks;
    }

    public double getEstimatedHours() {
      return estimatedHours;
    }

    public int getTeamSize() {
      return teamSize;
    }

    public int getCompletedTasks() {
      return completedTasks;
    }

    public int getPendingTasks() {
      return pendingTasks;
    }

    public double getWorkload() {
      return estimatedHours * teamSize;
    }

}
