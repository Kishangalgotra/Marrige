package DashBoard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;

import com.account.bio.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dashBoard extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_bar_dashboard);
        bottomNavigationView.setSelectedItemId(R.id.Home);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment temp =null;
            switch (item.getItemId()) {
                case R.id.Setting:
                    temp = new settingFragment();
                    break;

                case R.id.Home:
                    temp = new HomeFragment();
                    break;

                case R.id.View_BioData:
                    temp = new Viewbiodatafragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,temp).commit();
            return true;
        });
    }
}