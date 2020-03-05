package com.interfacemockup.kalendar.pravoslavnekalkulacije;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class PravoslavniJulijanskiDatumLabel extends TextView {

    private PravoslavniKalendar _cal = new PravoslavniKalendar();


    public PravoslavniJulijanskiDatumLabel(Context context) {
        super(context);

    }

    public PravoslavniJulijanskiDatumLabel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setText(stariDatumText());
    }

    public PravoslavniJulijanskiDatumLabel(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PravoslavniJulijanskiDatumLabel(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private String stariDatumText(){

        return"halkooo";
    }


}
