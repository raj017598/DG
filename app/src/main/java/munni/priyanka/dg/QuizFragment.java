package munni.priyanka.dg;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class QuizFragment extends Fragment implements View.OnClickListener {

    LinearLayout clanguage, cPlusPlus, java, python, android, sql;
    public QuizFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        clanguage = view.findViewById(R.id.c_language);
        cPlusPlus = view.findViewById(R.id.cplusplus);
        java = view.findViewById(R.id.java);
        python = view.findViewById(R.id.python);
        android = view.findViewById(R.id.android);
        sql = view.findViewById(R.id.sql);
        clanguage.setOnClickListener(this);
        cPlusPlus.setOnClickListener(this);
        java.setOnClickListener(this);
        python.setOnClickListener(this);
        android.setOnClickListener(this);
        sql.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(),StartQuiz.class);
        switch (view.getId()) {
            case R.id.c_language:
                intent.putExtra("language","c");
                startActivity(intent);
                break;
            case R.id.cplusplus:
                intent.putExtra("language","c++");
                startActivity(intent);
                break;
            case R.id.java:
                intent.putExtra("language","java");
                startActivity(intent);
                break;
            case R.id.python:
                intent.putExtra("language","python");
                startActivity(intent);
                break;
            case R.id.android:
                intent.putExtra("language","android");
                startActivity(intent);
                break;
            case R.id.sql:
                intent.putExtra("language","sql");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}