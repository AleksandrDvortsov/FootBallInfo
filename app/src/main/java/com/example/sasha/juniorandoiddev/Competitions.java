package com.example.sasha.juniorandoiddev;

public class Competitions {

    private Integer id;
    private Area area;
    private String name;
    private String code;
    private Object emblemUrl;
    private String plan;
    private CurrentSeason currentSeason;
    private Integer numberOfAvailableSeasons;
    private String lastUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getEmblemUrl() {
        return emblemUrl;
    }

    public void setEmblemUrl(Object emblemUrl) {
        this.emblemUrl = emblemUrl;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public CurrentSeason getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(CurrentSeason currentSeason) {
        this.currentSeason = currentSeason;
    }

    public Integer getNumberOfAvailableSeasons() {
        return numberOfAvailableSeasons;
    }

    public void setNumberOfAvailableSeasons(Integer numberOfAvailableSeasons) {
        this.numberOfAvailableSeasons = numberOfAvailableSeasons;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString()
    {
        return "ClassAllLeag [id = "+id+",area = "+area+", name = "+name+",code = "+code+", emblemUrl = "+emblemUrl+",plan = "+plan+", currentSeason = "+currentSeason+",numberOfAvailableSeasons = "+numberOfAvailableSeasons+", lastUpdated = "+lastUpdated+"]";
    }

}
