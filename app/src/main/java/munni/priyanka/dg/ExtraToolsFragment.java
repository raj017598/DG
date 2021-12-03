package munni.priyanka.dg;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ExtraToolsFragment extends Fragment implements View.OnClickListener {

    private AdView calculatorAdView, ScientificCalculatorAdView, timerAdView,logTableAdview,TrigoAdView;
    private Button calculator, scientificCalculator, timer;
    public ExtraToolsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_extra_tools, container, false);
        calculatorAdView = view.findViewById(R.id.calculator_adview);
        ScientificCalculatorAdView = view.findViewById(R.id.scientific_calculator_adview);
        timerAdView = view.findViewById(R.id.timer_adview);
        logTableAdview = view.findViewById(R.id.log_table_adview);
        TrigoAdView = view.findViewById(R.id.trigonometric_equations_adview);
        calculator = view.findViewById(R.id.calculator);
        scientificCalculator = view.findViewById(R.id.scientific_calculator);
        timer = view.findViewById(R.id.timer);
        calculator.setOnClickListener(this);
        scientificCalculator.setOnClickListener(this);
        timer.setOnClickListener(this);
        showAds();
        return view;
    }

    private void showAds() {
        MobileAds.initialize(getActivity(),"ca-app-pub-3940256099942544~3347511713");
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        AdRequest request = builder.build();
        calculatorAdView.loadAd(request);

        AdRequest.Builder builder1 = new AdRequest.Builder();
        builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        AdRequest request1 = builder1.build();
        ScientificCalculatorAdView.loadAd(request1);

        AdRequest.Builder builder2 = new AdRequest.Builder();
        builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        AdRequest request2 = builder2.build();
        timerAdView.loadAd(request);

        AdRequest.Builder builder3 = new AdRequest.Builder();
        builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        AdRequest request3 = builder3.build();
        TrigoAdView.loadAd(request3);

        AdRequest.Builder builder5 = new AdRequest.Builder();
        builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        AdRequest request5 = builder5.build();
        logTableAdview.loadAd(request5);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.calculator:
                startActivity(new Intent(getActivity(),CalculatorActivity.class));
                getActivity().finish();
                break;
            case R.id.scientific_calculator:
                startActivity(new Intent(getActivity(),ScientificCalculatorActivity.class));
                getActivity().finish();
                break;
            case R.id.timer:
                startActivity(new Intent(getActivity(),TimerActivity.class));
                getActivity().finish();
                break;
            default:
                break;
        }
    }
}