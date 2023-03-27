package tasbeh.avest.onamuchun.FragmentPacge;

import static android.graphics.Color.GRAY;
import static android.graphics.Color.YELLOW;
import static android.service.controls.ControlsProviderService.TAG;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import tasbeh.avest.onamuchun.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NamozFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NamozFragment extends Fragment {
    CircularProgressBar circularProgressBar;
    ImageView imageView;
    TextView textView,suz_chiqish;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NamozFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NamozFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NamozFragment newInstance(String param1, String param2) {
        NamozFragment fragment = new NamozFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_namoz,
                container, false);

        imageView=view.findViewById(R.id.imageView3);
        circularProgressBar=view.findViewById(R.id.progresss_bar);
        textView=view.findViewById(R.id.textView);
        suz_chiqish=view.findViewById(R.id.suzlar_text_id);

        imageView.setOnClickListener(view1 -> {
            circularProgressBar.setProgressMax(99);
          int boshlangich= Integer.parseInt(textView.getText().toString());

          if(boshlangich<33){
              suz_chiqish.setText("Subhanalloh");
          } else if (boshlangich<66) {
              suz_chiqish.setText("Alhamdulillah");
          } else if (boshlangich<99) {
              suz_chiqish.setText("Allohu Akbar");
          }else{
              boshlangich=-1;
              suz_chiqish.setText("Subhanalloh");
          }
            boshlangich=boshlangich+1;
            circularProgressBar.setProgress(boshlangich);
            textView.setText(String.valueOf(boshlangich));
        });

        return view;
    }

}