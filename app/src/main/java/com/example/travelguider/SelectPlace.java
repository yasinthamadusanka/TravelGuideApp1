package com.example.travelguider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.MyModel;

public class SelectPlace extends AppCompatActivity implements RecyclerViewInterface{

    private RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    private List<MyModel> myModels;
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_place);

        search = (SearchView) findViewById(R.id.searchView);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(SelectPlace.this));

        myModels = new ArrayList<>();
        myModels.add(new MyModel(R.drawable.a,"Beaches", "1.Mirissa", "2.Unawatuna", "3.Arugambay", "4.Nilaveli","Mirissa Beach is situated on the southern, in the Matara District. It has golden sands, swaying palm trees, crystal-clear waters. It is a opportunity for whale watching.\n\nUnawatuna Beach is part of the Southern Province of Sri Lanka, nestled between Galle and Matara. It boasts a crescent-shaped coastline with golden sands and clear waters. \n\nArugam Bay is a popular beach destination located on the southeast coast of Sri Lanka. It  is one of the world's top surfing destinations. \n\nNilaveli Beach is located on the east coast of Sri Lanka, in the Trincomalee District.  Its long stretches of soft, white sandy beaches."));
        myModels.add(new MyModel(R.drawable.b,"National Parks", "1.Yala", "2.Udawalawa", "3.Minneriya", "4.Wilpaththuwa","Yala is situated in the southeast corner of Sri Lanka.  It's home to a wide range of wildlife. \n\nUdawalawe, the nearest coastal area is Hambantota.  Its large population of wild Asian elephants. It plays a crucial role in the conservation and research of Sri Lanka's natural heritage. \n\nMinneriya is located inland in Sri Lanka. Its Gathering of elephants, where large herds of Asian elephants congregate around the Minneriya Tank during the dry season. \n\nWilpattu National Park is located on the northwest coast of Sri Lanka, in the North Western and North Central provinces. It is renowned for its healthy leopard population."));
        myModels.add(new MyModel(R.drawable.c,"Hill Stations", "1.NuwaraEliya", "2.Ella", "3.Haputhale", "4.Horton Plains","Nuwara Eliya hill station is located in the central highlands of Sri Lanka. It is renowned for its picturesque landscapes, lush green tea plantations, and cool climate. \n\nElla is a picturesque hill station located in the Badulla District of Sri Lanka. It  is renowned for its breathtaking landscapes. \n\nHaputale is a charming hill station located in the Badulla District of Sri Lanka. It is renowned for its stunning natural beauty and cool climate. \n\nHorton Plains is a unique and ecologically important hill station located in the central highlands of Sri Lanka. It is a designated UNESCO World Heritage Site due to its rich biodiversity."));
        myModels.add(new MyModel(R.drawable.d,"Islands", "1.Pigeon", "2.Mannar", "3.Kalpitiya", "4.Peninsula","Pigeon Island is located off the coast of Nilaveli, a coastal resort town in the Eastern Province of Sri Lanka. It is renowned for its rich marine biodiversity. \n\nMannar island located in the northern part of Sri Lanka. It is famous for its ancient Baobab trees. \n\nKalpitiya is located on the northwest coast of Sri Lanka, in the Puttalam District. It is renowned for its water sports activities \n\nThe most prominent peninsula in Sri Lanka is the Jaffna Peninsula. Located in the northern part of the island, it is surrounded by the Palk Strait to the west and the Bay of Bengal to the east."));
        myModels.add(new MyModel(R.drawable.e,"Tea Plantations", "1.NuwaraEliya", "2.Ella", "3.Kandy","","Nuwara Eliya is a region in Sri Lanka known for its picturesque tea plantations. Visiting the tea plantations in Nuwara Eliya offers a unique cultural experience. This climate is quite distinct from the rest of Sri Lanka and contributes to the unique flavor profile of the tea produced in the region. \n\nElla Tea Plantation is one of the most renowned tea estates in Sri Lanka. The Ella Tea Plantation is part of this rich heritage and contributes significantly to the country's tea industry. \n\nKandy Tea Plantation is one of the most significant tea-producing regions in Sri Lanka.  The tea plantations are set against a backdrop of rolling hills and lush greenery, providing a picturesque landscape that attracts tourists from around the world."));
        myModels.add(new MyModel(R.drawable.f,"Historical Places", "1.Kandy", "2.Sigiriya", "3.Anuradhepure", "4.Polonnaruwa","Kandy is a significant historical city in Sri Lanka with several important cultural and historical landmarks. Temple of the Tooth (Sri Dalada Maligawa) is one of the most sacred Buddhist temples in the world. \n\nSigiriya is an ancient rock fortress located in the central Matale District of Sri Lanka. Sigiriya is renowned for its advanced urban planning, sophisticated architecture, and hydraulic engineering. \n\nAnuradhapura is a significant historical city in Sri Lanka. It was the first capital of ancient Sri Lanka. \n\nPolonnaruwa is an ancient city in Sri Lanka that served as the second capital of the Sinhalese Kingdom from the 11th to the 13th century. It is renowned for its impressive and well-preserved architectural structures."));
        myModels.add(new MyModel(R.drawable.g,"Adventure Parks", "1.Kithulgala", "2.Kalpitiya", "3.Ella", "4.Mirissa","Kithulgala Adventure Park in Sri Lanka is a popular destination known for its wide range of outdoor activities and natural beauty. Kithulgala is renowned for its thrilling white-water rafting experiences. \n\nKalpitiya Adventure Park in Sri Lanka is a popular destination for adventure enthusiasts.  Kalpitiya is renowned for its ideal wind conditions, making it one of the best places in Asia for kitesurfing and windsurfing. \n\nElla is known for its stunning landscapes and one of the popular activities is hiking to Ella Rock. It offers breathtaking views of the Ella Gap and surrounding areas. \n\nMirissa Adventure Park is a unique adventure park situated in the heart of Mirissa. It is the first adventure park in the southern province of Sri Lanka and offers a variety of activities."));
        myModels.add(new MyModel(R.drawable.h,"Waterfalls", "1.Bambarakanda", "2.Diyaluma", "3.Ravana", "4.devon","Bambarakanda is the tallest waterfall in Sri Lanka. It is a truly impressive sight. The falls cascade down a sheer cliff face for a total of 263 meters. \n\nDiyaluma is the second-highest waterfall in Sri Lanka, plunging down 220 meters from a rocky cliff. It is located near the town of Haputale and is a popular spot for swimming and hiking. \n\nRavana is named after the legendary demon king Ravana, who is said to have bathed in its waters. It is located near the town of Ella and is a popular tourist destination. \n\nDevon is located near the town of Talawakele and is the ninth-highest waterfall in Sri Lanka. It is a popular spot for swimming and picnicking."));

        adapter = new MyAdapter(SelectPlace.this,myModels,this);
        recyclerView.setAdapter(adapter);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

    }

    private void filter(String newText) {
        List<MyModel> filteredList = new ArrayList<>();
        for (MyModel item : myModels){
            if(item.getTopic().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }
        }
        ((MyAdapter) adapter).filterList(filteredList);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(SelectPlace.this, DetailsPage.class);

        intent.putExtra("TOPIC",myModels.get(position).getTopic());
        intent.putExtra("IMAGE",myModels.get(position).getImage());
        intent.putExtra("NAME1",myModels.get(position).getCategory1());
        intent.putExtra("NAME2",myModels.get(position).getCategory2());
        intent.putExtra("NAME3",myModels.get(position).getCategory3());
        intent.putExtra("NAME4",myModels.get(position).getCategory4());
        intent.putExtra("DESC",myModels.get(position).getDesc());

        startActivity(intent);
    }
}