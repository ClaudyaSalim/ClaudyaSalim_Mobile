package com.example.claudyasalim_sesi2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CollectionItem.class}, version = 1)
abstract class CollectionRoomDatabase extends RoomDatabase {
    public abstract CollectionsDao collectionsDao();

    public CollectionRoomDatabase(){

    }

    private static CollectionRoomDatabase INSTANCE;

    public static CollectionRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (CollectionRoomDatabase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CollectionRoomDatabase.class, "collections_database").build();
            }
        }
        return INSTANCE;
    }
}
