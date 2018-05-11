package com.xancl.xkutils.installer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.util.Log;

import java.io.File;

public class InstallerN implements Installer {

    private static final String TAG = InstallerN.class.getSimpleName();

    @Override
    public File getStorageDir(Context context) {
        File apkDir = null;
        {
            final File thumbsDir = new File(context.getFilesDir(), "thumbs/");
            if (thumbsDir.exists()) {
                apkDir = thumbsDir;
            } else {
                boolean res = thumbsDir.mkdirs();
                if (res) {
                    apkDir = thumbsDir;
                }
            }
        }

        return apkDir;
    }

    @Override
    public void install(Context context, File apkFile) {
        final String authority = context.getPackageName() + ".fileprovider";
        Intent apkIntent = new Intent(Intent.ACTION_VIEW);
        Uri apkUri;
        apkIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        apkUri = FileProvider.getUriForFile(context, authority, apkFile);
        Log.d(TAG, "uri: " + apkUri);

        apkIntent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        context.startActivity(apkIntent);

    }

}
