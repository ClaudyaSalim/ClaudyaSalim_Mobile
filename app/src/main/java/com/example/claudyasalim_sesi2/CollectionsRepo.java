package com.example.claudyasalim_sesi2;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CollectionsRepo {

    private final CollectionsDao collectionsDao;
    private final ExecutorService executorService;

    public CollectionsRepo(Application application) {
        executorService = Executors.newSingleThreadExecutor();
        CollectionRoomDatabase db = CollectionRoomDatabase.getDatabase(application);
        collectionsDao = db.collectionsDao();
    }

    public LiveData<List<CollectionItem>> getCollectionItems(){
        return collectionsDao.getCollection();
    }

    public void insert(final CollectionItem collectionItem) {
        collectionsDao.insert(collectionItem);
    }
}
