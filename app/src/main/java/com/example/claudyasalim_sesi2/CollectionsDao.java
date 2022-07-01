package com.example.claudyasalim_sesi2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CollectionsDao {

    @Insert
    void insert(CollectionItem collectionItem);

    @Query("select * from CollectionItem")
    LiveData<List<CollectionItem>> getCollection();

}
