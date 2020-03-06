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
    private Date     _danas = new Date();
    private int      _broj  = 0;



    private static final PravoslavniKalendar instance = new PravoslavniKalendar();
    PravoslavniKalendar() { }
    public static PravoslavniKalendar getInstance(){
        return instance;
    }







    public Date setStariDatum(int counter) {
        _danas = _cal.getTime();
        _cal.add(Calendar.DATE, -13 + counter); // oduzima 13 dana
        return _cal.getTime();
    }

    public boolean prestupnaGodina(){
        _cal = GregorianCalendar.getInstance();
        return _cal.isLenient();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String setNoviDatumLabel(int counter) {

        String pattern = "d. MMM yyyy.";
        String paternDan = "EEEE ";

        _cal.add(Calendar.DATE, counter);
        Date izmenjenidatum = _cal.getTime();

        Locale locale = new Locale("sr", "SR");

        SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
        SimpleDateFormat danFormat = new SimpleDateFormat(paternDan, locale);

        String date = sdf.format(izmenjenidatum);
        String danDate = danFormat.format(izmenjenidatum);

        return danDate + date + " god.";
    }

    public Date setNovidatum(int counter){
        Date danas = _cal.getTime();
        _cal.add(Calendar.DATE, counter);
        return _cal.getTime();
    }

    public int getRedniBrojDanaUGodini(Date izmenjeniDAtum){
        return  5;
    }

    public int getRedniBrojDanaUGodini(){
        _broj = _cal.get(Calendar.DAY_OF_YEAR) - 1;
        return _broj;
    }




    @RequiresApi(api = Build.VERSION_CODES.N)
    public int rbDanauNedelji(int _counter){
        Date danas = _cal.getTime();
        _cal.add(Calendar.DATE, _counter);
        Date izmenjenidatum = _cal.getTime();
        String patern = "e";
        Locale locale = new Locale("sr", "SR");

        SimpleDateFormat rbDanuNedelji = new SimpleDateFormat(patern, locale);
        String rbDan = rbDanuNedelji.format(izmenjenidatum);
        return Integer.parseInt(rbDan);
    }

    public boolean nedeljaJe(Date izmenjeniDAtum){

        return true;

    }

}
