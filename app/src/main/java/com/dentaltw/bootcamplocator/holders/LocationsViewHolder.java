package com.dentaltw.bootcamplocator.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.dentaltw.bootcamplocator.R;
import com.dentaltw.bootcamplocator.models.Develops;

/**
 * Created by Scott on 2017/4/25.
 */

public class LocationsViewHolder extends RecyclerView.ViewHolder {
    private ImageView locationImage;
    private TextView locationTitle;
    private TextView locationAddress;

    public LocationsViewHolder(View itemView) {
        super(itemView);

        locationImage = (ImageView) itemView.findViewById(R.id.location_image);
        locationTitle = (TextView) itemView.findViewById(R.id.location_title);
        locationAddress = (TextView) itemView.findViewById(R.id.location_title);
    }

    public void updateUI(Develops location){
        String uri = location.getImageUrl();
        int resource = locationImage.getResources().getIdentifier(uri, null, locationImage.getContext().getPackageName());
        locationImage.setImageResource(resource);
        locationTitle.setText(location.getLocationTitle());
        locationAddress.setText(location.getLocationAddress());
    }
}
