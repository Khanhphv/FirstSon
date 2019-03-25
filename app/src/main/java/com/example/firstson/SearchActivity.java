package com.example.firstson;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    EditText edtSearch;
    TextView txtHuy;
    private RecycleItemFeaturedSearchAdapter mRecyclerViewAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview_featuredSearch);
        data = new ArrayList<>();
        data.add("Nguyễn Minh Hưng");
        data.add("Hoàng Minh Lợi");
        data.add("Nguyễn Duy Bảo");
        data.add("Nguyễn Ngọc Doanh");
        data.add("Nguyễn Phạm Thế Hà");
        data.add("Trần Anh Đức");
        data.add("Trần Minh Hải");


        mRecyclerViewAdapter = new RecycleItemFeaturedSearchAdapter(this,data);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        mRecyclerViewAdapter.setOnItemClickListener(new RecycleItemFeaturedSearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String username) {
                Toast.makeText(SearchActivity.this, username, Toast.LENGTH_SHORT).show();
            }
        });

        edtSearch = (EditText) findViewById(R.id.edtSearch);
        txtHuy = (TextView) findViewById(R.id.txtHuy);



        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Nunito-SemiBold.ttf");
        edtSearch.setTypeface(typeface);
        txtHuy.setTypeface(typeface);
    }
}
