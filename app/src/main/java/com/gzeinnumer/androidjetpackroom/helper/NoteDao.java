package com.gzeinnumer.androidjetpackroom.helper;

import androidx.room.Dao;
import androidx.room.Insert;

//todo 2
@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

}
