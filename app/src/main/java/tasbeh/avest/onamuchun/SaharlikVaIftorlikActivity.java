package tasbeh.avest.onamuchun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import tasbeh.avest.onamuchun.FragmentPacge.MenuFragment;
import tasbeh.avest.onamuchun.R;

public class SaharlikVaIftorlikActivity extends AppCompatActivity {
    ImageView imageView, menue;
    ScrollView scrollView;
    TextView textView;
    AppCompatButton appCompatButton;
    FrameLayout frameLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saharlik_va_iftorlik);
        menue = findViewById(R.id.imageView);
        imageView = findViewById(R.id.main_meniu_img_btn);
        scrollView = findViewById(R.id.scrol_view);
        textView = findViewById(R.id.textView);
        frameLayout = findViewById(R.id.menu_fragment_id_saharlik_va_iftorlik);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(SaharlikVaIftorlikActivity.this, MainActivity.class);
            startActivity(intent);
        });
        menue.setOnClickListener(v -> {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.menu_fragment_id_saharlik_va_iftorlik, new MenuFragment())
                    .commitAllowingStateLoss();
        });

    }
}