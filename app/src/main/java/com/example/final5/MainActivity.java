package com.example.final5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AdapterMask adapterMask;
    private List<Mask> maskList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list);
        adapterMask = new AdapterMask(MainActivity.this, maskList);
        listView.setAdapter(adapterMask);

        new Get().execute();
    }

    public class Get extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://ngknn.ru:5001/NGKNN/полковниковаав/api/Dogs/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line = "";
                while ((line = reader.readLine()) != null){
                    result.append(line);
                }
                return result.toString();
            }catch (Exception exception){
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            try {
                JSONArray tempArray = new JSONArray(s);
                for (int i = 0; i<tempArray.length(); i++){
                    JSONObject Json = tempArray.getJSONObject(i);
                    Mask temp = new Mask(
                            Json.getInt("ID"),
                            Json.getString("Dog1"),
                            Json.getString("Info")
                    );
                    maskList.add(temp);
                    adapterMask.notifyDataSetInvalidated();
                }
            }catch (Exception exception){

            }
        }
    }
}