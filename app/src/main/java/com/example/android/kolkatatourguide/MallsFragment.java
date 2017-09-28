package com.example.android.kolkatatourguide;


import android.content.Intent;
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
public class MallsFragment extends Fragment {


    public MallsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("South City Mall", R.drawable.south_city, Uri.parse("geo:0,0?q=South+City+Mall")));
        places.add(new Place("Quest Mall", R.drawable.quest, Uri.parse("geo:0,0?q=Quest+Mall")));
        places.add(new Place("City Centre I", R.drawable.city_centre_1, Uri.parse("geo:0,0?q=City+Centre+Salt+Lake")));
        places.add(new Place("City Centre II", R.drawable.city_centre_2, Uri.parse("geo:0,0?q=City+Centre+Rajarhat")));
        places.add(new Place("Acropolis Mall", R.drawable.acropolis_mall, Uri.parse("geo:0,0?q=Acropolis+Mall")));
        places.add(new Place("Mani Square", R.drawable.mani_square, Uri.parse("geo:0,0?q=Mother+House+Kolkata")));
        places.add(new Place("Axis Mall", R.drawable.axis_mall, Uri.parse("geo:0,0?q=Axis+Mall")));
        places.add(new Place("Metropolis Mall", R.drawable.metropolis_mall, Uri.parse("geo:0,0?q=Metropolis+Mall+Kolkata")));
        places.add(new Place("Forum Courtyard", R.drawable.forum_mall, Uri.parse("geo:0,0?q=Forum+Courtyard+Kolkata")));
        places.add(new Place("DLF Galleria", R.drawable.dlf_galleria, Uri.parse("geo:0,0?q=DLF+Galleria+Kolkata")));
        places.add(new Place("E-Mall", R.drawable.emall, Uri.parse("geo:0,0?q=E+Mall+Kolkata")));
        places.add(new Place("Lake Mall", R.drawable.lake_mall, Uri.parse("geo:0,0?q=Lake+Mall+Kolkata")));
        places.add(new Place("Merlin Homeland", R.drawable.homeland, Uri.parse("geo:0,0?q=Merlin+Homeland+Kolkata")));
        places.add(new Place("HomeTown Rajarhat", R.drawable.hometown_rajarhat, Uri.parse("geo:0,0?q=HomeTown+Rajarhat")));
        places.add(new Place("PVR Diamond Plaza", R.drawable.pvr_diamond_plaza, Uri.parse("geo:0,0?q=PVR+Diamond+Plaza")));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_malls);

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

