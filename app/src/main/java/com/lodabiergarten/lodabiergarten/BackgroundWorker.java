package com.lodabiergarten.lodabiergarten;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException; //comment
import java.net.URLEncoder;
import java.net.URL;

public class BackgroundWorker extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;

    BackgroundWorker(Context ctx) {
        context = ctx;


    } //constructor for mainactivity.java onLogin method

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://10.20.122.78/login.php"; //standard ip to comm with local host (Check ipconfig)
        String signup_url = "http://10.20.122.78/signup.php";
        if(type.equals("login")) {
            try {
                String user_name = params[1];
                String pass_word = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream =  httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8")+"="+URLEncoder.encode(user_name, "UTF-8")+"&"
                        +URLEncoder.encode("pass_word", "UTF-8")+"="+URLEncoder.encode(pass_word, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                    return result;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        if(type.equals("signup")) {
            try {
                String user_name = params[1];
                String pass_word = params[2];
                String fname = params[3];
                String lname = params[4];
                String age = params[5];
                String zipcode = params[6];
                URL url = new URL(signup_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream =  httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(user_name, "UTF-8")+"&"
                +URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(pass_word, "UTF-8")+"&"
                +URLEncoder.encode("fname", "UTF-8")+"="+URLEncoder.encode(fname, "UTF-8")+"&"
                +URLEncoder.encode("lname", "UTF-8")+"="+URLEncoder.encode(lname, "UTF-8") + "&"
                +URLEncoder.encode("age", "UTF-8")+"="+URLEncoder.encode(age, "UTF-8") + "&"
                +URLEncoder.encode("zipcode", "UTF-8")+"="+URLEncoder.encode(zipcode, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                    return result;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("LoginStatus");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void ... values) {
        super.onProgressUpdate(values);
    }
}

