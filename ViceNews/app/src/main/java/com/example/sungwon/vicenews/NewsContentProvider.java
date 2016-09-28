package com.example.sungwon.vicenews;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by SungWon on 9/26/2016.
 */

public class NewsContentProvider extends ContentProvider {

    private ViceDBHelper myDB;
    private static final String AUTHORITY = "com.example.sungwon.vicenews.NewsContentProvider";
    private static final String ARTICLES_RECENT_TABLE = ViceDBHelper.DATABASE_TABLE_NAME;
    private static final String ARTICLES_POPULAR_TABLE = ViceDBHelper.DATABASE_TABLE_NAME;
    public static final Uri CONTENT_URI = Uri.parse("content://"
            + AUTHORITY + "/" + ARTICLES_RECENT_TABLE);

    public static final int ARTICLES_RECENT = 1;
    public static final int ARTICLES_RECENT_ID = 2;
    public static final int ARTICLES_POPULAR = 3;
    public static final int ARTICLES_POPULAR_ID = 4;

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sURIMatcher.addURI(AUTHORITY, ARTICLES_RECENT_TABLE, ARTICLES_RECENT);
        sURIMatcher.addURI(AUTHORITY, ARTICLES_RECENT_TABLE + "/#", ARTICLES_RECENT_ID);
        sURIMatcher.addURI(AUTHORITY, ARTICLES_POPULAR_TABLE, ARTICLES_POPULAR);
        sURIMatcher.addURI(AUTHORITY, ARTICLES_POPULAR_TABLE + "/#", ARTICLES_POPULAR_ID);
    }

    @Override
    public boolean onCreate() {
        myDB = new ViceDBHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int uriType = sURIMatcher.match(uri);

        Cursor cursor = null;

        switch (uriType) {
            case ARTICLES_RECENT:
                //TODO: Make query for Recent articles auto set to 0
//                cursor = myDB.getRecentArticles(uri.getLastPathSegment());
                break;
            case ARTICLES_RECENT_ID:
                //TODO: Make query for Recent articles
//                cursor = myDB.getRecentArticles(selection, selectionArgs);
                break;
            case ARTICLES_POPULAR:
                //TODO: Make query for popular articles auto set to 0
//                cursor = myDB.getPopularArticles(uri.getLastPathSegment());
                break;
            case ARTICLES_POPULAR_ID:
                //TODO: Make query for pop art
//                cursor = myDB.getPopularArticles(uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Unknown URI");
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
