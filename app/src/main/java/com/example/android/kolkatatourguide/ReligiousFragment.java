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
public class ReligiousFragment extends Fragment {


    public ReligiousFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Dakshineshwar Kali Temple", R.drawable.dakshineshwar, Uri.parse("geo:0,0?q=Dakshineshwar+Kali+Temple")));
        places.add(new Place("Birla Mandir", R.drawable.birla_mandir, Uri.parse("geo:0,0?q=Birla+Mandir+Kolkata")));
        places.add(new Place("Kalighat Temple", R.drawable.kalighat, Uri.parse("geo:0,0?q=Kalighat+Temple+Kolkata")));
        places.add(new Place("23 Pally Durga Mandir", R.drawable.durga_mandir, Uri.parse("geo:0,0?q=23+Pally+Durga+Mandir")));
        places.add(new Place("Swaminarayan Temple", R.drawable.swaminarayan, Uri.parse("geo:0,0?q=Swaminarayan+Temple+Kolkata")));
        places.add(new Place("ISKCON Temple", R.drawable.iskcon, Uri.parse("geo:0,0?q=ISCKON+Temple+Kolkata")));
        places.add(new Place("Nakhoda Mosque", R.drawable.nakhoda, Uri.parse("geo:0,0?q=Nakhoda+Mosque+Kolkata")));
        places.add(new Place("Tipu Sultan Masjid", R.drawable.tipu_sultan_masjid, Uri.parse("geo:0,0?q=Tipu+Sultan+Masjid+Kolkata")));
        places.add(new Place("St. Paul's Cathedral", R.drawable.st_paul, Uri.parse("geo:0,0?q=St.+Paul's+Cathedral+Kolkata")));
        places.add(new Place("St. John's Church", R.drawable.st_john, Uri.parse("geo:0,0?q=St.+John's+Church+Kolkata")));
        places.add(new Place("Pareshnath Jain Temple", R.drawable.pareshnath_jain_temple, Uri.parse("geo:0,0?q=Pareshnath+Jain+Temple+Kolkata")));
        places.add(new Place("Agni Mandir", R.drawable.agni_mandir, Uri.parse("geo:0,0?q=Agni+Mandir+Kolkata")));
        places.add(new Place("Gurdwara Bari Sangat", R.drawable.gurdwara_bari_sangat, Uri.parse("geo:0,0?q=Gurdwara+Bari+Sangat+Kolkata")));
        places.add(new Place("Gurdwara Sant Kutiya", R.drawable.gurdwara_sant_kutiya, Uri.parse("geo:0,0?q=Gurdwara+Sant+Kutiya+Kolkata")));
        places.add(new Place("Magen David Synagogue", R.drawable.magen_david_synagogue, Uri.parse("geo:0,0?q=Magen+David+Synagogue+Kolkata")));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_religious);

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
