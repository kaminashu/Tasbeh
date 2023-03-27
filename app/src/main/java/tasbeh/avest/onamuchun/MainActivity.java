package tasbeh.avest.onamuchun;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import tasbeh.avest.onamuchun.FragmentPacge.MenuFragment;
import tasbeh.avest.onamuchun.FragmentPacge.NamozFragment;
import tasbeh.avest.onamuchun.R;
import tasbeh.avest.onamuchun.database.AppDatabase;
import tasbeh.avest.onamuchun.database.UserDao;
import tasbeh.avest.onamuchun.database.UserModel;

public class MainActivity extends AppCompatActivity {

    AppCompatButton appCompatButton, chiqish, tasbehz, namoz_tasbeh;
    ImageView imageView;
    AppDatabase db;
    FrameLayout layout, layout2;

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appCompatButton = findViewById(R.id.sanash_btn);
        imageView = findViewById(R.id.menue_btn_img);

        tasbehz = findViewById(R.id.android_tasbeh);
        namoz_tasbeh = findViewById(R.id.appCompatButton_namoz_tasbehi);

        layout = findViewById(R.id.menu_fragment_id);
        layout2 = findViewById(R.id.namoz_tasbehi_fragmanet);

        tasbehz.setOnClickListener(view -> {

            OnClickTasbeh();
        });

        namoz_tasbeh.setOnClickListener(view -> {

            OnClickNamozTasbeh();
        });
        imageView.setOnClickListener(view -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.menu_fragment_id, new MenuFragment())
                    .commitAllowingStateLoss();
            layout.setVisibility(View.VISIBLE);
        });

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();


        appCompatButton.setOnClickListener(view -> {
            layout.setVisibility(View.GONE);
            String butn_text = appCompatButton.getText().toString();

            if (butn_text.equals("BOSHLASH")) {
                int raqam = 0 + 1;
                appCompatButton.setText(String.valueOf(raqam));
                new InsertMain().execute();
            } else {
                int son;
                son = Integer.parseInt(appCompatButton.getText().toString());
                son = son + 1;
                appCompatButton.setText(String.valueOf(son));
                new InsertMain().execute();
            }
        });
        new ShowDateFormDatabaseMainAcynTask().execute();
    }

    @SuppressLint("ResourceAsColor")
    public void OnClickNamozTasbeh() {
       namoz_tasbeh.setBackgroundResource(R.drawable.background_button_raund_on);
       tasbehz.setBackgroundResource(R.drawable.background_button_raund_off);
        namoz_tasbeh.setTextColor(R.color.yellow);
        layout.setVisibility(View.GONE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.namoz_tasbehi_fragmanet, new NamozFragment())
                .commitAllowingStateLoss();
        layout2.setVisibility(View.VISIBLE);
    }

    @SuppressLint("ResourceAsColor")
    public void OnClickTasbeh() {
       namoz_tasbeh.setBackgroundResource(R.drawable.background_button_raund_off);
        tasbehz.setBackgroundResource(R.drawable.background_button_raund_on);
        layout.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);
        namoz_tasbeh.setTextColor(R.color.black);
        tasbehz.setTextColor(R.color.white);
    }

    public class ShowDateFormDatabaseMainAcynTask extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("ish tohtadi", "users");

        }

        @Override
        protected String doInBackground(Void... params) {
            final UserDao userDao = db.userDao();
            userDao.getAll();
            String users = "";
            Integer size = userDao.getAll().size();
            if (size > 0) {
                users = userDao.getAll().get(userDao.getAll().size() - 1).name;
                appCompatButton.setText(users);
            } else {
                appCompatButton.setText("BOSHLASH");
            }
            return "3";
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("ish tohtadi", result);
            String text_uchun;
            text_uchun = result;

        }
    }

    public class InsertMain extends AsyncTask<Void, Void, String> {
        @Override
        public void onPreExecute() {
            super.onPreExecute();
            Log.d("ish boshlandi", "1");


        }

        @Override
        protected String doInBackground(Void... params) {
            final UserDao userDao = db.userDao();
            UserModel userModel = new UserModel();
            userModel.name = appCompatButton.getText().toString();
            userDao.insertAll(userModel);

            return "true";
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("ish bazaga saqlandi", result);
        }
    }
}