package com.gzeinnumer.androidjetpackroom.helper;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.gzeinnumer.androidjetpackroom.model.Note;

import java.util.List;

//todo 2
@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getAllNote();

    @Query("SELECT * FROM notes WHERE id=:id")
    LiveData<Note> getNote(String id);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

}
