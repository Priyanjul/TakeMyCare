package hall.medical.goyal.takemycare;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LanguageActivity extends Activity {

    TextView txt_Echoosel, txt_Hchoosel, txt_english, txt_hindi;
    Typeface regular, bold;
    Button btn_start;
    ImageView img_eselect, img_hselect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        /*getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );*/
        txt_Echoosel = findViewById(R.id.txt_Echoosel);
        txt_Hchoosel = findViewById(R.id.txt_Hchoosel);
        txt_english = findViewById(R.id.txt_english);
        txt_hindi = findViewById(R.id.txt_hindi);
        btn_start = findViewById(R.id.btn_start);
        img_eselect = findViewById(R.id.img_eselect);
        img_hselect = findViewById(R.id.img_hselect);

        regular = Typeface.createFromAsset(getAssets(),  "fonts/Ubuntu-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(),  "fonts/Ubuntu-Bold.ttf");

        txt_Echoosel.setTypeface(regular);
        txt_Hchoosel.setTypeface(regular);
        txt_english.setTypeface(bold);
        txt_hindi.setTypeface(bold);
        btn_start.setTypeface(bold);


        txt_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle("eng");
            }
        });

        txt_hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle("hin");
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SwipeScreen.class);
                startActivity(i);
            }
        });


    }

    private void toggle(String lang){

        btn_start.setVisibility(View.VISIBLE);
        if(lang.equals("eng")){
            txt_english.setTextColor(getResources().getColor(R.color.colorAccent));
            img_eselect.setVisibility(View.VISIBLE);
            img_eselect.setBackgroundResource(R.drawable.ic_select);

            txt_hindi.setTextColor(getResources().getColor(R.color.fadedAccent));
            img_hselect.setVisibility(View.GONE);
        }

        else {
            txt_hindi.setTextColor(getResources().getColor(R.color.colorAccent));
            img_hselect.setVisibility(View.VISIBLE);
            img_hselect.setBackgroundResource(R.drawable.ic_select);

            txt_english.setTextColor(getResources().getColor(R.color.fadedAccent));
            img_eselect.setVisibility(View.GONE);
        }


    }
}
