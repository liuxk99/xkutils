package com.xancl.xkutils.installer;

import android.content.Context;
import android.content.Intent;

import java.io.File;

public interface Installer {
    File getStorageDir(Context context);
    void install(Context context, File apkFile);
    void modifyShareIntent(Intent intent, Context context, File fileName);
}
