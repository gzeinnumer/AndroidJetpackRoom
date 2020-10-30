# AndroidJetpackRoom
 Room database like SQLLite

- [Room](https://developer.android.com/training/data-storage/room)

Start Room
- Add dependencies
```gradle
def room_version = "2.2.5"
implementation "android.arch.persistence.room:runtime:$room_version"
annotationProcessor "android.arch.persistence.room:compiler:$room_version"
```

- SampleTable
```java
@Entity(tableName = "sample_table")
public class SampleTable {

    public SampleTable(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "name")
    public String name;
}
```

- SampleTableDao
```java
@Dao
public interface  SampleTableDao {
    @Query("SELECT * FROM sample_table")
    List<SampleTable> getAll();

    @Insert
    void insertAll(SampleTable... sampleTables);

    @Delete
    void delete(SampleTable sampleTable);
}
```

- AppDatabase
```java
@Database(entities = {SampleTable.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    private static final String TAG = "AppDatabase";
    public static String dbName = "ExternalBase64Md5ToZip.db";

    public abstract SampleTableDao sampleTableDao();

    public static AppDatabase getInstance(Context context) {
        return Room.databaseBuilder(context,AppDatabase.class, dbName)
                .allowMainThreadQueries()
                .build();
    }
}
```

---

```
Copyright 2020 M. Fadli Zein
```


