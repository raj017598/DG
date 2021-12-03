package munni.priyanka.dg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowNoOfSemesterActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private String semester1[] = {"Semester-1", "Semester-2", "Semester-3", "Semester-4","Semester-5", "Semester-6","Placement Notification","Placement Material"};
    private String semester2[] = {"Semester-1", "Semester-2", "Semester-3", "Semester-4","Semester-5", "Semester-6","Semester-7", "Semester-8","Placement Notification","Placement Material"};
    private ArrayAdapter<String> adapter;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_no_of_semester);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#240b36"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        str = getIntent().getStringExtra("course");

        Log.e("Str",str);

        getSupportActionBar().setTitle(str);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = findViewById(R.id.listView);

        if(str.equalsIgnoreCase("btech"))
        {
            adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.semester_button_layout,semester2);
            listView.setAdapter(adapter);
        }
        else if(str.equalsIgnoreCase("mca"))
        {
            adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.semester_button_layout,semester1);
            listView.setAdapter(adapter);
        }

        else if(str.equalsIgnoreCase("BCA"))
        {
            adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.semester_button_layout,semester1);
            listView.setAdapter(adapter);
        }
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Log.e("Button","is Clicked");
        if(position == 7)
        {
            Intent intent1 = new Intent(getApplicationContext(),ShowQuestionPaperActivity.class);
            String strq = adapter.getItem(position);
            intent1.putExtra("year",strq);
            intent1.putExtra("subject","pm");
            startActivity(intent1);
            return;
        }
        if(position == 6)
        {
            Intent intent1 = new Intent(getApplicationContext(),ShowQuestionPaperActivity.class);
            String strq = adapter.getItem(position);
            intent1.putExtra("year",strq);
            intent1.putExtra("subject","pn");
            startActivity(intent1);
            return;
        }
            Intent intent = new Intent(getApplicationContext(),ShowSubjectOfActivity.class);
            String strq = adapter.getItem(position);
            intent.putExtra("course",str);
            intent.putExtra("semester",strq);
            startActivity(intent);
    }
}