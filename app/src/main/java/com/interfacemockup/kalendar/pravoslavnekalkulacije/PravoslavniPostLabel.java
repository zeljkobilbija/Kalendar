package com.interfacemockup.kalendar.pravoslavnekalkulacije;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class PravoslavniPostLabel extends TextView {

    private PravoslavniKalendar sharedKalendar = PravoslavniKalendar.getInstance();
    private PravoslavneKonstante konstante = new PravoslavneKonstante();

    public PravoslavniPostLabel(Context context) {
        super(context);
    }

    public PravoslavniPostLabel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PravoslavniPostLabel(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PravoslavniPostLabel(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setPostLabelColor(int counter){
        //this.setTextColor(Color.parseColor("#BC9432"));
        this.setTextColor(Color.parseColor("#F69206"));
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setPostLabelText(int counter){
        int rbDanauGodini = sharedKalendar.getRedniBrojDanaUGodini(counter);
        konstante.izracunajVaskrs(counter);

        if (rbDanauGodini > 331 || rbDanauGodini < 7) {
            this.setText("Божићни пост");
        }else if (rbDanauGodini > konstante.vaskrsMali && rbDanauGodini < konstante.vaskrsVeliki){
            this.setText("Васкршњи пост");
        }else if (rbDanauGodini > konstante.petrovskiPostMin && rbDanauGodini < konstante.petrovskiPostMax){
            this.setText("Петровски пост");
        }else if (rbDanauGodini > 225 && rbDanauGodini < 240){
            this.setText("Госпојински пост");
        }else {
            if ((sharedKalendar.petakJe(counter)) || (sharedKalendar.sredaJe(counter))) {
                this.setText("Пост");
            }
            else {
                this.setText(" ");
            }
        }
    }


}
