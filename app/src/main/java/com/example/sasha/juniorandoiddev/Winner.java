package com.example.sasha.juniorandoiddev;

class Winner {

    private Integer id;
    private String name;
    private String shortName;
    private String tla;
    private String crestUrl;

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
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTla() {
        return tla;
    }

    public void setTla(String tla) {
        this.tla = tla;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    @Override
    public String toString()
    {
        return "ClassAllLeag [id = "+id+",name = "+name+",shortName = "+shortName+",tla = "+tla+",crestUrl = "+crestUrl+"]";
    }
}
