package com.dentaltw.bootcamplocator.models;

/**
 * Created by Scott on 2017/4/24.
 */

public class Develops {
    private float longitude;
    private float latitude;
    private String locationTitle;
    private String locationAddress;
    private String locationImgUrl;

    final String DRAWABLE = "drawable/";
    public String getImageUrl(){
        return DRAWABLE + locationImgUrl;
    }

    public Develops(float longitude, float latitude, String locationTitle, String locationAddress, String locationImgUrl) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.locationTitle = locationTitle;
        this.locationAddress = locationAddress;
        this.locationImgUrl = locationImgUrl;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getLocationTitle() {
        return locationTitle;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public String getLocationImgUrl() {
        return locationImgUrl;
    }
}
