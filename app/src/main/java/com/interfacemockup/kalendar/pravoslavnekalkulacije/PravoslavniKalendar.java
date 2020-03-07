package com.interfacemockup.kalendar.pravoslavnekalkulacije;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import androidx.annotation.RequiresApi;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class PravoslavniKalendar {

    private Calendar _cal   = GregorianCalendar.getInstance();
    private int      _broj  = 0;



    private static final PravoslavniKalendar instance = new PravoslavniKalendar();
    PravoslavniKalendar() { }
    public static PravoslavniKalendar getInstance(){
        return instance;
    }







    public Date setStariDatum(int counter) {
        Calendar cal   = GregorianCalendar.getInstance();
        cal.add(Calendar.DATE, -13 + counter); // oduzima 13 dana
        return cal.getTime();
    }

    public boolean prestupnaGodina(){
        Calendar cal   = GregorianCalendar.getInstance();
        return cal.isLenient();
    }


    public Date getNovidatum(int counter){
        Calendar cal   = GregorianCalendar.getInstance();
        Date danas = cal.getTime();
        cal.add(Calendar.DATE, counter);
        return cal.getTime();
    }



    //Pice datum umanjen ili uvecan za broj dana izrazenim u counteru
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int vratiBrojGodine(int counter){
        String pattern = "yyyy";
        Date novidatum = this.getNovidatum(counter);
        Locale locale = new Locale("sr", "SR");
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
        String date = sdf.format(novidatum);
        int broj = Integer.parseInt(date);
        return broj;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int vratiBrojDana(int counter){
        String pattern = "D";
        Date novidatum = this.getNovidatum(counter);
        Locale locale = new Locale("sr", "SR");
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
        String date = sdf.format(novidatum);
        int broj = Integer.parseInt(date);
        return broj;
    }


    public int getRedniBrojDanaUGodini(int counter){
        Calendar cal   = GregorianCalendar.getInstance();
        cal.set(Calendar.YEAR, getGodinu(counter));
        cal.getTime();

        _broj = cal.get(Calendar.DAY_OF_YEAR) + counter;
        return _broj;
    }


    public int getGodinu(int counter){
        Date datum = getNovidatum(counter);
        String pattern = "yyyy";
        Locale locale = new Locale("sr", "SR");
        SimpleDateFormat godina = new SimpleDateFormat(pattern, locale);
        String god = godina.format(datum);
        return Integer.parseInt(god);
    }


// TODO: OVO JE OK ZA SADA
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int getRBDanauNedelji(int counter){
        Date xyz = getNovidatum(counter);
        String pattern = "e";
        Locale locale = new Locale("sr", "SR");
        SimpleDateFormat rb_DanuNedelji = new SimpleDateFormat(pattern, locale);
        String rbDan = rb_DanuNedelji.format(xyz);
        return Integer.parseInt(rbDan);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean nedeljaJe(int counter){
        return getRBDanauNedelji(counter) == 7;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean sredaJe(int counter){
        return getRBDanauNedelji(counter) == 3;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean petakJe(int counter){
        return getRBDanauNedelji(counter) == 5;
    }




}
