package com.company;

public class Land {
    private String nameOfLand;
    private String lordOfLand;

    Land(String nameOfLand, String lordOfLand){
        this.nameOfLand = nameOfLand;
        this.lordOfLand = lordOfLand;
    }

    public String getNameOfLand() {
        return nameOfLand;
    }

    public void setNameOfLand(String nameOfLand) {
        this.nameOfLand = nameOfLand;
    }

    public String getLordOfLand() {
        return lordOfLand;
    }

    public void setLordOfLand(String lordOfLand) {
        this.lordOfLand = lordOfLand;
    }

    @Override
    public String toString() {
        return "Land{" +
                "nameOfLand='" + nameOfLand + '\'' +
                ", lordOfLand='" + lordOfLand + '\'' +
                '}';
    }
}
