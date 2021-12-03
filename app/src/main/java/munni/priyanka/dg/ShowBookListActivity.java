package munni.priyanka.dg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ShowBookListActivity extends AppCompatActivity {

    String subject_code, year;
    private GridView bookListView;
    ProgressDialog progressDialog;
    List<FetchBook> list;
    FirebaseAuth mAuth;
    StorageReference sr;
    DatabaseReference dr;
    String[] uploads;
    String[] image_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_book_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#232D36"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        subject_code = getIntent().getStringExtra("subject_name");
        bookListView = findViewById(R.id.gridView);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        list = new ArrayList<FetchBook>();
        ViewAllQuestionPapers();
        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FetchBook book = list.get(position);
                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(book.getUrl()));
                startActivity(in);
            }
        }); }
    private void ViewAllQuestionPapers() {
        progressDialog.show();
        if(subject_code.equals("bca109")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca109/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca109/");
            getSupportActionBar().setTitle("Books:"); }
        else if(subject_code.equals("bca209")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca209/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca209/");
            getSupportActionBar().setTitle("Books:"); }
        else if(subject_code.equals("bca309")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca309/");
            dr = FirebaseDatabase.getInstance().getReference("ku/kcc/bca/bca309/");
            getSupportActionBar().setTitle("Books:"); }
        else if(subject_code.equals("bca408")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca408/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca408/");
            getSupportActionBar().setTitle("Books:"); }
        else if(subject_code.equals("bca508")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca508/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca508/");
            getSupportActionBar().setTitle("Books:"); }
        else if(subject_code.equals("bca608")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca608/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca608/");
            getSupportActionBar().setTitle("Book:"); }
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();
                            }
                        },4000);
                        FetchBook book = snapshot.getValue(munni.priyanka.dg.FetchBook.class);
                        list.add(book); }
                    uploads = new String[list.size()];
                    image_url = new String[list.size()];
                    for (int i = 0; i < uploads.length; i++) {
                        uploads[i] = list.get(i).getName();
                        image_url[i] = list.get(i).getImage_url(); }
                    CustomAdapter adapter = new CustomAdapter();
                    bookListView.setAdapter(adapter); }
                catch (Exception e) {
                    Log.e("QUESTION", e.getMessage()); } }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();
                Toast.makeText(ShowBookListActivity.this,"Cancel, Try Again",Toast.LENGTH_LONG).show(); }
        }); }
    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return image_url.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.show_book_layout,null);
            TextView name = view.findViewById(R.id.txtBookName);
            ImageView imgImage = view.findViewById(R.id.imgImage);
            name.setText(uploads[position]);
            try {
                Picasso.get().load(image_url[position]).into(imgImage); }
            catch (Exception e) {
                imgImage.setImageResource(R.drawable.pdf); }
            return view; }}}
