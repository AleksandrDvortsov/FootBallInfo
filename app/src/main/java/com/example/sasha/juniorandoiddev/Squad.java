package com.example.sasha.juniorandoiddev;

class Squad {

    private Integer id;
    private String name;
    private Object position;
    private String dateOfBirth;
    private String countryOfBirth;
    private String nationality;
    private Object shirtNumber;
    private String role;

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

    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Object getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(Object shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString()
    {
        return "ClassAllLeag [id = "+id+", name = "+name+", position = " + position +", dateOfBirth = " + dateOfBirth +", countryOfBirth = " + countryOfBirth +" , nationality = "
                + nationality +", shirtNumber = " + shirtNumber + ", role = " + role + "]";
    }

}
