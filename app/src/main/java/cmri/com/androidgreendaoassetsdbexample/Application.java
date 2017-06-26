/*
 * Copyright (c) 2017. CMRI PRIVATE LIMITED. All rights reserved
 * Created by WangBo on 17-6-23 上午11:50
 *
 * Last modified 17-6-23 上午11:50
 */

package cmri.com.androidgreendaoassetsdbexample;

import android.util.Log;

import org.greenrobot.greendao.database.Database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Application extends android.app.Application {

    public DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        //复制assets目录下的数据库文件到应用数据库中
        try {
            copyDataBase("zone.db");
        } catch (Exception e) {
            Log.e("Application", e.getMessage());
        }

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "zone.db", null);
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    /**
     * Copies your database from your local assets-folder to the just created
     * empty database in the system folder, from where it can be accessed and
     * handled. This is done by transfering bytestream.
     * */
    private void copyDataBase(String dbname) throws IOException {
        // Open your local db as the input stream
        InputStream myInput = this.getAssets().open(dbname);
        // Path to the just created empty db
        File outFileName = this.getDatabasePath(dbname);

        if (!outFileName.exists()) {
            outFileName.getParentFile().mkdirs();

            // Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);
            // transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            // Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }
    }
}
