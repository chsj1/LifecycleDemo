package test.hjd.com.lifecycledemo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by allen on 2019-09-08.
 */
public class InitialContentProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        /*
        接入方,0代码接入.(Provider可以写在自己的lib里面,而不需要接入方手动接入
        而对于Application.onCreate()这种方式来说,需要接入方手动接入
        )
         */
        System.out.println("------>库的初始化的第二种方式");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
