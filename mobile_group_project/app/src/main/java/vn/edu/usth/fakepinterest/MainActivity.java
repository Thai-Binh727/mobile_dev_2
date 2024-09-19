package vn.edu.usth.fakepinterest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.fakepinterest.CreatePage.CreatePage;
import vn.edu.usth.fakepinterest.Homepage.HomePage;
import vn.edu.usth.fakepinterest.Homepage.HomePageAdapter;
import vn.edu.usth.fakepinterest.Notification.NotificationPage;
import vn.edu.usth.fakepinterest.Saved.SavedPage;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private HomePageAdapter homePageAdapter;
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        homePageAdapter = new HomePageAdapter(this);
        viewPager2.setAdapter(homePageAdapter);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        frameLayout = findViewById(R.id.frameLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                        tabLayout.getTabAt(position).select();
                }
                super.onPageSelected(position);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        tabLayout.setVisibility(View.VISIBLE);
                        viewPager2.setVisibility(View.VISIBLE);  // Show ViewPager for Home
                        frameLayout.setVisibility(View.GONE);    // Hide frameLayout
                        return true;

                    case R.id.bottom_search:
                        tabLayout.setVisibility(View.GONE);      // Hide tabLayout for other pages
                        viewPager2.setVisibility(View.GONE);     // Hide ViewPager
                        frameLayout.setVisibility(View.VISIBLE); // Show frameLayout
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, new SearchFragment()).commit();
                        return true;

                    case R.id.bottom_create:
                        tabLayout.setVisibility(View.GONE);
                        viewPager2.setVisibility(View.GONE);
                        frameLayout.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, new CreatePage()).commit();
                        return true;

                    case R.id.bottom_notification:
                        tabLayout.setVisibility(View.GONE);
                        viewPager2.setVisibility(View.GONE);
                        frameLayout.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, new NotificationPage()).commit();
                        return true;

                    case R.id.bottom_saved:
                        tabLayout.setVisibility(View.GONE);
                        viewPager2.setVisibility(View.GONE);
                        frameLayout.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, new SavedPage()).commit();
                        return true;
                }
                return false;
            }
        });
    }
}
