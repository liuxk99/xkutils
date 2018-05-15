package com.xancl.xkutils.installer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.io.File;

public class InstallerM implements Installer {

    private static final String TAG = InstallerM.class.getSimpleName();

    @Override
    public File getStorageDir(Context context) {
        return context.getExternalFilesDir(null);
    }

    @Override
    public void install(Context context, File apkFile) {
        Intent apkIntent = new Intent(Intent.ACTION_VIEW);
        Uri apkUri;
        apkUri = Uri.fromFile(apkFile);
        Log.d(TAG, "uri: " + apkUri);

        apkIntent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        context.startActivity(apkIntent);
    }

    @Override
    public void modifyShareIntent(Intent intent, Context context, File fileName) {
        Uri apkUri;
        apkUri = Uri.fromFile(fileName);
        Log.d(TAG, "uri: " + apkUri);

        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
    }

}
