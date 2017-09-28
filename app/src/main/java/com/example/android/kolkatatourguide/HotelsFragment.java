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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("JW Marriott Kolkata", R.drawable.marriott, Uri.parse("geo:0,0?q=JW+Marriott+Kolkata")));
        places.add(new Place("Taj Bengal", R.drawable.taj_bengal, Uri.parse("geo:0,0?q=Taj+Bengal")));
        places.add(new Place("ITC Sonar", R.drawable.itc_sonar, Uri.parse("geo:0,0?q=ITC+Sonar")));
        places.add(new Place("Hyatt Regency", R.drawable.hyatt, Uri.parse("geo:0,0?q=Hyatt+Regency")));
        places.add(new Place("The Lalit Great Eastern", R.drawable.lalit_great_eastern, Uri.parse("geo:0,0?q=The+Lalit+Great+Eastern+Kolkata")));
        places.add(new Place("Novotel Kolkata", R.drawable.novotel, Uri.parse("geo:0,0?q=Novotel+Kolkata")));
        places.add(new Place("The Gateway", R.drawable.gateway_hotel, Uri.parse("geo:0,0?q=The+Gateway+Kolkata")));
        places.add(new Place("The Oberoi Grand", R.drawable.oberoi_grand, Uri.parse("geo:0,0?q=The+Oberoi+Grand+Kolkata")));
        places.add(new Place("Swissotel Kolkata", R.drawable.swissotel, Uri.parse("geo:0,0?q=Swissotel+Kolkata")));
        places.add(new Place("The Park Kolkata", R.drawable.park_hotel, Uri.parse("geo:0,0?q=The+Park+Kolkata")));
        places.add(new Place("Hotel Hindusthan International", R.drawable.hindusthan_international, Uri.parse("geo:0,0?q=Hotel+Hindusthan+International")));
        places.add(new Place("The Peerless Inn", R.drawable.peerless_inn, Uri.parse("geo:0,0?q=The+Peerless+Inn")));
        places.add(new Place("Vedic Village Resorts", R.drawable.vedic_village, Uri.parse("geo:0,0?q=Vedic+Village+Resorts+Kolkata")));
        places.add(new Place("Hotel Pride Plaza", R.drawable.pride_plaza, Uri.parse("geo:0,0?q=Hotel+Pride+Plaza+Kolkata")));
        places.add(new Place("Hotel Sonnet", R.drawable.sonnet_hotel, Uri.parse("geo:0,0?q=Hotel+Sonnet+Kolkata")));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_hotels);

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
