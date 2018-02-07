package com.inzenjer.ram.inzenjerstud;

import android.content.Intent;
import android.graphics.Canvas;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.inzenjer.ram.inzenjerstud.Adapters.Batch_list_adapter;
import com.inzenjer.ram.inzenjerstud.Models.Batch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddBatch extends AppCompatActivity {
    RecyclerView r_batch_list;
    FloatingActionButton add_batch;
    RequestQueue rq;
    List<Batch> batch_list = new ArrayList<>();
    Batch_list_adapter batchListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_batch);
        r_batch_list = findViewById(R.id.batch_list);
        add_batch = findViewById(R.id.add_batch);
        rq = Volley.newRequestQueue(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        r_batch_list.setLayoutManager(layoutManager);
        batchListAdapter = new Batch_list_adapter(batch_list);
        r_batch_list.setAdapter(batchListAdapter);
        r_batch_list.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        r_batch_list.setItemAnimator(new DefaultItemAnimator());
        r_batch_list.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), r_batch_list, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        batches();
        add_batch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddBatch.this, Batches.class));
            }
        });
    }

    public void batches() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://heloinzproject.atwebpages.com/mbatchlist.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject j = new JSONObject(response);
                    JSONObject bundle = j.getJSONObject("bundle");
                    JSONArray batch = bundle.getJSONArray("batch");
                    for (int i = 0; i < batch.length(); i++) {
                        JSONObject jsonObject = batch.getJSONObject(i);
                        Batch b = new Batch();
                        b.setBatch_id(jsonObject.getString("batch_id"));
                        b.setBatch_name(jsonObject.getString("batch_name"));
                        b.setCollege_name(jsonObject.getString("college_name"));
                        b.setProject_name(jsonObject.getString("project_name"));
                        batch_list.add(b);
                        batchListAdapter.notifyDataSetChanged();
                    }

                } catch (JSONException j) {
                    Log.e("Jsonexeption from Addbatch", j.toString());
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("volley error", error.toString());

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        rq.add(stringRequest);
    }
}
