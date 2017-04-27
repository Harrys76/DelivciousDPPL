package com.example.harrys.delivcious;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    GridView gridView;
    ViewStub stubList;
    ViewStub stubGrid;
    GridViewAdapter gridViewAdapter;
    ListViewAdapter listViewAdapter;
    List<Product> productList;
    int currentViewMode = 0;

    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stubList = (ViewStub) findViewById(R.id.stub_list);
        stubGrid = (ViewStub) findViewById(R.id.stub_grid);

        stubList.inflate();
        stubGrid.inflate();

        listView = (ListView) findViewById(R.id.list1);
        gridView = (GridView) findViewById(R.id.mygridview);

        getProductList();

        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);

        listView.setOnItemClickListener(onItemClick);
        gridView.setOnItemClickListener(onItemClick);

        switchView();
    }

    public List<Product> getProductList() {

        productList = new ArrayList<>();
        productList.add(new Product(R.mipmap.kfc, "KFC (Kentucky Fried Chicken)", "Deskripsi Disini"));
        productList.add(new Product(R.mipmap.mcd, "McDonald's", "Deskripsi Disini"));
        productList.add(new Product(R.mipmap.domino, "Domino", "Deskripsi Disini"));
        productList.add(new Product(R.mipmap.phd, "PHD (Pizza Hut Delivery)", "Deskripsi Disini"));
        productList.add(new Product(R.mipmap.aw, "A&W", "Deskripsi Disini"));
        productList.add(new Product(R.mipmap.ksd, "KSD (Kedai Soe-soe Delivery)", "Deskripsi Disini"));
        productList.add(new Product(R.mipmap.hokben, "HokBen", "Deskripsi Disini"));
        productList.add(new Product(R.mipmap.recheese, "Recheese Factory", "Deskripsi Disini"));
        productList.add(new Product(R.mipmap.kfc, "KFC (Kentucky Fried Chicken)", "Deskripsi Disini"));
        productList.add(new Product(R.mipmap.kfc, "KFC (Kentucky Fried Chicken)", "Deskripsi Disini"));

        return productList;
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }
        }
    };

    private void switchView() {

        if (VIEW_MODE_LISTVIEW == currentViewMode) {
            stubList.setVisibility(View.VISIBLE);
            stubGrid.setVisibility(View.GONE);
        } else {
            stubList.setVisibility(View.GONE);
            stubGrid.setVisibility(View.VISIBLE);
        }
        setAdapters();
    }

    private void setAdapters() {

        if (VIEW_MODE_LISTVIEW == currentViewMode) {
            listViewAdapter = new ListViewAdapter(this, R.layout.baris, productList);
            listView.setAdapter(listViewAdapter);
        } else {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid, productList);
            gridView.setAdapter(gridViewAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu :
                if (VIEW_MODE_LISTVIEW == currentViewMode) {
                    currentViewMode = VIEW_MODE_GRIDVIEW;
                } else {
                    currentViewMode = VIEW_MODE_LISTVIEW;
                }

                switchView();

                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode", currentViewMode);
                editor.apply();

                break;
        }

        return true;
    }
}
