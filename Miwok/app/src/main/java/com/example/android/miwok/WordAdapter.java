package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;
    public WordAdapter(Context context, ArrayList<Word> words,int colorResourceId) {
        super(context, 0, words);
        mColorResourceId= colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word word = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population
        TextView miwokTextView = (TextView) convertView.findViewById(R.id.miwok_text_view);
        TextView defaultTextView = (TextView) convertView.findViewById(R.id.default_text_view);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        View textContainer = convertView.findViewById(R.id.text_container);
        // Populate the data into the template view using the data object
        miwokTextView.setText(word.getmMiwokTranslation());
        defaultTextView.setText(word.getmDefaultTranslation());
        if(word.hasImage()){
            imageView.setImageResource(word.getmImageResourceId());
            // bcz views are reused so we have to do it
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        // changing color according to the activities
        int color= ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Return the completed view to render on screen
        return convertView;
    }
}
