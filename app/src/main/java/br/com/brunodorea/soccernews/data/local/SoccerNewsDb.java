package br.com.brunodorea.soccernews.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.com.brunodorea.soccernews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class SoccerNewsDb extends RoomDatabase {
    public abstract NewsDao newsDao();
}