package munni.priyanka.dg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private CheckBox rememberPasswordCheckBox;
    private Button signInButton;
    String email,password;
    private FirebaseAuth mAuth;
    private DatabaseReference reference;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        emailEditText = findViewById(R.id.email_address_edittext);
        passwordEditText = findViewById(R.id.password_edittext);
        rememberPasswordCheckBox = findViewById(R.id.checkBox);
        signInButton = findViewById(R.id.log_in_button);
        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference("USERS");
        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogInUser();
            }
        });
    }

    private void LogInUser() {
        email = emailEditText.getText().toString();
        password = passwordEditText.getText().toString();

        if (TextUtils.isEmpty(email)) {
            emailEditText.setError("Field can't be empty !!");
            passwordEditText.setError(null);
            emailEditText.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Enter valid email id !!");
            passwordEditText.setError(null);
            emailEditText.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            emailEditText.setError(null);
            passwordEditText.setError("Enter your password !!");
            passwordEditText.requestFocus();
            return;
        }
        emailEditText.setError(null);
        passwordEditText.setError(null);
        UserLogin(email,password);
    }

    private void UserLogin(String email, String password) {
        progressDialog.setMessage("Please Wait !!");
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        ChangeStatusOfUser();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast toast = Toast.makeText(LoginActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }
                });
    }

    private void ChangeStatusOfUser() {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("status","online");
        reference.child(mAuth.getUid()).updateChildren(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progressDialog.dismiss();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast toast = Toast.makeText(LoginActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }
                });
    }

    public void openSignUpActivity(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterUserActivity.class));
        finish();
    }

    public void openForgetPasswordActivity(View view) {
        startActivity(new Intent(LoginActivity.this,ForgetPasswordActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(LoginActivity.this,RegisterUserActivity.class));
        finish();
    }
}