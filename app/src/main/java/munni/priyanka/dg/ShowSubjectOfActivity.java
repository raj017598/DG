package munni.priyanka.dg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class ShowSubjectOfActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout sem_1, sem_2, sem_3, sem_4, sem_5, sem_6;
    private Button bca101, bca102, bca103, bca104, bca105, bca106, bca107, bca108, bca109;
    private Button bca201, bca202, bca20_1, bca203, bca204, bca205, bca206, bca207, bca208, bca209;
    private Button bca301, bca302, bca303, bca304_1, bca304_2, bca305, bca306, bca307, bca308, bca309;
    private  Button bca401,bca402, bca403, bca404, bca405, bca406, bca407, bca408;
    private Button bca501, bca502, bca503, bca504, bca505, bca506, bca507, bca508;
    private Button bca601, bca602, bca603, bca604, bca605, bca606, bca607, bca608;
    String course, semester;
    Intent intent, intent1;
    Spinner collge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_subject_of);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#232D36"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Subject");
        if(!isOnline())
        {
            Toast.makeText(this,"Please turn on Internet Connection to continue",Toast.LENGTH_SHORT).show();
            ShowSubjectOfActivity.this.startActivity(new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS));
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Please Turn on Internet Connection to Continue.");
                builder.setTitle("Warning !");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
            catch (Exception e)
            {
                Toast.makeText(this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        initialize();
        course = getIntent().getStringExtra("course");
        semester = getIntent().getStringExtra("semester");
        intent = new Intent(this,ShowSubjectNotesList.class);
        intent1 = new Intent(this,ShowBookListActivity.class);

        showCourseBAsedOnSemester();

    }

    private boolean isOnline() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if(info == null || !info.isConnected() || !info.isAvailable())
        {
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
            return  false;
        }
        return  true;
    }

    public void initialize()
    {

        sem_1 = findViewById(R.id.sem_1);
        sem_2 = findViewById(R.id.sem_2);
        sem_3 = findViewById(R.id.sem_3);
        sem_4 = findViewById(R.id.sem_4);
        sem_5 = findViewById(R.id.sem_5);
        sem_6 = findViewById(R.id.sem_6);

        bca101 = findViewById(R.id.bca_101);
        bca102 = findViewById(R.id.bca_102);
        bca103 = findViewById(R.id.bca_103);
        bca104 = findViewById(R.id.bca_104);
        bca105 = findViewById(R.id.bca_105);
        bca106 = findViewById(R.id.bca_106);
        bca107 = findViewById(R.id.bca_107);
        bca108 = findViewById(R.id.bca_108);
        bca109 = findViewById(R.id.bca_109);
        bca201 = findViewById(R.id.bca_201);
        bca202 = findViewById(R.id.bca_202);
        bca20_1 = findViewById(R.id.bca_20_1);
        bca203 = findViewById(R.id.bca_203);
        bca204 = findViewById(R.id.bca_204);
        bca205 = findViewById(R.id.bca_205);
        bca206 = findViewById(R.id.bca_206);
        bca207 = findViewById(R.id.bca_207);
        bca208 = findViewById(R.id.bca_208);
        bca209 = findViewById(R.id.bca_209);
        bca301 = findViewById(R.id.bca_301);
        bca302 = findViewById(R.id.bca_302);
        bca303 = findViewById(R.id.bca_303);
        bca304_1 = findViewById(R.id.bca_304_1);
        bca304_2 = findViewById(R.id.bca_304_2);
        bca305 = findViewById(R.id.bca_305);
        bca306 = findViewById(R.id.bca_306);
        bca307 = findViewById(R.id.bca_307);
        bca308 = findViewById(R.id.bca_308);
        bca309 = findViewById(R.id.bca_309);
        bca401 = findViewById(R.id.bca_401);
        bca402 = findViewById(R.id.bca_402);
        bca403 = findViewById(R.id.bca_403);
        bca404 = findViewById(R.id.bca_404);
        bca405 = findViewById(R.id.bca_405);
        bca406 = findViewById(R.id.bca_406);
        bca407 = findViewById(R.id.bca_407);
        bca408 = findViewById(R.id.bca_408);
        bca501 = findViewById(R.id.bca_501);
        bca502 = findViewById(R.id.bca_502);
        bca503 = findViewById(R.id.bca_503);
        bca504 = findViewById(R.id.bca_504);
        bca505 = findViewById(R.id.bca_505);
        bca506 = findViewById(R.id.bca_506);
        bca507 = findViewById(R.id.bca_507);
        bca508 = findViewById(R.id.bca_508);
        bca601 = findViewById(R.id.bca_601);
        bca602 = findViewById(R.id.bca_602);
        bca603 = findViewById(R.id.bca_603);
        bca604 = findViewById(R.id.bca_604);
        bca605 = findViewById(R.id.bca_605);
        bca606 = findViewById(R.id.bca_606);
        bca607 = findViewById(R.id.bca_607);
        bca608 = findViewById(R.id.bca_608);
        bca101.setOnClickListener(this);
        bca102.setOnClickListener(this);
        bca103.setOnClickListener(this);
        bca104.setOnClickListener(this);
        bca105.setOnClickListener(this);
        bca106.setOnClickListener(this);
        bca107.setOnClickListener(this);
        bca108.setOnClickListener(this);
        bca109.setOnClickListener(this);
        bca201.setOnClickListener(this);
        bca202.setOnClickListener(this);
        bca20_1.setOnClickListener(this);
        bca203.setOnClickListener(this);
        bca204.setOnClickListener(this);
        bca205.setOnClickListener(this);
        bca206.setOnClickListener(this);
        bca207.setOnClickListener(this);
        bca208.setOnClickListener(this);
        bca209.setOnClickListener(this);
        bca301.setOnClickListener(this);
        bca302.setOnClickListener(this);
        bca303.setOnClickListener(this);
        bca304_1.setOnClickListener(this);
        bca304_2.setOnClickListener(this);
        bca305.setOnClickListener(this);
        bca306.setOnClickListener(this);
        bca307.setOnClickListener(this);
        bca308.setOnClickListener(this);
        bca309.setOnClickListener(this);
        bca401.setOnClickListener(this);
        bca402.setOnClickListener(this);
        bca403.setOnClickListener(this);
        bca404.setOnClickListener(this);
        bca405.setOnClickListener(this);
        bca406.setOnClickListener(this);
        bca407.setOnClickListener(this);
        bca408.setOnClickListener(this);
        bca501.setOnClickListener(this);
        bca502.setOnClickListener(this);
        bca503.setOnClickListener(this);
        bca504.setOnClickListener(this);
        bca505.setOnClickListener(this);
        bca506.setOnClickListener(this);
        bca507.setOnClickListener(this);
        bca508.setOnClickListener(this);
        bca601.setOnClickListener(this);
        bca602.setOnClickListener(this);
        bca603.setOnClickListener(this);
        bca604.setOnClickListener(this);
        bca605.setOnClickListener(this);
        bca606.setOnClickListener(this);
        bca607.setOnClickListener(this);
        bca608.setOnClickListener(this);
    }
    private void showCourseBAsedOnSemester() {
        if(semester.equalsIgnoreCase("Semester-1"))
        {
            sem_1.setVisibility(View.VISIBLE);
            sem_2.setVisibility(View.GONE);
            sem_3.setVisibility(View.GONE);
            sem_4.setVisibility(View.GONE);
            sem_5.setVisibility(View.GONE);
            sem_6.setVisibility(View.GONE);

        }
        else if(semester.equalsIgnoreCase("Semester-2"))
        {
            sem_1.setVisibility(View.GONE);
            sem_2.setVisibility(View.VISIBLE);
            sem_3.setVisibility(View.GONE);
            sem_4.setVisibility(View.GONE);
            sem_5.setVisibility(View.GONE);
            sem_6.setVisibility(View.GONE);
        }
        else if(semester.equalsIgnoreCase("Semester-3"))
        {
            sem_1.setVisibility(View.GONE);
            sem_2.setVisibility(View.GONE);
            sem_3.setVisibility(View.VISIBLE);
            sem_4.setVisibility(View.GONE);
            sem_5.setVisibility(View.GONE);
            sem_6.setVisibility(View.GONE);
        }
        else if(semester.equalsIgnoreCase("Semester-4"))
        {
            sem_1.setVisibility(View.GONE);
            sem_2.setVisibility(View.GONE);
            sem_3.setVisibility(View.GONE);
            sem_4.setVisibility(View.VISIBLE);
            sem_5.setVisibility(View.GONE);
            sem_6.setVisibility(View.GONE);
        }
        else if(semester.equalsIgnoreCase("Semester-5"))
        {
            sem_1.setVisibility(View.GONE);
            sem_2.setVisibility(View.GONE);
            sem_3.setVisibility(View.GONE);
            sem_4.setVisibility(View.GONE);
            sem_5.setVisibility(View.VISIBLE);
            sem_6.setVisibility(View.GONE);
        }
        else if(semester.equalsIgnoreCase("Semester-6"))
        {
            sem_1.setVisibility(View.GONE);
            sem_2.setVisibility(View.GONE);
            sem_3.setVisibility(View.GONE);
            sem_4.setVisibility(View.GONE);
            sem_5.setVisibility(View.GONE);
            sem_6.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        intent.putExtra("semester",semester);
        intent.putExtra("course",course);
        switch (v.getId())
        {
            case R.id.bca_101:
            {
                intent.putExtra("subject_name","bca101");
                startActivity(intent);
                break;
            }
            case R.id.bca_102:
            {
                intent.putExtra("subject_name","bca102");
                startActivity(intent);
                break;
            }
            case R.id.bca_103:
            {
                intent.putExtra("subject_name","bca103");
                startActivity(intent);
                break;
            }
            case R.id.bca_104:
            {
                intent.putExtra("subject_name","bca104");
                startActivity(intent);
                break;
            }
            case R.id.bca_105:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca105");
                break;
            }
            case R.id.bca_106:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca106");
                break;
            }
            case R.id.bca_107:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca107");
                break;
            }
            case R.id.bca_109:
            {
                intent1.putExtra("subject_name","bca109");
                startActivity(intent1);
                break;
            }
            case R.id.bca_201:
            {
                intent.putExtra("subject_name","bca201");
                startActivity(intent);
                break;
            }
            case R.id.bca_202:
            {
                intent.putExtra("subject_name","bca202");
                startActivity(intent);
                break;
            }

            case R.id.bca_20_1:
            {
                intent.putExtra("subject_name","bca20_1");
                startActivity(intent);
                break;
            }
            case R.id.bca_203:
            {
                intent.putExtra("subject_name","bca203");
                startActivity(intent);
                break;
            }
            case R.id.bca_204:
            {
                intent.putExtra("subject_name","bca204");
                startActivity(intent);
                break;
            }
            case R.id.bca_205:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca205");
                break;
            }
            case R.id.bca_206:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca206");
                break;
            }
            case R.id.bca_207:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca207");
                break;
            }
            case R.id.bca_209:
            {
                intent1.putExtra("subject_name","bca209");
                startActivity(intent1);
                break;
            }
            case R.id.bca_301:
            {
                intent.putExtra("subject_name","bca301");
                startActivity(intent);
                break;
            }
            case R.id.bca_302:
            {
                intent.putExtra("subject_name","bca302");
                startActivity(intent);
                break;
            }
            case R.id.bca_303:
            {
                intent.putExtra("subject_name","bca303");
                startActivity(intent);
                break;
            }
            case R.id.bca_304_1:
            {
                intent.putExtra("subject_name","bca304_1");
                startActivity(intent);
                break;
            }
            case R.id.bca_304_2:
            {
                intent.putExtra("subject_name","bca304_2");
                startActivity(intent);
                break;
            }
            case R.id.bca_305:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca305");
                break;
            }
            case R.id.bca_306:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca306");
                break;
            }
            case R.id.bca_307:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca307");
                break;
            }
            case R.id.bca_309:
            {
                intent1.putExtra("subject_name","bca309");
                startActivity(intent1);
                break;
            }
            case R.id.bca_401:
            {
                intent.putExtra("subject_name","bca401");
                startActivity(intent);
                break;
            }
            case R.id.bca_402:
            {
                intent.putExtra("subject_name","bca402");
                startActivity(intent);
                break;
            }
            case R.id.bca_403:
            {
                intent.putExtra("subject_name","bca403");
                startActivity(intent);
                break;
            }
            case R.id.bca_404:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca404");
                break;
            }
            case R.id.bca_405:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca405");
                break;
            }
            case R.id.bca_406:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca406");
                break;
            }
            case R.id.bca_408:
            {
                intent1.putExtra("subject_name","bca408");
                startActivity(intent1);
                break;
            }
            case R.id.bca_501:
            {
                intent.putExtra("subject_name","bca501");
                startActivity(intent);
                break;
            }
            case R.id.bca_502:
            {
                intent.putExtra("subject_name","bca502");
                startActivity(intent);
                break;
            }
            case R.id.bca_503:
            {
                intent.putExtra("subject_name","bca503");
                startActivity(intent);
                break;
            }
            case R.id.bca_504:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca504");
                break;
            }
            case R.id.bca_505:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca505");
                break;
            }
            case R.id.bca_506:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca506");
                break;
            }
            case R.id.bca_508:
            {
                intent1.putExtra("subject_name","bca508");
                startActivity(intent1);
                break;
            }
            case R.id.bca_601:
            {
                intent.putExtra("subject_name","bca601");
                startActivity(intent);
                break;
            }
            case R.id.bca_602:
            {
                intent.putExtra("subject_name","bca602");
                startActivity(intent);
                break;
            }
            case R.id.bca_603:
            {
                intent.putExtra("subject_name","bca603");
                startActivity(intent);
                break;
            }/*
            case R.id.bca_604:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca604");
                break;
            }
            case R.id.bca_605:
            {
                showAlertDialogToChooseUniversity();
                intent.putExtra("subject_name","bca605");
                break;
            }*/
            case R.id.bca_608:
            {
                intent1.putExtra("subject_name","bca608");
                startActivity(intent1);
                break;
            }
            case R.id.bca_108:
            case R.id.bca_208:
            case R.id.bca_308:
            case R.id.bca_407:
            case R.id.bca_507:
            case R.id.bca_604:
            case R.id.bca_605:
            case R.id.bca_606:
            case R.id.bca_607:
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Information: ");
                builder.setMessage("We will upload very soon. We will inform you when we update this.");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            }
        }
    }

    private void showAlertDialogToChooseUniversity() {
        String  college, university;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Your University:");
        View view = getLayoutInflater().inflate(R.layout.show_choose_university_dialog,null);
        final Spinner universty = (Spinner)view.findViewById(R.id.university);
        collge = (Spinner)view.findViewById(R.id.college);
        collge.setVisibility(View.GONE);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.Default_University_List));
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        universty.setAdapter(adapter);
        universty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showCollege(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(universty.getSelectedItemPosition() == 0)
                {
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Choose University", Toast.LENGTH_LONG).show();
                }
                else
                {
                    intent.putExtra("college",collge.getSelectedItem().toString());
                    intent.putExtra("university",universty.getSelectedItem().toString());
                    dialog.dismiss();
                    startActivity(intent);
                }
            }
        });
        builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showCollege(int position) {
        int id = position;
        switch (id)
        {
            case 0:
            {
                collge.setVisibility(View.GONE);
                break;
            }
            case 1:
            {
                collge.setVisibility(View.VISIBLE);
                collge.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.kolhan)));
                break;
            }
            default:
            {
                collge.setVisibility(View.VISIBLE);
                collge.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.Default_College_List)));
                break;
            }
        }
    }
}
