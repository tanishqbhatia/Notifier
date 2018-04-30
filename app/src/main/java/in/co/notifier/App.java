package in.co.notifier;

import android.app.Application;
import android.content.ContextWrapper;

import in.co.notifier.utils.methods.AppMethods;
import in.co.notifier.utils.prefs.Prefs;

public class App extends Application {

    private App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = initApp();
        initPrefs();
    }

    public synchronized App initApp() {
        if (instance == null) {
            instance = this;
            AppMethods.showLog("App", "get()", "Initialized instance.");
        }
        return instance;
    }

    private void initPrefs() {
        new Prefs.Builder()
                .setContext(instance)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
        AppMethods.showLog("App", "initPrefs()", "Built prefs.");
    }
}
