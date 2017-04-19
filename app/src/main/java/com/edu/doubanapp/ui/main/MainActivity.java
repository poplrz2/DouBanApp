package com.edu.doubanapp.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.edu.doubanapp.R;
import com.edu.doubanapp.ui.base.BaseAcitvity;
import com.edu.doubanapp.ui.book.BookFragment;
import com.edu.doubanapp.ui.broadcast.BroadcastFragment;
import com.edu.doubanapp.ui.home.HomeFragment;
import com.edu.doubanapp.ui.mine.MineFragment;
import com.edu.doubanapp.ui.team.TeamFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseAcitvity {


    @BindView(R.id.selectbar_rg_mainact) RadioGroup selectbarRgMainact;
    @BindView(R.id.view_flayout_mianact) FrameLayout viewFlayoutMianact;


    private List<Fragment> fragmentList;
    private HomeFragment homeFragment;
    private BookFragment bookFragment;
    private BroadcastFragment broadcastFragment;
    private TeamFragment teamFragment;
    private MineFragment mineFragment;

    public int current=0;

    @Override
    public int layoutContentId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        selectbarRgMainact.check(R.id.home_tbtn_mainact);

        initFragment();

    }

    private void initFragment() {
        fragmentList=new ArrayList<>();
        homeFragment = new HomeFragment();
        bookFragment = new BookFragment();
        broadcastFragment = new BroadcastFragment();
        teamFragment = new TeamFragment();
        mineFragment = new MineFragment();

        fragmentList.add(homeFragment);
        fragmentList.add(bookFragment);
        fragmentList.add(broadcastFragment);
        fragmentList.add(teamFragment);
        fragmentList.add(mineFragment);
        getSupportFragmentManager().beginTransaction().add(R.id.view_flayout_mianact,homeFragment).commit();//默认显示
    }

    private void changeFragment(int postion){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment targetFragment = fragmentList.get(postion);
        Fragment currentFragment = fragmentList.get(current);
        if (targetFragment.isAdded()){
            fragmentTransaction.show(targetFragment).hide(currentFragment).commit();
        }else {
            fragmentTransaction.add(R.id.view_flayout_mianact,targetFragment).hide(currentFragment).commit();
        }
        current=postion;
    }
    @Override
    public void initListener() {
        selectbarRgMainact.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                switch (checkId) {
                    case R.id.home_tbtn_mainact:
                        changeFragment(0);
                        break;
                    case R.id.book_tbtn_mainact:
                        changeFragment(1);
                        break;
                    case R.id.broadcast_tbtn_mainact:
                        changeFragment(2);
                        break;
                    case R.id.team_tbtn_mainact:
                        changeFragment(3);
                        break;
                    case R.id.mine_tbtn_mainact:
                        changeFragment(4);
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
