package com.interfacemockup.kalendar.pravoslavnekalkulacije;

import android.content.Context;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class PravoslavniGregorijanskiDatumLabel extends TextView {

    private PravoslavniKalendar kalendar = new PravoslavniKalendar();
    private Calendar _cal = GregorianCalendar.getInstance();

    public PravoslavniGregorijanskiDatumLabel(Context context) {
        super(context);


    }

    public PravoslavniGregorijanskiDatumLabel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


    }


    public void setTekst(int counter){
        String pattern = "d. MMM yyyy.";
        String paternDan = "EEEE ";

        _cal.add(Calendar.DATE, counter);
        Date izmenjenidatum = _cal.getTime();

        Locale locale = new Locale("sr", "SR");

        SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
        SimpleDateFormat danFormat = new SimpleDateFormat(paternDan, locale);

        String date = sdf.format(izmenjenidatum);
        String danDate = danFormat.format(izmenjenidatum);

        String dd = danDate + date + " god.";
        //return dd;
        this.setText(dd);
    }


    public void setBojuTexta(int counter){

        if (kalendar.rbDanauNedelji(counter) == 7){
            this.setTextColor(Color.parseColor("#CF331F"));
        }else {
            this.setTextColor(Color.parseColor("#CCD4D4"));
        }

    }



}