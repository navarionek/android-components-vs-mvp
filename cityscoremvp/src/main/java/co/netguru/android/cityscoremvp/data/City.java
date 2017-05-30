package co.netguru.android.cityscoremvp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class City {
    private String name;

    @SerializedName("summary")
    private String description;
    @SerializedName("teleport_city_score")
    private float score;
    @SerializedName("categories")
    private List<CityQuality> qualities;

    public City(String name, String description, float score, List<CityQuality> qualities) {
        this.name = name;
        this.description = description;
        this.score = score;
        this.qualities = qualities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public List<CityQuality> getQualities() {
        return qualities;
    }

    public void setQualities(List<CityQuality> qualities) {
        this.qualities = qualities;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", score=" + score +
                ", qualities=" + qualities +
                '}';
    }
}
