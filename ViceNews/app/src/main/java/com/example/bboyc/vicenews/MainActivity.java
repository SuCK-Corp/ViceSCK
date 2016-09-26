package com.example.bboyc.vicenews;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab1, fab2, fab3, fab4, fab;
    TextView textView8, textView3, textView4, textView5, textView6;

    Animation fab_close, fab_open, rotate_anticlockwise, rotate_clockwise;
    boolean isOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TOOLBAR
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);






        //ANIMATION LAYOUTS
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        rotate_anticlockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);
        rotate_clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);

        //MY FLOATING ACTION BUTTONS
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab4 = (FloatingActionButton) findViewById(R.id.fab4);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        //TEXT FABS
        textView3 = (TextView) findViewById(R.id.textView3);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen)
                {
                    fab.startAnimation(rotate_anticlockwise);

                    fab1.startAnimation(fab_close);
                    fab4.startAnimation(fab_close);
                    fab3.startAnimation(fab_close);
                    fab2.startAnimation(fab_close);

                    textView3.startAnimation(fab_close);
                    textView4.startAnimation(fab_close);
                    textView5.startAnimation(fab_close);
                    textView6.startAnimation(fab_close);
                    textView8.startAnimation(fab_close);

                    fab1.setClickable(false);
                    fab4.setClickable(false);
                    fab3.setClickable(false);
                    fab2.setClickable(false);

                    isOpen = false;

                }
                else
                {
                    fab.startAnimation(rotate_clockwise);

                    fab1.startAnimation(fab_open);
                    fab4.startAnimation(fab_open);
                    fab3.startAnimation(fab_open);
                    fab2.startAnimation(fab_open);

                    textView3.startAnimation(fab_open);
                    textView4.startAnimation(fab_open);
                    textView5.startAnimation(fab_open);
                    textView6.startAnimation(fab_open);
                    textView8.startAnimation(fab_open);

                    fab1.setClickable(true);
                    fab4.setClickable(true);
                    fab3.setClickable(true);
                    fab2.setClickable(true);

                    isOpen = true;
                }
            }
        });
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

                return true;
    }

}
