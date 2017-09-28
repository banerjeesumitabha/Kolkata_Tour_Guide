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
public class NatureFragment extends Fragment {


    public NatureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Eco Tourism Park", R.drawable.eco_park, Uri.parse("geo:0,0?q=Eco+Park+Kolkata")));
        places.add(new Place("Princep Ghat", R.drawable.princep_ghat, Uri.parse("geo:0,0?q=Princep+Ghat")));
        places.add(new Place("Kolkata Maidan", R.drawable.maidan, Uri.parse("geo:0,0?q=Kolkata+Maidan")));
        places.add(new Place("Central Park", R.drawable.central_park, Uri.parse("geo:0,0?q=Central+Park+Kolkata")));
        places.add(new Place("Millennium Park", R.drawable.millennium_park, Uri.parse("geo:0,0?q=Millennium+Park+Kolkata")));
        places.add(new Place("Rabindra Sarovar", R.drawable.rabindra_sarovar, Uri.parse("geo:0,0?q=Rabindra+Sarovar")));
        places.add(new Place("Alipore Zoo", R.drawable.alipore_zoo, Uri.parse("geo:0,0?q=Alipore+Zoo")));
        places.add(new Place("Shibpur Botanical Gardens", R.drawable.shibpur_botanical_garden, Uri.parse("geo:0,0?q=Shibpur+Botanical+Gardens")));
        places.add(new Place("Nalban Boating Complex", R.drawable.nalban, Uri.parse("geo:0,0?q=Nalban+Boating+Complex")));
        places.add(new Place("Alipore Horticultural Gardens", R.drawable.alipore_horticulture, Uri.parse("geo:0,0?q=Alipore+Horticultural+Gardens")));
        places.add(new Place("Eco Aquatic Hub", R.drawable.aquatic_hub, Uri.parse("geo:0,0?q=Eco+Aquatic+Hub+Kolkata")));
        places.add(new Place("Nicco Park (Amusement Park)", R.drawable.nicco_park, Uri.parse("geo:0,0?q=Nicco+Park+Kolkata")));
        places.add(new Place("Aquatica (Amusement Park)", R.drawable.aquatica, Uri.parse("geo:0,0?q=Aquatica+Kolkata")));
        places.add(new Place("Nature Park", R.drawable.nature_park, Uri.parse("geo:0,0?q=Nature+Park+Kolkata")));
        places.add(new Place("Chintamani Kar Bird Sanctuary", R.drawable.bird_sanctuary, Uri.parse("geo:0,0?q=Chintamani+Kar+Bird+Sanctuary+Kolkata")));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_nature);

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
