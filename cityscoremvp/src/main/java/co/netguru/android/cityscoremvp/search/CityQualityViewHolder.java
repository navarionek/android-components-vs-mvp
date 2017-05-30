package co.netguru.android.cityscoremvp.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.netguru.android.cityscoremvp.data.CityQuality;
import co.netguru.android.cityscoremvp.R;

public class CityQualityViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.city_quality)
    TextView qualityName;

    public CityQualityViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_city_quality, parent, false));

        ButterKnife.bind(this, itemView);
    }

    public void bind(CityQuality cityQuality) {
        String text = cityQuality.getName() + ": " + String.format("%.1f", cityQuality.getScore());
        qualityName.setText(text);
    }

}
