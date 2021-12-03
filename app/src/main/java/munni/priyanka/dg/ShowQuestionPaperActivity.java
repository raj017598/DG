package munni.priyanka.dg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ShowQuestionPaperActivity extends AppCompatActivity {

    String subject_code, year, college, university;
    private ListView questionListView;
    ProgressDialog progressDialog;
    List<FetchDatabase> list;
    FirebaseAuth mAuth;
    FirebaseUser user;
    StorageReference sr;
    DatabaseReference dr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_question_paper);
        questionListView = findViewById(R.id.questionListView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#232D36"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        subject_code = getIntent().getStringExtra("subject");
        year = getIntent().getStringExtra("year");
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        if (subject_code.equals("bca105") || subject_code.equals("bca106") || subject_code.equals("bca107") || subject_code.equals("bca108") || subject_code.equals("bca205") || subject_code.equals("bca206") || subject_code.equals("bca207") || subject_code.equals("bca208") ||subject_code.equals("bca305") || subject_code.equals("bca308") || subject_code.equals("bca306") || subject_code.equals("bca307") || subject_code.equals("bca407") || subject_code.equals("bca406") || subject_code.equals("bca404") || subject_code.equals("bca405") || subject_code.equals("bca507") || subject_code.equals("bca506") || subject_code.equals("bca504") || subject_code.equals("bca505") ||subject_code.equals("bca606") || subject_code.equals("bca607") || subject_code.equals("bca604") || subject_code.equals("bca605")) {
            college = getIntent().getStringExtra("college");
            university = getIntent().getStringExtra("unicersity"); }
        list = new ArrayList<FetchDatabase>();
        ViewAllQuestionPapers();
        questionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FetchDatabase database = list.get(position);
                if(subject_code.equals("pn") ) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(database.getUrl()));
                    startActivity(i);
                    return; }
                Intent intent = new Intent(ShowQuestionPaperActivity.this, PDFViewer.class);
                try { intent.putExtra("url",database.getUrl());
                    intent.putExtra("name",database.getName());
                    startActivity(intent); }
                catch (Exception e) {
                    Toast.makeText(ShowQuestionPaperActivity.this, e.getMessage(), Toast.LENGTH_LONG).show(); } } }); }
    private void ViewAllQuestionPapers() {
        progressDialog.show();
        if(subject_code.equals("bca101")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca101/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca101/");
            getSupportActionBar().setTitle("Differential Calculus:"); }
        else if(subject_code.equals("pn")) {
            dr = FirebaseDatabase.getInstance().getReference("app/bca/pn/");
            getSupportActionBar().setTitle("Placement Notification:"); }
        else if(subject_code.equals("pm")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/pm/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/pm/");
            getSupportActionBar().setTitle("Placement Material:"); }
        else if(subject_code.equals("bca102")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca102/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca102/");
            getSupportActionBar().setTitle("Introduction to Computer Science:"); }
        else if(subject_code.equals("bca103")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca103/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca103/");
            getSupportActionBar().setTitle("Programming in C:"); }
        else if(subject_code.equals("bca104")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca104/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca104/");
            getSupportActionBar().setTitle("Communication Skills(English):"); }
        else if(subject_code.equals("bca105")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca105/ku/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca105/ku/");
            getSupportActionBar().setTitle("Lab of C:"); }
        else if(subject_code.equals("bca106")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca106/ku/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca106/ku/");
            getSupportActionBar().setTitle("Lab of IT:"); }
        else if(subject_code.equals("bca107")) {
            if(university.equalsIgnoreCase("Kolhan University, Chaiwasa")) {
                sr = FirebaseStorage.getInstance().getReference("app/bca/bca107/ku/");
                dr = FirebaseDatabase.getInstance().getReference("app/bca/bca107/ku/");
                getSupportActionBar().setTitle("External Question Paper:"); }}
        else if(subject_code.equals("bca108")) {
            if(university.equalsIgnoreCase("Kolhan University, Chaiwasa")) {
                sr = FirebaseStorage.getInstance().getReference("app/bca/bca108/ku/");
                dr = FirebaseDatabase.getInstance().getReference("app/bca/bca108/ku/");
                getSupportActionBar().setTitle("Internal Question Paper:"); } }
        else if(subject_code.equals("bca201")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca201/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca201/");
            getSupportActionBar().setTitle("Data Structure with C++"); }
        else if(subject_code.equals("bca20_1")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca20_1/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca20_1/");
            getSupportActionBar().setTitle("Programming in C++:"); }
        else if(subject_code.equals("bca202")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca202/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca202/");
            getSupportActionBar().setTitle("Probability & Statistics:"); }
        else if(subject_code.equals("bca203")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca203/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca203/");
            getSupportActionBar().setTitle("Logic Design:"); }
        else if(subject_code.equals("bca204")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca204/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca204/");
            getSupportActionBar().setTitle("Managerial Economics:"); }
        else if(subject_code.equals("bca205")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca205/ku/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca205/ku/");
            getSupportActionBar().setTitle("Lab of Data Structure:"); }
        else if(subject_code.equals("bca206")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca206/ku/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca206/ku/");
            getSupportActionBar().setTitle("Lab of C++:"); }
        else if(subject_code.equals("bca207")) {
            if(university.equalsIgnoreCase("Kolhan University, Chaiwasa")) {
                sr = FirebaseStorage.getInstance().getReference("app/bca/bca207/ku/");
                dr = FirebaseDatabase.getInstance().getReference("app/bca/bca207/ku/");
                getSupportActionBar().setTitle("External Question Papers:"); } }
        else if(subject_code.equals("bca208")) {
            if(university.equalsIgnoreCase("Kolhan University, Chaiwasa")) {
                sr = FirebaseStorage.getInstance().getReference("app/bca/bca208/ku/");
                dr = FirebaseDatabase.getInstance().getReference("app/bca/bca208/ku/");
                getSupportActionBar().setTitle("Internal Question Paper:"); } }
        else if(subject_code.equals("bca301")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca301/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca301/");
            getSupportActionBar().setTitle("Scientific Computing:"); }
        else if(subject_code.equals("bca302")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca302/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca302/");
            getSupportActionBar().setTitle("Software Engineering:"); }
        else if(subject_code.equals("bca303")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca303/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca303/");
            getSupportActionBar().setTitle("Relational DBMS:"); }
        else if(subject_code.equals("bca304_2")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca304_2/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca304_2/");
            getSupportActionBar().setTitle("Operating System:"); }
        else if(subject_code.equals("bca304_1")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca304_1/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca304_1/");
            getSupportActionBar().setTitle("Linux Programming:"); }
        else if(subject_code.equals("bca305")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca305/ku/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca305/ku/");
            getSupportActionBar().setTitle("Lab of OS:"); }
        else if(subject_code.equals("bca306")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca306/ku/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca306/ku/");
            getSupportActionBar().setTitle("Lab of Relational DBMS:"); }
        else if(subject_code.equals("bca307")) {
            if(university.equalsIgnoreCase("Kolhan University, Chaiwasa")) {
                sr = FirebaseStorage.getInstance().getReference("app/bca/bca307/ku/");
                dr = FirebaseDatabase.getInstance().getReference("app/bca/bca307/ku/");
                getSupportActionBar().setTitle("External Question Paper:"); } }
        else if(subject_code.equals("bca308")) {
            if(university.equalsIgnoreCase("Kolhan University, Chaiwasa")) {
                sr = FirebaseStorage.getInstance().getReference("app/bca/bca308/ku/");
                dr = FirebaseDatabase.getInstance().getReference("app/bca/bca308/ku/");
                getSupportActionBar().setTitle("Internal Question Paper:"); } }
        else if(subject_code.equals("bca401")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca401/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca401/");
            getSupportActionBar().setTitle("Networking:"); }
        else if(subject_code.equals("bca402")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca402/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca402/");
            getSupportActionBar().setTitle("Programming in JAVA:"); }
        else if(subject_code.equals("bca403")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca403/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca403/");
            getSupportActionBar().setTitle("Programming in Visual Basic:"); }
        else if(subject_code.equals("bca404")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca404/ku/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca404/ku/");
            getSupportActionBar().setTitle("Lab of JAVA:"); }
        else if(subject_code.equals("bca405")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca405/ku/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca405/ku/");
            getSupportActionBar().setTitle("Lab of Visual Basic:"); }
        else if(subject_code.equals("bca406")) {
            if(university.equalsIgnoreCase("Kolhan University, Chaiwasa")) {
                sr = FirebaseStorage.getInstance().getReference("app/bca/bca406/ku/");
                dr = FirebaseDatabase.getInstance().getReference("app/bca/bca406/ku/");
                getSupportActionBar().setTitle("External Question Paper:"); } }
        else if(subject_code.equals("bca407")) {
            if(university.equalsIgnoreCase("Kolhan University, Chaiwasa")) {
                sr = FirebaseStorage.getInstance().getReference("app/bca/bca407/ku/");
                dr = FirebaseDatabase.getInstance().getReference("app/bca/bca407/ku/");
                getSupportActionBar().setTitle("Internal Question Paper:"); } }
        else if(subject_code.equals("bca501")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca501/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca501/");
            getSupportActionBar().setTitle("E-Commerce:"); }
        else if(subject_code.equals("bca502")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca502/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca502/");
            getSupportActionBar().setTitle("Web Technology:"); }
        else if(subject_code.equals("bca503")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca503/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca503/");
            getSupportActionBar().setTitle("Computer Graphics:"); }
        else if(subject_code.equals("bca504")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca504/ku/");
            dr = FirebaseDatabase.getInstance().getReference("ku/kcc/bca/bca501/ku/");
            getSupportActionBar().setTitle("Lab of Web Technology:"); }
        else if(subject_code.equals("bca505")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca505/ku/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca505/ku/");
            getSupportActionBar().setTitle("Lab of Computer Graphics:"); }
        else if(subject_code.equals("bca506")) {
            if(university.equalsIgnoreCase("Kolhan University, Chaiwasa")) {
                sr = FirebaseStorage.getInstance().getReference("app/bca/bca506/ku/");
                dr = FirebaseDatabase.getInstance().getReference("app/bca/bca506/ku/");
                getSupportActionBar().setTitle("External Question Paper:"); } }
        else if(subject_code.equals("bca507")) {
            if(university.equalsIgnoreCase("Kolhan University, Chaiwasa")) {
                sr = FirebaseStorage.getInstance().getReference("app/bca/bca507/ku/");
                dr = FirebaseDatabase.getInstance().getReference("app/bca/bca507/ku/");
                getSupportActionBar().setTitle("Internal Question Paper:"); } }
        else if(subject_code.equals("bca601")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca601/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca601/");
            getSupportActionBar().setTitle("Distributed Database:"); }
        else if(subject_code.equals("bca602")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca602/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca602/");
            getSupportActionBar().setTitle("Distributed Computing:"); }
        else if(subject_code.equals("bca603")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca603/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca603/");
            getSupportActionBar().setTitle("Acc. And Finance Management:"); }
        else if(subject_code.equals("bca604")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca604/ku/");
            dr = FirebaseDatabase.getInstance().getReference("ku/kcc/bca/bca604/ku/");
            getSupportActionBar().setTitle("Lab Paper-2:"); }
        else if(subject_code.equals("bca605")) {
            sr = FirebaseStorage.getInstance().getReference("app/bca/bca605/ku/");
            dr = FirebaseDatabase.getInstance().getReference("app/bca/bca605/ku/");
            getSupportActionBar().setTitle("Lab Paper-2:"); }
        else if(subject_code.equals("bca606")) {
            if(university.equalsIgnoreCase("Kolhan University, Chaiwasa")) {
                sr = FirebaseStorage.getInstance().getReference("app/bca/bca606/ku/");
                dr = FirebaseDatabase.getInstance().getReference("app/bca/bca606/ku/");
                getSupportActionBar().setTitle("External Question Paper:"); } }
        else if(subject_code.equals("bca607")) {
            if(university.equalsIgnoreCase("Kolhan University, Chaiwasa")) {
                sr = FirebaseStorage.getInstance().getReference("app/bca/bca607/ku/");
                dr = FirebaseDatabase.getInstance().getReference("app/bca/bca607/ku/");
                getSupportActionBar().setTitle("Internal Question Paper:"); } }
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        progressDialog.dismiss();
                        FetchDatabase database = snapshot.getValue(munni.priyanka.dg.FetchDatabase.class);
                        list.add(database); }
                    String[] uploads = new String[list.size()];
                    for (int i = 0; i < uploads.length; i++) {
                        uploads[i] = list.get(i).getName(); }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.showquestionlayout,uploads);
                    questionListView.setAdapter(adapter); }
                catch (Exception e) {
                    Log.e("QUESTION", e.getMessage()); } }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();
                Toast.makeText(ShowQuestionPaperActivity.this,"Cancel, Try Again",Toast.LENGTH_LONG).show(); }}); }
    @Override
    protected void onStart() {
        super.onStart();
        user = mAuth.getCurrentUser(); }}

