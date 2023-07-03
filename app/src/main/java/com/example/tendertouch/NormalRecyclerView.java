package com.example.tendertouch;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Description of NormalRecyclerView
 * <p>
 * Auto-generated class for XML file: NormalRecyclerView
 */
public class NormalRecyclerView extends AppCompatActivity {

    RecyclerView recyclerview;
    private UsersAdapter adapter;
    private ArrayList<Users> userList;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.normalrecycler);

        recyclerview = findViewById (R.id.recycler_view);
        recyclerview.setLayoutManager (new LinearLayoutManager (this));
        userList = new ArrayList<> ();
        adapter = new UsersAdapter (this, userList);
        recyclerview.setAdapter (adapter);
        recyclerview.addItemDecoration (new DividerItemDecoration (this,
                LinearLayoutManager.VERTICAL));

        createListData ();
    }

    // This is the method for the recycler view
    // This is where we will put the adapter
    public void createListData(){

        Users user = new Users ("Nigeria", 150, 100, 10);
        userList.add (user);
    }
}
