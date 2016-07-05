package com.example.android.newsapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    public TextView textView;
    String pageSize = "&page-size=10";
    public String URLString = "https://content.guardianapis.com/search?api-key=66dc4b8e-5f1d-4809-8a3e-eeb549019871&show-fields=thumbnail"+pageSize;
    public String URLFull;
    private static final String TAG_TITLE = "webTitle";
    private static final String TAG_DATE = "webPublicationDate";
    private static final String TAG_SECTION = "sectionName";
    private static final String TAG_ID = "id";
    private static final String TAG_URL = "webUrl";
    private static final String TAG_IMAGE = "thumbnail";
    private static final String TAG_FIELDS = "fields";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.article_list);
        textView = (TextView) findViewById(R.id.no_data);
        assert textView != null;
        textView.setText("");
        Button button = (Button) findViewById(R.id.search_button);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.search_input);
                String input = editText.getText().toString().replace(" ", "+");
                URLFull = URLString + "&q=" + input;
                Log.v("URL FULL", URLFull);
                new JSONprocessor().execute(URLFull);
            }
        });
    }

    private class JSONprocessor extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "loading data", Toast.LENGTH_SHORT).show();
        }

        protected String doInBackground(String... strings) {
            String stream = null;
            String URLString = strings[0];
            DataHandler dataHandler = new DataHandler();
            stream = dataHandler.getStreamData(URLString);
            return stream;
        }

        protected void onPostExecute(String stream) {
            final ArrayList<HashMap<String, String>> articleList = new ArrayList<HashMap<String, String>>();
            if (stream != null) {
                try {
                    JSONObject jsonObject = new JSONObject(stream);
                    JSONObject jsonObjectArray = jsonObject.getJSONObject("response");
                    int totalNumArticles = jsonObjectArray.getInt("total");
                    if (totalNumArticles == 0) {
                        listView.setVisibility(View.INVISIBLE);
                        textView.setText(R.string.no_data);
                        Toast.makeText(MainActivity.this, "Search returned no results", Toast.LENGTH_SHORT).show();
                    } else {
                        textView.setText("");
                        JSONArray newsArticles = jsonObjectArray.getJSONArray("results");
                        for (int i = 0; i < 10; i++) {
                            JSONObject articleObject = newsArticles.getJSONObject(i);
                            String title, date, URL, section, ID;
                            String image = null;
                            JSONObject fieldsObject = articleObject.getJSONObject(TAG_FIELDS);
                            if(fieldsObject!=null){
                                image = fieldsObject.getString(TAG_IMAGE);
                            }
                            title = articleObject.getString(TAG_TITLE);
                            date = articleObject.getString(TAG_DATE);
                            URL = articleObject.getString(TAG_URL);
                            section = articleObject.getString(TAG_SECTION);
                            ID = String.valueOf(i+1);
                            ID = ID+".";
                            HashMap<String, String> hashMap = new HashMap<String, String>();
                            hashMap.put(TAG_ID, ID);
                            hashMap.put(TAG_TITLE, title);
                            hashMap.put(TAG_SECTION, section);
                            hashMap.put(TAG_URL, URL);
                            hashMap.put(TAG_DATE, date);
                            if(fieldsObject!=null){
                                hashMap.put(TAG_IMAGE, image);
                            }
                            articleList.add(hashMap);

                            ListAdapter listAdapter = new SimpleAdapter(MainActivity.this,
                                    articleList,
                                    R.layout.listview_searchresult_layout,
                                    new String[]{TAG_TITLE, TAG_DATE, TAG_SECTION, TAG_IMAGE},
                                    new int[]{R.id.article_title, R.id.article_date, R.id.article_section, R.id.article_image});

                            listView.setAdapter(listAdapter);
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent,
                                                        View view,
                                                        int position,
                                                        long id) {
                                    String url = articleList.get(+position).get(TAG_URL);
                                    Intent intent = new Intent(Intent.ACTION_VIEW);
                                    intent.setData(Uri.parse(url));
                                    startActivity(intent);
                                }
                            });
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
