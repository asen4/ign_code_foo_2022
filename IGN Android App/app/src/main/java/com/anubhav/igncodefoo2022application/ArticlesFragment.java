package com.anubhav.igncodefoo2022application;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ArticlesFragment extends Fragment {

    private ArrayList<Article> articleArrayList = new ArrayList<>();
    private ArticleAdapter articleAdapter;
    private RecyclerView articlesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_articles, container, false);

        jsonCall();

        articleAdapter = new ArticleAdapter(articleArrayList, getActivity());

        articlesList = (RecyclerView) view.findViewById(R.id.articlesList);
        articlesList.setLayoutManager(new LinearLayoutManager(getActivity()));
        articlesList.setHasFixedSize(true);
        articlesList.setAdapter(articleAdapter);

        return view;
    }

    private void jsonCall() {
        String url = "https://ign-apis.herokuapp.com/articles?startIndex=40&count=10";

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray data = response.getJSONArray("data");
                            JSONObject object_in_data = data.getJSONObject(0);
                            Gson gson = new Gson();
                            Article articleData = gson.fromJson(object_in_data.toString(), Article.class);
                            articleArrayList.add(articleData);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        MySingleton.getInstance(getActivity()).addToRequestQueue(jsonObjectRequest);
    }
}