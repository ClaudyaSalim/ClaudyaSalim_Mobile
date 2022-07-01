package com.example.claudyasalim_sesi2;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainViewModel extends ViewModel {

    private CollectionsRepo collectionRepo;

    public MainViewModel (Application application){
        collectionRepo= new CollectionsRepo(application);
    }

    private MutableLiveData<List<CollectionItem>> collections = new MutableLiveData<>();
    public LiveData<List<CollectionItem>> getCollections() {
        return collections;
    }


    public void insertCollectionItem(CollectionItem collectionItem) {
        collectionRepo.insert(collectionItem);
    }
}
