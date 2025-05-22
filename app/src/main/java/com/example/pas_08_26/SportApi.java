package com.example.pas_08_26;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SportApi {
    @GET("search_all_teams.php")
    Call<ModelResponse> getTeams(@Query("l") String league);

    @GET ("lookup_all_players.php")
    Call<PlayerResponse> getPlayer(@Query("id") String player);
}
