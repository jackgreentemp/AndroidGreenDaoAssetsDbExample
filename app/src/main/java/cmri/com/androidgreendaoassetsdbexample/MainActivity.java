/*
 * Copyright (c) 2017. CMRI PRIVATE LIMITED. All rights reserved
 * Created by WangBo on 17-6-23 上午11:55
 *
 * Last modified 17-6-23 上午11:38
 */

package cmri.com.androidgreendaoassetsdbexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoSession daoSession = ((Application) getApplication()).daoSession;
        TownDao townDao = daoSession.getTownDao();
        List<Town> towns = townDao.loadAll();
    }
}
