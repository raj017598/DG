package munni.priyanka.dg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class ShowSubjectNotesList extends AppCompatActivity {

    String subject, semester, course, college, university;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_subject_notes_list);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#232D36"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        course = getIntent().getStringExtra("course");
        semester = getIntent().getStringExtra("semester");
        subject = getIntent().getStringExtra("subject_name");
        if (subject.equals("bca105") || subject.equals("bca106") || subject.equals("bca107") || subject.equals("bca108") || subject.equals("bca205") || subject.equals("bca206") || subject.equals("bca207") || subject.equals("bca208") ||subject.equals("bca305") || subject.equals("bca308") || subject.equals("bca306") || subject.equals("bca307") || subject.equals("bca407") || subject.equals("bca406") || subject.equals("bca404") || subject.equals("bca405") || subject.equals("bca507") || subject.equals("bca506") || subject.equals("bca504") || subject.equals("bca505") ||subject.equals("bca606") || subject.equals("bca607") || subject.equals("bca604") || subject.equals("bca605"))
        {
            college = getIntent().getStringExtra("college");
            university = getIntent().getStringExtra("university");
        }
        showFiles();
    }

    private void showFiles() {

        Intent bookIntent = new Intent(this,ShowBookListActivity.class);
        Intent i = new Intent(this, ShowQuestionPaperActivity.class);
        if(subject.equals("bca101"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca102"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca103"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca104"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca105"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca106"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca107"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca108"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca109"))
        {
            bookIntent.putExtra("subject",subject);
            startActivity(bookIntent);
            finish();
        }
        else if(subject.equals("bca201"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca202"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca20_1"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca203"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca204"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca205"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca206"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca207"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca208"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca209"))
        {
            bookIntent.putExtra("subject",subject);
            startActivity(bookIntent);
            finish();
        }
        else if(subject.equals("bca301"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca302"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca303"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca304_2"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca304_1"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca305"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca306"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca307"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca308"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca309*"))
        {
            bookIntent.putExtra("subject",subject);
            startActivity(bookIntent);
            finish();
        }
        else if(subject.equals("bca401"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca402"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca403"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca404"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca405"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca406"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca407"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca408"))
        {
            bookIntent.putExtra("subject",subject);
            startActivity(bookIntent);
            finish();
        }
        else if(subject.equals("bca501"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca502"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }

        else if(subject.equals("bca503"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca504"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca505"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca506"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject", subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca507"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca508"))
        {
            bookIntent.putExtra("subject",subject);
            startActivity(bookIntent);
            finish();
        }
        else if(subject.equals("bca601"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca602"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca603"))
        {
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca604"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca605"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca606"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca607"))
        {
            i.putExtra("college",college);
            i.putExtra("unicersity",university);
            i.putExtra("subject",subject);
            startActivity(i);
            finish();
        }
        else if(subject.equals("bca608"))
        {
            bookIntent.putExtra("subject",subject);
            startActivity(bookIntent);
            finish();
        }
    }
}
