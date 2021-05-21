package com.igitonga.eclecticstest.githubrepo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.igitonga.eclecticstest.MainActivity;
import com.igitonga.eclecticstest.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubReposActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_repos);

        listView = (ListView)findViewById(R.id.listView);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        ApiInterface client = retrofit.create(ApiInterface.class);
        Call<List<GitHubRepo>> call = client.reposForuser("Iangitonga");
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                Log.d("call", call.request().toString());
                Log.d("onResponse", response.body().toString());
                List<GitHubRepo> repos = response.body();
                listView.setAdapter(new GithubRepoAdapter(GithubReposActivity.this, -1, repos));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(GithubReposActivity.this,"error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
