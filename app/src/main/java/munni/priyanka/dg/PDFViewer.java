package munni.priyanka.dg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PDFViewer extends AppCompatActivity {
    String url, name;
    private PDFView pdfView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_d_f_viewer);
        getSupportActionBar().hide();
        url = getIntent().getStringExtra("url");
        name = getIntent().getStringExtra("name");
        Log.e("Name",name);
        Log.e("URL",url);
        pdfView = findViewById(R.id.pdfview);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Downloading File...");
        progressDialog.setMessage("Please wait until we prepare document for you.");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(false);
        new DownloadPDF().execute(url); }
    class DownloadPDF extends AsyncTask<String,String, InputStream>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show(); }
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try { URL pdfurl = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection)pdfurl.openConnection();
                connection.setDoInput(true);
                connection.setRequestMethod("GET");
                connection.connect();
                if(connection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(connection.getInputStream()); }
            } catch (MalformedURLException e) {
                Log.e("URLException:",e.getLocalizedMessage());
                return  null;
            } catch (IOException e) {
                Log.e("IOException:",e.getLocalizedMessage());
                return  null; }
            return  inputStream; }
        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                }
            },4000); }}}
