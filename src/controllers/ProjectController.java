package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import models.SoftwareProject;

public class ProjectController {
  public Set<SoftwareProject> filterAndOrderProjects(List<SoftwareProject> projects, double minimumWorkload) {
    Comparator<SoftwareProject> comparator = new Comparator<SoftwareProject>() {
    @Override
    public int compare(SoftwareProject p1, SoftwareProject p2) {

      double w1 = p1.getMetrics().getWorkload();
      double w2 = p2.getMetrics().getWorkload();

      if (w1 == w2 && p1.getProjectCode().equalsIgnoreCase(p2.getProjectCode())) {
        return 0;
      }

      if(w1 > w2) {
        return -1;
      }

      if(w1 < w2) {
        return 1;
      }

      return p1.getProjectCode().compareToIgnoreCase(p2.getProjectCode());
    }

  };

  Set<SoftwareProject> result = new TreeSet<>(comparator);
  for (SoftwareProject project : projects) {

    if (project.getMetrics().getWorkload() >= minimumWorkload) {
      result.add(project);
    }

  }

  return result;

  }

  public List<SoftwareProject> classifyAndExtractProjects(
    List<SoftwareProject> projects,
    String requestedCategory) {
      if (requestedCategory == null) {
        return new ArrayList<>();
      }

      Comparator<SoftwareProject> comparator = new Comparator<SoftwareProject>() {
        @Override
        public int compare(SoftwareProject p1, SoftwareProject p2) {
          if (p1.getPriority() == p2.getPriority() && p1.getProjectCode().equalsIgnoreCase(p2.getProjectCode())) {
            return 0;
          }

          if (p1.getPriority() > p2.getPriority()) {
            return -1;
          }

          if (p1.getPriority() < p2.getPriority()) {
            return 1;
          }

          return p1.getProjectCode().compareToIgnoreCase(p2.getProjectCode());
        }
      };

      Map<String, Set<SoftwareProject>> categories = new TreeMap<>();
      categories.put("CRITICAL", new TreeSet<>(comparator));
      categories.put("SMALL", new TreeSet<>(comparator));
      categories.put("STANDARD", new TreeSet<>(comparator));

      for (SoftwareProject project : projects) {
        double workload = project.getMetrics().getWorkload();
        int pending = project.getMetrics().getPendingTasks();

        if (workload >= 900 || pending >= 18) {
          categories.get("CRITICAL").add(project);
        } else if (workload >= 350) {
          categories.get("STANDARD").add(project);
        } else {
          categories.get("SMALL").add(project);
        }
      }

      String key = requestedCategory.trim().toUpperCase();

      if (!categories.containsKey(key)) {
        return new ArrayList<>();
      }

      return new ArrayList<>(categories.get(key));
  }
}
