package in.co.notifier.modules.initial.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import in.co.notifier.R;
import in.co.notifier.modules.identification.activities.LoginActivity;
import in.co.notifier.utils.methods.AppMethods;
import in.co.notifier.utils.prefs.PrefsMethods;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (!PrefsMethods.isIdentified())
            AppMethods.launchOnly(this, IntroductionActivity.class);
        else AppMethods.launchOnly(this, LoginActivity.class);
    }
}
