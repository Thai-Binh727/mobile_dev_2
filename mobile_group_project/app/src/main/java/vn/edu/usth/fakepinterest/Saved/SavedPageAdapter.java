package vn.edu.usth.fakepinterest.Saved;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.fakepinterest.Homepage.HomePageAdapter;
import vn.edu.usth.fakepinterest.Notification.InboxFragment;
import vn.edu.usth.fakepinterest.Notification.UpdateFragment;
public class SavedPageAdapter extends FragmentStateAdapter{

    public SavedPageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }
    @NonNull
    public Fragment createFragment(int position) {
        return position == 0 ? new PinsFragment() : new BoardsFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}