package com.xancl.xkutils.installer;

import android.content.Context;

import java.io.File;

public interface Installer {
    File getStorageDir(Context context);
    void install(Context context, File apkFile);
}
