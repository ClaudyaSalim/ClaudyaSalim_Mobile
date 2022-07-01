package com.example.claudyasalim_sesi2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CollectionItem {

    private String name;

    @PrimaryKey
    private int id;

    public void setName(String name){
        this.name = name;
    }

    public String getName(String name){
        return name;
    }


    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

}
