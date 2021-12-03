package munni.priyanka.dg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactUsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CALL_PHONE_REQUEST_CODE = 1001;
    private Button callButton, gmailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        callButton = findViewById(R.id.call_button);
        gmailButton = findViewById(R.id.gmail_message);
        gmailButton.setOnClickListener(this);
        callButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gmail_message:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"elearningdigi@gmail.com"});
                intent.setType("message/rfc822");
                startActivity(intent);
                break;
            case R.id.call_button:{
                Intent intent1 = new Intent(Intent.ACTION_CALL);
                intent1.setData(Uri.parse("tel:6200402873"));
                if (checkPermission())
                {
                    startActivity(intent1);
                }
                else
                {
                    requestPermission();
                }
                break;
            }
        }
    }

    private boolean checkPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        requestPermissions(new String[]{Manifest.permission.CALL_PHONE},CALL_PHONE_REQUEST_CODE);
    }
}