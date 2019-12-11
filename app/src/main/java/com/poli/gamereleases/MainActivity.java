package com.poli.gamereleases;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.poli.gamereleases.adapter.GameAdapter;
import com.poli.gamereleases.model.Game;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Game> listGame;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listGame = new ArrayList<>();
        recyclerView = findViewById(R.id.rvGamesList);
        jsonRequest();
    }

    private void jsonRequest() {

        String JSON_URL = "https://api.crackwatch.com/api/games?page=0&sort_by=release_date&is_released=true";
        JsonArrayRequest request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject;

                for (int i = 0; i < response.length(); i++) {


                    try {
                        jsonObject = response.getJSONObject(i);
                        Game game = new Game();
                        game.setTitle(jsonObject.getString("title"));
                        game.setReleaseDate(jsonObject.getString("releaseDate"));

                        if (jsonObject.has("image")) {
                            game.setImageURL(jsonObject.getString("image"));
                        }

                        listGame.add(game);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                setupRecyclerView(listGame);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }

    private void setupRecyclerView(List<Game> listGame) {

        GameAdapter gameAdapter = new GameAdapter(this, listGame);
        recyclerView.setAdapter(gameAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
