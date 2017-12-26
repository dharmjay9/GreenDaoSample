package com.katerra.greendaosample;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.katerra.greendaosample.database.DaoMaster;
import com.katerra.greendaosample.database.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by divum on 25/12/17.
 */

public class App extends Application {
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "student-db-encrypted" : "student-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}

