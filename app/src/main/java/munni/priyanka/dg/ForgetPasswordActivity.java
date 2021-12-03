package munni.priyanka.dg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        getSupportActionBar().hide();
        emailEditText = findViewById(R.id.email_id_textview);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait!!");
    }

    public void sendLinkToEmail(View view) {
        if (emailEditText.getText().toString().isEmpty()){
            emailEditText.setError("Please, Enter your email id !!");
            emailEditText.requestFocus();
            return;
        }
        emailEditText.setError(null);
        sendLineToEmail(emailEditText.getText().toString());
    }

    private void sendLineToEmail(String email) {
        progressDialog.show();
        mAuth.sendPasswordResetEmail(email)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progressDialog.dismiss();
                        Toast toast = Toast.makeText(ForgetPasswordActivity.this,"Please, Check your Email Id",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(ForgetPasswordActivity.this,LoginActivity.class));
                                finish();
                            }
                        },3000);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast toast = Toast.makeText(ForgetPasswordActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ForgetPasswordActivity.this,LoginActivity.class));
        finish();
        super.onBackPressed();
    }

    public void openRegisterUserActivity(View view) {
        startActivity(new Intent(ForgetPasswordActivity.this,RegisterUserActivity.class));
        finish();
    }
}