package com.example.realmapp.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.realmapp.R;
import com.example.realmapp.fragments.RealmFragment;
import com.example.realmapp.realm.utils.RealmConstants;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRealm();
        showRealmFragment();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count > 1) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(RealmConstants.REALM_DATA_BASE_NAME)
                .schemaVersion(RealmConstants.REALM_DATA_BASE_VERSION)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private void showRealmFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.addToBackStack(RealmFragment.TAG);
        transaction.add(R.id.containerFragment, new RealmFragment(), RealmFragment.TAG).commit();
    }

}
