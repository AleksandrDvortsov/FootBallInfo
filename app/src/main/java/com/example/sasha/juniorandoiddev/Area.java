package com.example.sasha.juniorandoiddev;

class Area {
    private int id;
    private String name;

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassAllLeag [id = "+id+", name = "+name+"]";
    }

}
