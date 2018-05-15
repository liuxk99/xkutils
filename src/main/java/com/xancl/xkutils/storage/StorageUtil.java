package com.xancl.xkutils.storage;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StorageUtil {
    private static void copy(InputStream inputStream, FileOutputStream outputStream) {
        byte[] buffer = new byte[1024];
        int length = 0;
        try {
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } catch (IOException ioe) {
            /* ignore */
        }
    }

    public static boolean copyRawToFile(Context context, int resId, File fileName) {
        InputStream ips = context.getResources().openRawResource(resId);
        FileOutputStream ops;
        try {
            ops = new FileOutputStream(fileName);
            copy(ips, ops);
            try {
                ips.close();
                ops.close();
            } catch (IOException ioe) {
                /* ignore */
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
