package com.example.android.kolkatatourguide;


import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Victoria Memorial Hall", R.drawable.victoria_memorial, Uri.parse("geo:0,0?q=Victoria+Memorial+Hall")));
        places.add(new Place("Howrah Bridge", R.drawable.howrah_bridge, Uri.parse("geo:0,0?q=Howrah+Bridge")));
        places.add(new Place("Belur Math", R.drawable.belur_math, Uri.parse("geo:0,0?q=Belur+Math")));
        places.add(new Place("Jorasanko Thakur Bari", R.drawable.jorasanko_thakurbari, Uri.parse("geo:0,0?q=Jorasanko+Thakur+Bari")));
        places.add(new Place("Shobhabazar Rajbari", R.drawable.shobhabazar_rajbari, Uri.parse("geo:0,0?q=Shobhabazar+Rajbari")));
        places.add(new Place("Mother House", R.drawable.mother_house, Uri.parse("geo:0,0?q=Mother+House+Kolkata")));
        places.add(new Place("Fort William", R.drawable.fort_william, Uri.parse("geo:0,0?q=Fort+William")));
        places.add(new Place("The Indian Museum", R.drawable.indian_museum, Uri.parse("geo:0,0?q=Indian+Museum+Kolkata")));
        places.add(new Place("Indian Coffee House", R.drawable.coffee_house, Uri.parse("geo:0,0?q=Indian+Coffee+House+Kolkata")));
        places.add(new Place("Marble Palace", R.drawable.marble_palace, Uri.parse("geo:0,0?q=Marble+Palace+Kolkata")));
        places.add(new Place("Eden Gardens", R.drawable.eden_gardens, Uri.parse("geo:0,0?q=Eden+Gardens")));
        places.add(new Place("Birla Planetarium", R.drawable.birla_planetarium, Uri.parse("geo:0,0?q=Birla+Planetarium+Kolkata")));
        places.add(new Place("Science City", R.drawable.science_city, Uri.parse("geo:0,0?q=Science+City+Kolkata")));
        places.add(new Place("Birla Technological Museum", R.drawable.bitm_kolkata, Uri.parse("geo:0,0?q=BITM+Kolkata")));
        places.add(new Place("Shahid Minar", R.drawable.shahid_minar, Uri.parse("geo:0,0?q=Shahid+Minar+Kolkata")));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_attractions);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Place} object at the given position the user clicked on
                Place place = places.get(position);
                Uri geoLocation = place.getLocationId();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLocation);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }

}
