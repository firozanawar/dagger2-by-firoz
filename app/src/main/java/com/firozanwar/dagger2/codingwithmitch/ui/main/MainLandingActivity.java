package com.firozanwar.dagger2.codingwithmitch.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.firozanwar.dagger2.R;
import com.firozanwar.dagger2.codingwithmitch.BaseActivity;
import com.firozanwar.dagger2.codingwithmitch.ui.main.profile.ProfileFragment;

public class MainLandingActivity extends BaseActivity {

    private static final String TAG = "MainLanActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_landing);

        Toast.makeText(MainLandingActivity.this, "Welcome to the MainActivity", Toast.LENGTH_LONG).show();
        testFragment();
    }

    private void testFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container,new ProfileFragment())
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.lagout:
                sessionManager.logout();
                return true;

            case android.R.id.home: {
//                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
//                    drawerLayout.closeDrawer(GravityCompat.START);
//                    return true;
//                }
//                else{
//                    return false;
//                }
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
