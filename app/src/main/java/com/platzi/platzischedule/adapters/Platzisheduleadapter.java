package com.platzi.platzischedule.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.platzi.platzischedule.R;
import com.platzi.platzischedule.models.Platzitime;

import java.util.ArrayList;

/**
 * Created by thespianartist on 15/06/15.
 */
public class Platzisheduleadapter extends RecyclerView.Adapter<Platzisheduleadapter.ViewHolder>{

    private ArrayList<Platzitime> platzicourses;
    private int itemLayout;
    private Context c;

    public Platzisheduleadapter(ArrayList<Platzitime> data,  int itemLayout, Context c){

        this.platzicourses = data;
        this.itemLayout = itemLayout;
        this.c = c;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView title;
        private TextView description;

        public ViewHolder(View itemView) {

            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageRow);
            description = (TextView) itemView.findViewById(R.id.description);
            title = (TextView) itemView.findViewById(R.id.title);

        }
    }

    @Override
    public Platzisheduleadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Platzisheduleadapter.ViewHolder viewHolder, int position) {

        Platzitime  platzitime = platzicourses.get(position);

        viewHolder.title.setText(platzitime.getTitle());
        viewHolder.description.setText(platzitime.getDescription());

        if (platzitime.getImage_id()!=null) {

            switch (platzitime.getImage_id()) {

                case 1:
                    viewHolder.image.setImageResource(R.mipmap.gitgithub);
                    break;

                case 2:
                    viewHolder.image.setImageResource(R.drawable.live);
                    break;

                case 3:
                    viewHolder.image.setImageResource(R.mipmap.react);
                    break;

                case 4:
                    viewHolder.image.setImageResource(R.mipmap.marketing);
                    break;
            }

        }else{

            viewHolder.image.setImageResource(R.mipmap.react);
        }



        viewHolder.itemView.setTag(platzitime);
    }

    @Override
    public int getItemCount() {
        return this.platzicourses.size();
    }


}
