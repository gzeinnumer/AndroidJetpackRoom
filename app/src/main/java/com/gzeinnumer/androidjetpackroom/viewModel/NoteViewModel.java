package com.gzeinnumer.androidjetpackroom.viewModel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.gzeinnumer.androidjetpackroom.helper.Note;
import com.gzeinnumer.androidjetpackroom.helper.NoteDao;
import com.gzeinnumer.androidjetpackroom.helper.NoteRoomDatabase;

public class NoteViewModel extends AndroidViewModel {

    private static final String TAG = "NoteViewModel";
    private NoteRoomDatabase noteRoomDatabase;
    private NoteDao noteDao;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteRoomDatabase = NoteRoomDatabase.getDatabase(application);
        noteDao = noteRoomDatabase.noteDao();
    }

    public void insert(Note note){
        new InsertAsyncTask(noteDao).execute(note);
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        Log.i(TAG, "onCleared: Viewmodel Destroyed");
    }

    @SuppressLint("StaticFieldLeak")
    private class InsertAsyncTask extends AsyncTask<Note, Void, Void>{
        NoteDao noteDao;

        public InsertAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
}
