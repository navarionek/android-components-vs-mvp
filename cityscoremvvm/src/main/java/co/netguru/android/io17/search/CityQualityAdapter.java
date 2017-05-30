package co.netguru.android.io17.search;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import javax.inject.Inject;

import co.netguru.android.io17.R;
import co.netguru.android.io17.data.City;
import co.netguru.android.io17.databinding.ItemCityQualityBinding;

public class CityQualityAdapter extends RecyclerView.Adapter<CityQualityViewHolder> {

    private City city;

    @Inject
    public CityQualityAdapter() {

    }

    @Override
    public CityQualityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCityQualityBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_city_quality, parent, false);
        return new CityQualityViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CityQualityViewHolder holder, int position) {
        holder.binding.setCityQuality(city.getQualities().get(position));
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