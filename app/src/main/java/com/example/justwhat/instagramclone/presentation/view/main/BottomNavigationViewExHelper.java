package com.example.justwhat.instagramclone.presentation.view.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.example.justwhat.instagramclone.R;
import com.example.justwhat.instagramclone.presentation.view.account.Account;
import com.example.justwhat.instagramclone.presentation.view.add.Add;
import com.example.justwhat.instagramclone.presentation.view.newsFeed.NewsFeed;
import com.example.justwhat.instagramclone.presentation.view.notifications.Notifications;
import com.example.justwhat.instagramclone.presentation.view.search.Search;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewExHelper {

    @SuppressLint("StaticFieldLeak")
    private static NewsFeed fragmentNewsFeed;
    @SuppressLint("StaticFieldLeak")
    private static Search fragmentSearch;
    @SuppressLint("StaticFieldLeak")
    private static Add fragmentAdd;
    @SuppressLint("StaticFieldLeak")
    private static Notifications fragmentNotifications;
    @SuppressLint("StaticFieldLeak")
    private static Account fragmentAccount;

    public static void setBottomNavigationViewEx(BottomNavigationViewEx bottomNavigationViewEx) {

        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);

    }

    public static void setNavigation(final Context context, BottomNavigationViewEx bottomNavigationViewEx) {

        setClasses();

        Menu menu = bottomNavigationViewEx.getMenu();

        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.bottom_navigation_view_news_feed:
                        replaceFragment(context, fragmentNewsFeed, "FRAGMENT_NEWS_FEED");
                        setCheck(menu, R.id.bottom_navigation_view_news_feed);
                        break;
                    case R.id.bottom_navigation_view_search:
                        replaceFragment(context, fragmentSearch, "FRAGMENT_SEARCH");
                        setCheck(menu, R.id.bottom_navigation_view_search);
                        break;
                    case R.id.bottom_navigation_view_add:
                        replaceFragment(context, fragmentAdd, "FRAGMENT_ADD");
                        setCheck(menu, R.id.bottom_navigation_view_add);
                        break;
                    case R.id.bottom_navigation_view_notifications:
                        replaceFragment(context, fragmentNotifications, "FRAGMENT_NOTIFICATIONS");
                        setCheck(menu, R.id.bottom_navigation_view_notifications);
                        break;
                    case R.id.bottom_navigation_view_account:
                        replaceFragment(context, fragmentAccount, "FRAGMENT_ACCOUNT");
                        setCheck(menu, R.id.bottom_navigation_view_account);
                        break;

                }

                return false;
            }
        });

    }

    private static void setCheck(Menu menu, int id){

        MenuItem menuItem = null;

        switch (id){

            case R.id.bottom_navigation_view_news_feed:
                menuItem = menu.getItem(0);
                break;
            case R.id.bottom_navigation_view_search:
                menuItem = menu.getItem(1);
                break;
            case R.id.bottom_navigation_view_add:
                menuItem = menu.getItem(2);
                break;
            case R.id.bottom_navigation_view_notifications:
                menuItem = menu.getItem(3);
                break;
            case R.id.bottom_navigation_view_account:
                menuItem = menu.getItem(4);
                break;

        }

        menuItem.setChecked(true);

    }

    private static void replaceFragment(Context context, Fragment fragment, String tag) {

        FragmentTransaction fragmentTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main_main_container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    private static void setClasses() {

        fragmentNewsFeed = new NewsFeed();
        fragmentSearch = new Search();
        fragmentAdd = new Add();
        fragmentNotifications = new Notifications();
        fragmentAccount = new Account();

    }

}
