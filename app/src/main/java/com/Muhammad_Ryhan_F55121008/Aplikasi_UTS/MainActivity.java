package com.Muhammad_Ryhan_F55121008.Aplikasi_UTS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] datadescription;
    private TypedArray dataPhoto;
    private FriendsAdapter adapter;
    private ArrayList<Friends> friend;

    private String [] dataname = {"Ryhan", "Iwank", "Riski", "Rian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new FriendsAdapter(this);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, friend.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int Position, long id) {
                if (Position==0){
                    startActivity(new Intent(MainActivity.this, ryhan.class));
                }
                else if (Position==1){
                    startActivity(new Intent(MainActivity.this, iwank.class));
                }
                else if (Position==2){
                    startActivity(new Intent(MainActivity.this, riski.class));
                }
                else if (Position==3){
                    startActivity(new Intent(MainActivity.this, rian.class));
                }
            }
        });
    }
    private void prepare() {
        dataName =   getResources().getStringArray(R.array.data_nama);
        datadescription =    getResources().getStringArray(R.array.data_deskripsi);
        dataPhoto =   getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        friend = new ArrayList<>();
        for (int i   = 0; i < dataName.length; i++) {
            Friends friends = new Friends ();
            friends.setPhoto(dataPhoto.getResourceId(i, -1));
            friends.setName(dataName[i]);
            friends.setDescription(datadescription[i]);
            friend.add(friends);
        }
        adapter.setFriend(friend);
    }
}