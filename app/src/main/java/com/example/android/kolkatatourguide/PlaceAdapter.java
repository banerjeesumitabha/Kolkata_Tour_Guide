package com.example.android.kolkatatourguide;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SUMITABHA on 02-06-2017.
 */
public class PlaceAdapter extends ArrayAdapter<Place>{

    private int mColorResourceId;

    public PlaceAdapter(Activity context, ArrayList<Place> places, int colorResourceId) {

        super(context, 0, places);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Place currentPlace = getItem(position);

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place_text_view);

        placeTextView.setText(currentPlace.getPlace());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentPlace.getImageResourceId() > 0) {
            iconView.setImageResource(currentPlace.getImageResourceId());
        } else

        {
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
