package co.netguru.android.cityscoremvp.data;

import com.google.gson.annotations.SerializedName;

public class CityQuality {
    private String name;
    @SerializedName("score_out_of_10")
    private float score;

    public CityQuality(String name, float score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
