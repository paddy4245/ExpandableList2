package paddy.mchugh.com.expandablelist2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import static paddy.mchugh.com.expandablelist2.R.drawable.cloughaneely_stone;

public class MainActivity extends Activity  {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private int lastExpandedPosition = -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imageButton1, imageButton2, imageButton3, imageButton4;
        imageButton1 = (ImageButton)findViewById(R.id.imageButton01);
        imageButton1.setImageResource(R.drawable.cloughaneely_stone_small);
        imageButton2 = (ImageButton)findViewById(R.id.imageButton02);
        imageButton2.setImageResource(R.drawable.bench_seat_small);
        imageButton3 = (ImageButton)findViewById(R.id.imageButton03);
        imageButton3.setImageResource(R.drawable.an_tsean_bheairic);
        imageButton4 = (ImageButton)findViewById(R.id.imageButton04);
        imageButton4.setImageResource(R.drawable.magheroarty_beach);
        /*
        int min = 1;
        int max = 4;
        Random r = new Random();
        int randomInt = r.nextInt(max - min + 1) +min;
        Log.i("Random number is:", String.valueOf(randomInt));
        switch (randomInt){
            case 1:
                imageButton1 = (ImageButton)findViewById(R.id.imageButton01);
                imageButton1.setImageResource(R.drawable.cloughaneely_stone_small);
                imageButton2 = (ImageButton)findViewById(R.id.imageButton02);
                imageButton2.setImageResource(R.drawable.bench_seat_small);
                imageButton3 = (ImageButton)findViewById(R.id.imageButton03);
                imageButton3.setImageResource(R.drawable.an_tsean_bheairic);
                imageButton4 = (ImageButton)findViewById(R.id.imageButton04);
                imageButton4.setImageResource(R.drawable.magheroarty_beach);
                break;
            case 2:
                imageButton1 = (ImageButton)findViewById(R.id.imageButton01);
                imageButton1.setImageResource(R.drawable.bench_seat_small);
                imageButton2 = (ImageButton)findViewById(R.id.imageButton02);
                imageButton2.setImageResource(R.drawable.an_tsean_bheairic);
                imageButton3 = (ImageButton)findViewById(R.id.imageButton03);
                imageButton3.setImageResource(R.drawable.magheroarty_beach);
                imageButton4 = (ImageButton)findViewById(R.id.imageButton04);
                imageButton4.setImageResource(R.drawable.cloughaneely_stone_small);
                break;
            case 3:
                imageButton1 = (ImageButton)findViewById(R.id.imageButton01);
                imageButton1.setImageResource(R.drawable.an_tsean_bheairic);
                imageButton2 = (ImageButton)findViewById(R.id.imageButton02);
                imageButton2.setImageResource(R.drawable.magheroarty_beach);
                imageButton3 = (ImageButton)findViewById(R.id.imageButton03);
                imageButton3.setImageResource(R.drawable.cloughaneely_stone_small);
                imageButton4 = (ImageButton)findViewById(R.id.imageButton04);
                imageButton4.setImageResource(R.drawable.bench_seat_small);
                break;
            case 4:
                imageButton1 = (ImageButton)findViewById(R.id.imageButton01);
                imageButton1.setImageResource(R.drawable.magheroarty_beach);
                imageButton2 = (ImageButton)findViewById(R.id.imageButton02);
                imageButton2.setImageResource(R.drawable.cloughaneely_stone_small);
                imageButton3 = (ImageButton)findViewById(R.id.imageButton03);
                imageButton3.setImageResource(R.drawable.bench_seat_small);
                imageButton4 = (ImageButton)findViewById(R.id.imageButton04);
                imageButton4.setImageResource(R.drawable.an_tsean_bheairic);
                break;


        }
        */

        final ImageButton img1 = (ImageButton)findViewById(R.id.imageButton01);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, ScrollerImageDisplay.class);
                intent.putExtra("ImageName", R.drawable.cloughaneely_stone);
                startActivity(intent);

            }
        });

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(final int groupPosition) {
                int len = expListView.getChildCount();
                Log.i("child count", String.valueOf(len));
                for (int i = 0; i < 7; i++) {
                    if (i != groupPosition) {
                        expListView.collapseGroup(i);

                    }
                }

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        expListView.smoothScrollToPosition(groupPosition);
                    }
                }, 500);


            }





        });





        expListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {



                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("The Cloughaneely Stone")) {
                    Intent intent = new Intent(MainActivity.this, cloughaneely_stone_activity.class);
                    //intent.putExtra("name", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                    MainActivity.this.startActivity(intent);
                }
                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Tullaghobegley Graveyard")) {
                    Intent intent = new Intent(MainActivity.this, tullaghobegley_layout.class);
                    //intent.putExtra("name", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                    MainActivity.this.startActivity(intent);
                }
                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Ballyconnell House")) {
                    Intent intent = new Intent(MainActivity.this, activity_ballyconnell_house.class);
                    //intent.putExtra("name", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                    MainActivity.this.startActivity(intent);
                }
                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Ray Church")) {
                    Intent intent = new Intent(MainActivity.this, ray_church.class);
                    //intent.putExtra("name", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                    MainActivity.this.startActivity(intent);
                }
                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Bridge of Tears")) {
                    Intent intent = new Intent(MainActivity.this, bridge_of_tears.class);
                    //intent.putExtra("name", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                    MainActivity.this.startActivity(intent);
                }
                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Begley\'s Kneeling Stone")) {
                    Intent intent = new Intent(MainActivity.this, begleys_kneeling_stone.class);
                    //intent.putExtra("name", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                    MainActivity.this.startActivity(intent);
                }
                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Portal Dolmen")) {
                    Intent intent = new Intent(MainActivity.this, portal_dolmen.class);
                    //intent.putExtra("name", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                    MainActivity.this.startActivity(intent);
                }
                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Home of Micí Mac Gabhann")) {
                    Intent intent = new Intent(MainActivity.this, teach_mici_mac_gabhann.class);
                    //intent.putExtra("name", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                    MainActivity.this.startActivity(intent);
                }
                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Castle Bawne")) {
                    Intent intent = new Intent(MainActivity.this, castle_bawne.class);
                    //intent.putExtra("name", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                    MainActivity.this.startActivity(intent);
                }

                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Mangan Coaches")) {
                    Intent intent = new Intent(MainActivity.this, mangan_bus.class);
                    //intent.putExtra("name", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                    MainActivity.this.startActivity(intent);
                }

                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Ards Forest Park")) {
                    Intent intent = new Intent(MainActivity.this, ards_forest_park.class);
                    //intent.putExtra("name", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                    MainActivity.this.startActivity(intent);
                }
                if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Glenveagh National Park")) {
                    Intent intent = new Intent(MainActivity.this, glenveagh_national_park.class);
                    //intent.putExtra("name", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                    MainActivity.this.startActivity(intent);
                }
                return false;
            }
        });


        // some children were unclickable after dialling number
        //expListView.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        /*expListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
            }
        });
        */


    }



    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Attractions");
        listDataHeader.add("Entertainment");
        listDataHeader.add("History & Heritage");
        listDataHeader.add("Natural Beauty");
        listDataHeader.add("Accomodation"); //now showing
        listDataHeader.add("Bus Services");
        listDataHeader.add("Taxi Services");


        // Adding child data
        List<String> attractions = new ArrayList<String>();
        attractions.add("An tSean Bheairic");
        attractions.add("Glenveagh National Park");
        attractions.add("Dunlewey Lakeside Centre");
        attractions.add("Ards Forest Park");

        List<String> entertainment = new ArrayList<String>();
        entertainment.add("Teach Bhillie");
        entertainment.add("The Loft Bar");
        entertainment.add("An tSean Bheairic");



        List<String> historyHeritage = new ArrayList<String>();
        historyHeritage.add("The Cloughaneely Stone");
        historyHeritage.add("Tullaghobegley Graveyard");
        historyHeritage.add("Ballyconnell House");
        historyHeritage.add("Ray Church");
        historyHeritage.add("Bridge of Tears");
        historyHeritage.add("Begley's Kneeling Stone");
        historyHeritage.add("Portal Dolmen");
        historyHeritage.add("Home of Micí Mac Gabhann");
        historyHeritage.add("Castle Bawne");

        List<String> naturalBeauty = new ArrayList<String>();
        naturalBeauty.add("Errigal");
        naturalBeauty.add("Muckish");
        naturalBeauty.add("Drumnatinney Beach");


        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Óstán Loch Altan");
        nowShowing.add("Arasáin Bhalor Self-catering apts.");
        nowShowing.add("Corcreggan Mill Hostel");
        nowShowing.add("Dunlewey Hostel");


        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Mangan Coaches");
        comingSoon.add("John McGinley Coaches");
        comingSoon.add("Bus Feda");
        comingSoon.add("Patrick Gallagher");

        List<String> taxiServices = new ArrayList<String>();
        taxiServices.add("PR Cabs");
        taxiServices.add("Sweeney's Taxi");
        taxiServices.add("Fast Cabs");



        listDataChild.put(listDataHeader.get(0), attractions); // Header, Child data
        listDataChild.put(listDataHeader.get(1), entertainment);
        listDataChild.put(listDataHeader.get(2), historyHeritage);
        listDataChild.put(listDataHeader.get(3), naturalBeauty);
        listDataChild.put(listDataHeader.get(4), nowShowing);
        listDataChild.put(listDataHeader.get(5), comingSoon);
        listDataChild.put(listDataHeader.get(6), taxiServices);




    }
}