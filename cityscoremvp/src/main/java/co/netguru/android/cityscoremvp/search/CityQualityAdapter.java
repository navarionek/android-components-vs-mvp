package co.netguru.android.cityscoremvp.search;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import co.netguru.android.cityscoremvp.data.City;

public class CityQualityAdapter extends RecyclerView.Adapter<CityQualityViewHolder> {

    private City city;

    @Override
    public CityQualityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CityQualityViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(CityQualityViewHolder holder, int position) {
        holder.bind(city.getQualities().get(position));
    }

    @Override
    public int getItemCount() {
        return city.getQualities().size();
    }

    public void setCity(City city) {
        this.city = city;
        notifyItemRangeChanged(0, city.getQualities().size());
    }

    public City getData() {
        return city;
    }
}