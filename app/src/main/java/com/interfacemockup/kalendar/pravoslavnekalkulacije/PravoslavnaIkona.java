package com.interfacemockup.kalendar.pravoslavnekalkulacije;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.interfacemockup.kalendar.R;


public class PravoslavnaIkona extends ImageView {


    public PravoslavnaIkona(Context context) {
        super(context);
    }

    public PravoslavnaIkona(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //this.setBackgroundColor(Color.parseColor("#F69206"));
        //this.setPadding(10,10,10, 10);
    }

    public PravoslavnaIkona(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PravoslavnaIkona(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void setIkonu(int redni_broj_dana_u_godini){
        this.setImageResource(R.drawable.cc);
    }



}
