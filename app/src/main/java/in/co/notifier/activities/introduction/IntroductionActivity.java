package in.co.notifier.activities.introduction;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import in.co.notifier.R;
import in.co.notifier.activities.introduction.parallax_viewpager.ParallaxViewPager;
import in.co.notifier.adapters.IntroductionViewPagerAdapter;

public class IntroductionActivity extends AppCompatActivity {

    private ParallaxViewPager introductionVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        findViews();
        addListeners();
        introductionVp.addMovementToView(R.id.appNameTv, 0.8f);
        introductionVp.addMovementToView(R.id.introImageIv, 0.0f);
        introductionVp.addMovementToView(R.id.continueLoginBtn, 0.0f);
        introductionVp.setAdapter(new IntroductionViewPagerAdapter(getLayoutInflater()));
    }

    private void addListeners() {
        introductionVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void findViews() {
        introductionVp = findViewById(R.id.introductionVp);
    }
}
