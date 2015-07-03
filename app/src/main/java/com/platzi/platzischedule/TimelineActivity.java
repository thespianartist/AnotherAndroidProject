package com.platzi.platzischedule;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.platzi.platzischedule.Utils.DividerItemDecoration;
import com.platzi.platzischedule.adapters.Platzisheduleadapter;
import com.platzi.platzischedule.models.Platzitime;

import java.util.ArrayList;

public class TimelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Platzi");

        loadBackdrop();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        recyclerView.setHasFixedSize(true);

        RecyclerView.ItemDecoration itemDecoration =  new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

         ArrayList<Platzitime> platzicourses = new ArrayList<>();

        Platzitime platzitime = new Platzitime();
        platzitime.setTitle("Curso Profesional de Git y Github");
        platzitime.setDescription("Hoy");
        platzitime.setImage_id(1);

        platzicourses.add(platzitime);

        Platzitime platzitime2 = new Platzitime();
        platzitime2.setTitle("Platzi Live");
        platzitime2.setDescription("1 Dia");
        platzitime2.setImage_id(2);

        platzicourses.add(platzitime2);

        Platzitime platzitime3 = new Platzitime();
        platzitime3.setTitle("Curso de Desarrollo en React");
        platzitime3.setDescription("12 Dias");
        platzitime3.setImage_id(3);

        platzicourses.add(platzitime3);

        Platzitime platzitime4 = new Platzitime();
        platzitime4.setTitle("Curso de Estrategia Digital y Marketing Online");
        platzitime4.setDescription("10 Dias");
        platzitime4.setImage_id(4);

        platzicourses.add(platzitime4);





        recyclerView.setAdapter(new Platzisheduleadapter(platzicourses, R.layout.row, this));

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);


    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(R.drawable.astronauta).centerCrop().into(imageView);
    }
}
