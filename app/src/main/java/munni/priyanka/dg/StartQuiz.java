package munni.priyanka.dg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class StartQuiz extends AppCompatActivity {

    String language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);
        language = getIntent().getStringExtra("language");
        if (language.equals("c")){
            getSupportActionBar().setTitle("C Programmig Language:");
            Toast.makeText(StartQuiz.this,"C Language",Toast.LENGTH_LONG).show();
        }
        else if (language.equals("c++")){
            getSupportActionBar().setTitle("C++ Programmig Language:");
            Toast.makeText(StartQuiz.this,"C++ Language",Toast.LENGTH_LONG).show();
        }
        else if (language.equals("java")){
            getSupportActionBar().setTitle("Java:");
            Toast.makeText(StartQuiz.this,"Java",Toast.LENGTH_LONG).show();
        }
        else if (language.equals("python")){
            getSupportActionBar().setTitle("Python:");
            Toast.makeText(StartQuiz.this,"Python",Toast.LENGTH_LONG).show();
        }
        else if (language.equals("android")){
            getSupportActionBar().setTitle("Android:");
            Toast.makeText(StartQuiz.this,"Android",Toast.LENGTH_LONG).show();
        }
        else if (language.equals("sql")){
            getSupportActionBar().setTitle("SQL:");
            Toast.makeText(StartQuiz.this,"SQL",Toast.LENGTH_LONG).show();
        }
    }
}