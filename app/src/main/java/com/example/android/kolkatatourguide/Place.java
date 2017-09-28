package com.example.android.kolkatatourguide;

import android.net.Uri;

/**
 * Created by SUMITABHA on 02-06-2017.
 */
public class Place {
    private String mPlace;

    private int mImageResourceId;
    private Uri mLocationId;


    public Place(String place, int imageResourceId, Uri locationId) {
        mPlace = place;
        mImageResourceId = imageResourceId;
        mLocationId = locationId;
    }

    public String getPlace() {
        return mPlace;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public Uri getLocationId() {
        return mLocationId;
    }
}
