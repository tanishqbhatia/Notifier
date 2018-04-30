package in.co.notifier.utils.prefs;

import in.co.notifier.utils.cons.PrefsCons;

public class PrefsMethods {
    public static void setIdentified() {
        Prefs.putBoolean(PrefsCons.IDENTIFIED, true);
    }

    public static void setUnidentified() {
        Prefs.putBoolean(PrefsCons.IDENTIFIED, false);
    }

    public static Boolean isIdentified() {
        return Prefs.getBoolean(PrefsCons.IDENTIFIED, false);
    }
}
