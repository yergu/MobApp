package com.example.androidapp_development.assignment6;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserSettings.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SettingsDao settingsDao();
}
