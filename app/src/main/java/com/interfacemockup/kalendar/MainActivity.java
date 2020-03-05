package com.interfacemockup.kalendar;


import android.app.Activity;
import android.app.usage.UsageEvents;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.util.EventLog;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavnaIkona;
import com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavniGregorijanskiDatumLabel;
import com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavniKalendar;
import com.interfacemockup.kalendar.pravoslavnekalkulacije.PravoslavniPostLabel;

public class MainActivity extends AppCompatActivity {

    private PravoslavniPostLabel _postLabel;
    private PravoslavniGregorijanskiDatumLabel _gregorijanskiDatumLabel;
    private PravoslavnaIkona _ikona;
    private View _view;
    private int rb_danaUgodini = 0;
    private Calendar _calendar;
    private int _counter = 2;
    private PravoslavniKalendar shared_kalendar_instance;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _calendar = GregorianCalendar.getInstance();
        rb_danaUgodini = _calendar.get(Calendar.DAY_OF_YEAR)-1;

        shared_kalendar_instance = PravoslavniKalendar.getInstance();
        rb_danaUgodini = shared_kalendar_instance.rbDanaUGodini();

        _view = (View)findViewById(R.id.bgView);
        _postLabel = (PravoslavniPostLabel)findViewById(R.id.idPostLabe);

        _gregorijanskiDatumLabel = (PravoslavniGregorijanskiDatumLabel)findViewById(R.id.idGregorijanskiDatumLabel);
        _gregorijanskiDatumLabel.setTekst(_counter);
        _gregorijanskiDatumLabel.setBojuTexta(_counter);

        _ikona = (PravoslavnaIkona)findViewById(R.id.idIkona);
        _ikona.setIkonu(4);

        setSwipes(rb_danaUgodini);



    }




    /*  TODO: SWIPE GESTURES AND ANIMATIONS     */
    public void setSwipes(int rb_dana_u_god){
        _view.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){


            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                YoYo.with(Techniques.ZoomInRight)
                        .duration(650)
                        .repeat(0)
                        .playOn(_ikona);
                rb_danaUgodini = rb_danaUgodini - 1;

            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                YoYo.with(Techniques.ZoomInLeft)
                        .duration(650)
                        .repeat(0)
                        .playOn(_ikona);
                rb_danaUgodini = rb_danaUgodini + 1;
            }

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                YoYo.with(Techniques.ZoomIn)
                        .duration(550)
                        .repeat(0)
                        .playOn(_ikona);
                rb_danaUgodini = rb_danaUgodini - 1;
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                YoYo.with(Techniques.ZoomIn)
                        .duration(550)
                        .repeat(0)
                        .playOn(_ikona);
            }

        });
    }

}
