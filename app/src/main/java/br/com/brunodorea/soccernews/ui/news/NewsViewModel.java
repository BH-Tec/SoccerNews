package br.com.brunodorea.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.com.brunodorea.soccernews.data.remote.SoccerNewsApi;
import br.com.brunodorea.soccernews.domain.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private final SoccerNewsApi api;

    public NewsViewModel() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://brunodorea.github.io/SoccerNews_API//")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(SoccerNewsApi.class);
        findNews();

    }

    private void findNews() {
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if(response.isSuccessful()){
                    news.setValue((response.body()));
                } else {
                    // TODO: Pensar em um tratamento de erro.
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                // TODO: Pensar em um tratamento de erro.
            }
        });
    }

    public LiveData<List<News>> getNews() {
        return news;
    }
}