package com.ms.tet;

import android.app.Application;

import androidx.room.Room;

import com.ms.tet.data.RecDao;
import com.ms.tet.data.Recdb;

public class App extends Application {

    Recdb db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(this, Recdb.class, "db")
        .fallbackToDestructiveMigration()
                .build();
    }
}
