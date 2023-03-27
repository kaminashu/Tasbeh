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
import android.widget.TextView;

import tasbeh.avest.onamuchun.FragmentPacge.MenuFragment;
import tasbeh.avest.onamuchun.R;

public class RamazonDuosiActivity extends AppCompatActivity {
    ImageView imageView, menu;
    TextView textView, textView2, textView3, textView4, textView5;
    AppCompatButton appCompatButton;
    FrameLayout frameLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramazon_duosi);


        imageView = findViewById(R.id.main_meniu_img_btn_duolar);
        menu = findViewById(R.id.imageView_duolar);
        frameLayout = findViewById(R.id.menu_fragment_id_duolar);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView4);
        textView3 = findViewById(R.id.textView8);
        textView4 = findViewById(R.id.textView5);
        textView5 = findViewById(R.id.textView9);

        menu.setOnClickListener(view -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.menu_fragment_id_duolar, new MenuFragment())
                    .commitAllowingStateLoss();
            frameLayout.setVisibility(View.VISIBLE);
        });

        imageView.setOnClickListener(view -> {
            Intent intent = new Intent(RamazonDuosiActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}