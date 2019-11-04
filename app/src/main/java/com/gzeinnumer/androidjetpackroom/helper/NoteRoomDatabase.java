package com.gzeinnumer.androidjetpackroom.helper;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//todo 3
@Database(entities = Note.class, version = 1, exportSchema = false)
public abstract class NoteRoomDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();

    private static volatile NoteRoomDatabase noteRoomDatabase;

    public static NoteRoomDatabase getDatabase(final Context context){
        if (noteRoomDatabase == null){
            synchronized (NoteRoomDatabase.class){
                if (noteRoomDatabase == null){
                    noteRoomDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            NoteRoomDatabase.class, "note_database").build();
                }
            }
        }
        return noteRoomDatabase;
    }
}
