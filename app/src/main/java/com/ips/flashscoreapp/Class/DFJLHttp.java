package com.ips.flashscoreapp.Class;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class DFJLHttp extends AsyncTask<String, Void, JSONArray> {

    public interface AsyncResponse {
        void processFinish(JSONArray output) throws JSONException;

    }

    public AsyncResponse delegate = null;

    public DFJLHttp(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    //handles the response from the async task
    @Override
    public void onPostExecute(JSONArray jsonArray) {
        try {
            delegate.processFinish(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //async task main code
    @Override
    public JSONArray doInBackground(String... strings) {
        URL url = null;
        try {
            url = new URL(strings[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            //try to get a conection to the URL
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
             //handles the html response
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            //convert json into a java object
            JSONArray jsonArray = new JSONArray(result.toString());

            return jsonArray;


        } catch (IOException | JSONException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }

        return null;
    }
}
