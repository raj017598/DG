package munni.priyanka.dg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class RegisterUserActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference reference;
    private EditText nameEditText, emailEditText, mobileEditText, passwordEditText, confirmPasswordEditText;
    private CheckBox confirmCheckBox;
    private Button signUpButton;

    private String name, email, password, phone;
    
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        getSupportActionBar().hide();

        intializeComponent();
        
        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference("USERS");
        
        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valiadateData();
            }
        });
    }

    private void valiadateData() {
        name = nameEditText.getText().toString().trim();
        email = emailEditText.getText().toString().trim();
        password = passwordEditText.getText().toString().trim();
        phone = mobileEditText.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            nameEditText.setError("Enter Your Name !!");
            emailEditText.setError(null);
            passwordEditText.setError(null);
            mobileEditText.setError(null);
            confirmPasswordEditText.setError(null);
            nameEditText.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            nameEditText.setError(null);
            emailEditText.setError("Field can't be empty !!");
            passwordEditText.setError(null);
            mobileEditText.setError(null);
            confirmPasswordEditText.setError(null);
            emailEditText.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            nameEditText.setError(null);
            emailEditText.setError("Enter valid email id !!");
            passwordEditText.setError(null);
            mobileEditText.setError(null);
            confirmPasswordEditText.setError(null);
            emailEditText.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            nameEditText.setError(null);
            emailEditText.setError(null);
            mobileEditText.setError("Please enter your phone number !!");
            passwordEditText.setError(null);
            confirmPasswordEditText.setError(null);
            mobileEditText.requestFocus();
            return;
        }
        if (!Patterns.PHONE.matcher(phone).matches()) {
            nameEditText.setError(null);
            emailEditText.setError(null);
            mobileEditText.setError("Please enter correct phone number !!");
            passwordEditText.setError(null);
            confirmPasswordEditText.setError(null);
            mobileEditText.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            nameEditText.setError(null);
            emailEditText.setError(null);
            mobileEditText.setError(null);
            passwordEditText.setError("Enter your password !!");
            confirmPasswordEditText.setError(null);
            passwordEditText.requestFocus();
            return;
        }
        if (password.length() < 6) {
            nameEditText.setError(null);
            emailEditText.setError(null);
            mobileEditText.setError(null);
            passwordEditText.setError("Password is too short !!");
            confirmPasswordEditText.setError(null);
            passwordEditText.requestFocus();
            return;
        }
        if (confirmPasswordEditText.getText().toString().isEmpty()) {
            nameEditText.setError(null);
            emailEditText.setError(null);
            passwordEditText.setError(null);
            mobileEditText.setError(null);
            confirmPasswordEditText.setError("Please enter password again !!");
            confirmPasswordEditText.requestFocus();
            return;
        }
        if (!password.equals(confirmPasswordEditText.getText().toString())) {
            nameEditText.setError(null);
            emailEditText.setError(null);
            passwordEditText.setError(null);
            mobileEditText.setError(null);
            confirmPasswordEditText.setError("Password is not matching !!");
            confirmPasswordEditText.requestFocus();
            return;
        }
        nameEditText.setError(null);
        emailEditText.setError(null);
        passwordEditText.setError(null);
        mobileEditText.setError(null);
        confirmPasswordEditText.setError(null);
        confirmCheckBox.setEnabled(true);
        
        createUserAccount(name,email,password,phone);
    }

    private void createUserAccount(final String name, final String email, final String password, final String phone) {
        progressDialog.setMessage("Please Wait !!");
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        saveDataToFireBaseDataBase(email,password,phone,name);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast toast = Toast.makeText(RegisterUserActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }
                });
    }

    private void saveDataToFireBaseDataBase(String email, String password, String phone, String name) {
        final String timestamp = "" + System.currentTimeMillis();
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("name",name);
        hashMap.put("email",email);
        hashMap.put("password",password);
        hashMap.put("phone",phone);
        hashMap.put("joining_date",Methods.getJoiningDate());
        hashMap.put("status","Online");
        hashMap.put("timestamp",timestamp);
        reference.child(mAuth.getUid()).setValue(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progressDialog.dismiss();
                        startActivity(new Intent(RegisterUserActivity.this,HomeActivity.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast toast = Toast.makeText(RegisterUserActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }
                });
    }

    private void intializeComponent() {
        nameEditText = findViewById(R.id.name_edit_text);
        emailEditText = findViewById(R.id.email_address_edittext);
        mobileEditText = findViewById(R.id.phone_number_edittext);
        passwordEditText = findViewById(R.id.password_edittext);
        confirmPasswordEditText = findViewById(R.id.confirm_password_edittext);
        confirmCheckBox = findViewById(R.id.checkBox);
        signUpButton = findViewById(R.id.sign_up_button);
    }

    public void openLoginActivity(View view) {
        startActivity(new Intent(RegisterUserActivity.this,LoginActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Do you want to exit ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }
}