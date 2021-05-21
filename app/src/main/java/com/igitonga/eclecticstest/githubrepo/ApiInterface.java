package com.igitonga.eclecticstest.githubrepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForuser(@Path("user") String user);
}
