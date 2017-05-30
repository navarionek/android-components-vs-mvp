package co.netguru.android.io17.search;

import android.support.v7.widget.RecyclerView;

import co.netguru.android.io17.databinding.ItemCityQualityBinding;

public class CityQualityViewHolder extends RecyclerView.ViewHolder {

    final ItemCityQualityBinding binding;

    public CityQualityViewHolder(ItemCityQualityBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}