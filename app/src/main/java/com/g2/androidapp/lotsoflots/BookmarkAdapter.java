package com.g2.androidapp.lotsoflots;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class BookmarkAdapter extends ArrayAdapter<BookmarkData> {

    public BookmarkAdapter( Context context, int resource) {
        super(context, resource);
    }

    public BookmarkAdapter( Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    @Override
    public View getView (final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout view;
        if (convertView == null) {
            view = ((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.bookmark_list_item, parent, false));
        } else {
            view = ((LinearLayout) convertView);
        }

        TextView textView = view.findViewById(R.id.bookmark_address);
        textView.setText(getItem(position).getName());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapsActivity.class);
                intent.putExtra("BMT", getItem(position).latlng);
                getContext().startActivity(intent);

            }
        });

        return view;
    }
}
