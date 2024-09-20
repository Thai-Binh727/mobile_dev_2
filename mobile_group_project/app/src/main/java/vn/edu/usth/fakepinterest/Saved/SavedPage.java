package vn.edu.usth.fakepinterest.Saved;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import vn.edu.usth.fakepinterest.MainActivity;
import vn.edu.usth.fakepinterest.Notification.NotificationPagerAdapter;
import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.SearchFragment;
import vn.edu.usth.fakepinterest.SearchPage.SearchEnd;
import vn.edu.usth.fakepinterest.SearchPage.SearchPageClick;
import vn.edu.usth.fakepinterest.ShareFragment;

public class SavedPage extends Fragment {
    ImageButton button_create;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_page, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);

        SavedPageAdapter pagerAdapter = new SavedPageAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(position == 0 ? "Pins" : "Boards");
        }).attach();

        /*ImageButton navigateButton = view.findViewById(R.id.go_to_account);
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new SearchFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.main, clicked).commit();
            }
        });*/

        return view;
    }
}