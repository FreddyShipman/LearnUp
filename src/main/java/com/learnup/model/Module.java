package com.learnup.model;

/**
 *
 * @author alfre
 */

import java.util.List;

public class Module {
    private String moduleTitle;
    private int durationMinutes;
    private List<Resource> resources;

    public Module() {
    
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
    
    
}