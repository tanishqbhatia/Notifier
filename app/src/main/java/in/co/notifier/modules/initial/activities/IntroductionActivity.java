package in.co.notifier.modules.initial.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import in.co.notifier.R;
import in.co.notifier.modules.identification.activities.LoginActivity;
import in.co.notifier.utils.methods.AppMethods;


public class IntroductionActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        findViews();
        addListeners();

    }

    private void addListeners() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppMethods.launch(IntroductionActivity.this, LoginActivity.class);
            }
        });
    }

    private void findViews() {
        fab = findViewById(R.id.fab);
    }
}
