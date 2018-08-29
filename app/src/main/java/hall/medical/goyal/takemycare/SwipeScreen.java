package hall.medical.goyal.takemycare;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SwipeScreen extends Activity {

    private ViewPager viewPager;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private SliderAdapter sliderAdapter;
    private Button btn_next, btn_prev;
    private int mCurrentPage;
    Typeface regular, bold;

    //change

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        viewPager = findViewById(R.id.slideViewPager);
        dotsLayout = findViewById(R.id.dotsLayout);

        btn_next = findViewById(R.id.btn_next);
        btn_prev = findViewById(R.id.btn_prev);

        regular = Typeface.createFromAsset(getAssets(),  "fonts/Ubuntu-Regular.ttf");
        bold = Typeface.createFromAsset(getAssets(),  "fonts/Ubuntu-Bold.ttf");

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDotdIndicator(0);

        viewPager.addOnPageChangeListener(onPageChangeListener);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(mCurrentPage + 1);
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

  /*      txt_title = findViewById(R.id.txt_title);
        txt_content = findViewById(R.id.txt_content);*/



        /*txt_title.setTypeface(regular);
        txt_content.setTypeface(regular);*/


    }

    public void addDotdIndicator(int position){

        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for(int i=0 ; i<dots.length ; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.transparenttWhite));

            dotsLayout.addView(dots[i]);
        }

        if(dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.whiteText));
            dots[position].setTextSize(40);
        }

    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotdIndicator(position);
            mCurrentPage = position;

            if(position == 0){
                btn_next.setEnabled(true);
                btn_prev.setEnabled(false);
                btn_prev.setVisibility(View.INVISIBLE);
            }
            else if( position == dots.length-1) {

                btn_next.setEnabled(true);
                btn_prev.setEnabled(true);
                btn_prev.setVisibility(View.VISIBLE);

            }
            else{
                btn_next.setEnabled(true);
                btn_prev.setEnabled(true);
                btn_prev.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
