package com.example.harrys.delivcious;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import static com.example.harrys.delivcious.R.id.numksd;
import static com.example.harrys.delivcious.R.id.textView;

public class KSDInfo extends Fragment {

    ImageView hp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.info_ksd, container, false);

        hp = (ImageView) root.findViewById(R.id.hpksd);

        hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:087722775757"));
                startActivity(callIntent);
            }
        });

        return root;

    }
}
