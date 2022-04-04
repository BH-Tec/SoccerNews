package br.com.brunodorea.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.com.brunodorea.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        // Mock com dados fake
        // TODO: Remover mock de noticias.
        List<News> news = new ArrayList<>();
        news.add(new News("Bahia","Eliminado na 1ª fase do Campeonato Baiano"));
        news.add(new News("Atlético Mineiro","Campeão Mineiro"));
        news.add(new News("Palmeiras","Campeão Paulista"));

        this.news.setValue(news);

    }

    public LiveData<List<News>> getNews() {
        return news;
    }
}