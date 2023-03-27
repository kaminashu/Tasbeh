package tasbeh.avest.onamuchun.FragmentPacge;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


import tasbeh.avest.onamuchun.RamazonDuosiActivity;
import tasbeh.avest.onamuchun.QushishActivity;
import tasbeh.avest.onamuchun.R;
import tasbeh.avest.onamuchun.SaharlikVaIftorlikActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {
AppCompatButton qushish,namoz_taqvimi,saxarlik_va_iftorlik,yopish;
FrameLayout frameLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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
        View view = inflater.inflate(R.layout.fragment_menu,
                container, false);

        namoz_taqvimi=view.findViewById(R.id.NamozTaqvimi);
        saxarlik_va_iftorlik=view.findViewById(R.id.IftorlikVaSaharlik);
        qushish=view.findViewById(R.id.Qushish);
        yopish=view.findViewById(R.id.Yopish);

        yopish.setOnClickListener(v -> {
            view.setVisibility(View.GONE);
        });
        qushish.setOnClickListener(view1 ->{
            Intent intent = new Intent(getActivity(), QushishActivity.class);
            startActivity(intent);
        });
        namoz_taqvimi.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), RamazonDuosiActivity.class);
            startActivity(intent);

        });
        saxarlik_va_iftorlik.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), SaharlikVaIftorlikActivity.class);
            startActivity(intent);
        });

        // Inflate the layout for this fragment

        return view;

    }
}