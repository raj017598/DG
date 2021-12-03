package munni.priyanka.dg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class FeedBackActivity extends AppCompatActivity {

    private EditText messege, NameEditText;
    private Button send;
    private FirebaseAuth firebaseAuth;
    private String  name="";
    private DatabaseReference mainDB;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        getSupportActionBar().hide();

        send = findViewById(R.id.submit_button);
        messege = findViewById(R.id.message_edittext);
        firebaseAuth = FirebaseAuth.getInstance();
        mainDB = FirebaseDatabase.getInstance().getReference();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = ProgressDialog.show(FeedBackActivity.this,"Sending...","");
                String userId = firebaseAuth.getCurrentUser().getUid();
                Log.e("UID",userId);
                mainDB.child("USERS").child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String user = dataSnapshot.child("name").getValue().toString();
                        final String message = messege.getText().toString();
                        if(message.isEmpty())
                        {
                            progressDialog.dismiss();
                            messege.setError("Enter Something");
                            messege.requestFocus();
                            return;
                        }
                        Map<String, String> feedbackyUser = new HashMap<>();
                        feedbackyUser.put("name",user);
                        feedbackyUser.put("message",message);
                        mainDB.child("Student Feedback").push().setValue(feedbackyUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {
                                    messege.setText("");
                                    progressDialog.dismiss();
                                    Toast.makeText(FeedBackActivity.this,"Successfully Sent",Toast.LENGTH_LONG).show();
                                }
                                else {
                                    progressDialog.dismiss();
                                    Toast.makeText(FeedBackActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        progressDialog.dismiss();
                    }
                });
            }
        });
    }
}
