package tasbeh.avest.onamuchun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import tasbeh.avest.onamuchun.FragmentPacge.MenuFragment;
import tasbeh.avest.onamuchun.database.AppDatabase;
import tasbeh.avest.onamuchun.database.UserDao;
import tasbeh.avest.onamuchun.database.UserModel;
import tasbeh.avest.onamuchun.R;

public class QushishActivity extends AppCompatActivity {
    AppCompatButton chiqish, saqlash;
    EditText editText;
    TextView textView, info;
    ImageView menu, main_menu;
    FrameLayout frameLayout;
    AppDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qushish);

        saqlash = findViewById(R.id.data_save_app_btn);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView_Qushish);
        info = findViewById(R.id.textView_qushish_info);
        menu = findViewById(R.id.imageView_sozlash);
        main_menu = findViewById(R.id.main_meniu_img_btn_sozlash);
        frameLayout = findViewById(R.id.menu_fragment_id_qushish);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
        menu.setOnClickListener(v -> {
            OnClickMenu();
        });
        saqlash.setOnClickListener(v -> {
            OnClickSaqlash();
        });

        main_menu.setOnClickListener(v -> {
            OnClickMainMenu();
        });
    }

    public void OnClickMenu() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.menu_fragment_id_qushish, new MenuFragment())
                .commitAllowingStateLoss();
        frameLayout.setVisibility(View.VISIBLE);
    }



    public void OnClickMainMenu() {
        Intent intent = new Intent(QushishActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void OnClickSaqlash() {
        new InsertSozlash().execute();
    }

    public class InsertSozlash extends AsyncTask<Void, Void, String> {
        @Override
        public void onPreExecute() {
            super.onPreExecute();
            Log.d("ish boshlandi", "1");


        }

        @Override
        protected String doInBackground(Void... params) {
            final UserDao userDao = db.userDao();
            UserModel userModel = new UserModel();
            if (editText.getText().toString().length() > 0) {

                Intent intent = new Intent(QushishActivity.this, MainActivity.class);
                startActivity(intent);
                userModel.name = editText.getText().toString();
                userDao.insertAll(userModel);
                return "true";
            } else {
                return "false";
            }


        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("ish bazaga saqlandi", result);
            if (result.equals("true")) {
                Toast.makeText(QushishActivity.this, "Saqlandi", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(QushishActivity.this, "Son kirgazing", Toast.LENGTH_LONG).show();
            }

        }
    }


}