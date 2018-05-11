package com.xancl.xkutils.installer;

import android.os.Build;

public class InstallerFactory {
    public static Installer getInstance() {
        Installer installer;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            installer = new InstallerN();
        } else {
            installer = new InstallerM();
        }
        return installer;
    }
}
