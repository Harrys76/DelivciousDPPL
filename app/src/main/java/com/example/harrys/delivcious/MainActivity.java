package com.example.harrys.delivcious;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.harrys.delivcious.R.layout.baris;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] judul;
    String[] deskripsi;
    int[] imgs = {R.mipmap.kfc, R.mipmap.mcd, R.mipmap.phd, R.mipmap.domino, R.mipmap.ksd, R.mipmap.recheese, R.mipmap.aw, R.mipmap.hokben};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        judul = res.getStringArray(R.array.judul);
        deskripsi = res.getStringArray(R.array.deskripsi);
        list = (ListView) findViewById(R.id.list1);
        final MyAdapter adapter = new MyAdapter(this, judul, imgs, deskripsi);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i) {
                    case 0 :
                        break;
                    case 1 :
                        break;
                    case 2 :
                        break;
                    case 3 :
                        break;
                    case 4 :
                        break;
                    case 5 :
                        break;
                    case 6 :
                        break;
                    case 7 :
                        break;
                    case 8 :
                        break;
                    case 9 :
                        break;
                }
            }
        });
    }

    private static class ViewHolder {
        ImageView myImage;
        TextView myTitle;
        TextView myDesc;
    }

    private class MyAdapter extends ArrayAdapter<String> {
        Context context;
        int[] images;
        String[] mJudul;
        String[] mDeskripsi;

        MyAdapter (Context c, String[] judul, int imgs[], String[] deskripsi) {
            super(c, baris, R.id.nama_deliv, judul);
            this.context = c;
            this.images = imgs;
            this.mJudul = judul;
            this.mDeskripsi = deskripsi;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.baris,parent,false);
                holder = new ViewHolder();
                holder.myImage = (ImageView) convertView.findViewById(R.id.gambar);
                holder.myTitle = (TextView) convertView.findViewById(R.id.nama_deliv);
                holder.myDesc = (TextView) convertView.findViewById(R.id.deskripsi);

                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.myImage.setImageResource(images[position]);
            holder.myTitle.setText(mJudul[position]);
            holder.myDesc.setText(mDeskripsi[position]);

            return convertView;
        }
    }
}
