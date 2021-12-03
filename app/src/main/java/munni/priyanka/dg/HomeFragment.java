package munni.priyanka.dg;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private AdView adView;
    private Button bca;
    private TextView viewAllQuiz;
    private LinearLayout cprogramming,cplusplusprogramming, javaprogramming, pythonprogramming, androidprogramming, sqlprogramming;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        adView = view.findViewById(R.id.adView);
        viewAllQuiz = view.findViewById(R.id.View_All);
        cprogramming = view.findViewById(R.id.c_programming);
        cplusplusprogramming = view.findViewById(R.id.cplusplus_programming);
        javaprogramming = view.findViewById(R.id.java_programming);
        pythonprogramming = view.findViewById(R.id.python_programming);
        androidprogramming = view.findViewById(R.id.android_programming);
        sqlprogramming = viewAllQuiz.findViewById(R.id.sql_programming);
        showAds();
        bca = view.findViewById(R.id.bca);
        bca.setOnClickListener(this);
        return view;
    }

    private void showAds() {
        MobileAds.initialize(getActivity(),"ca-app-pub-3940256099942544~3347511713");
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        AdRequest request = builder.build();
        adView.loadAd(request);
    }

    @Override
    public void onClick(View view) {
        Intent quizIntent = new Intent(getActivity(),StartQuiz.class);
        switch (view.getId()){
            case R.id.bca:
                Intent intent = new Intent(getActivity(),ShowNoOfSemesterActivity.class);
                intent.putExtra("course","BCA");
                startActivity(intent);
            break;
            case R.id.View_All:
                Toast.makeText(getActivity(),"View All is clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.c_programming:
                quizIntent.putExtra("language","c");
                startActivity(quizIntent);
                break;
            case R.id.cplusplus_programming:
                quizIntent.putExtra("language","c++");
                startActivity(quizIntent);
                break;
            case R.id.java_programming:
                quizIntent.putExtra("language","java");
                startActivity(quizIntent);
                break;
            case R.id.python_programming:
                quizIntent.putExtra("language","python");
                startActivity(quizIntent);
                break;
            case R.id.android_programming:
                quizIntent.putExtra("language","android");
                startActivity(quizIntent);
                break;
            case R.id.sql_programming:
                quizIntent.putExtra("language","sql");
                startActivity(quizIntent);
                break;
            default:
                break;
        }
    }
}