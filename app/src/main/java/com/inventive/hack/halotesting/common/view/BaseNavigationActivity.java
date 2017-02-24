package com.inventive.hack.halotesting.common.view;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.inventive.hack.halotesting.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Actividad base para crear y manejar un menú lateral o Navigation Drawer.
 */
public abstract class BaseNavigationActivity extends BaseFragActivity
    implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

  @BindView(R.id.drawer_layout) protected DrawerLayout mDrawerLayout;
  @BindView(R.id.navigation_view) protected NavigationView mNavigationView;
  protected CircleImageView mImageProfile;
  protected TextView mInputNameProfile;

  @Override protected void setupActionBar(ActionBar actionBar) {
    super.setupActionBar(actionBar);
    if (actionBar != null) {
      actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
      actionBar.setDisplayHomeAsUpEnabled(true);
    }
  }

  @Override protected void initView() {
    super.initView();
    initNavigationView();
    initHeaderView();
  }

  private void initNavigationView() {
    mNavigationView.setNavigationItemSelectedListener(this);
  }

  private void initHeaderView() {
    View header = mNavigationView.getHeaderView(0);
    mImageProfile = ButterKnife.findById(header, R.id.image_profile);
    mInputNameProfile = ButterKnife.findById(header, R.id.input_name_profile);
    ButterKnife.findById(header, R.id.navigation_header).setOnClickListener(this);
  }

  @Override protected int getIdFragmentContainer() {
    return R.id.fragment_container;
  }

  @Override protected int getLayout() {
    return R.layout.activity_navigation;
  }

  @Override public void onClick(View view) {
    if (view.getId() == R.id.navigation_header) {
      closeDrawerMenu();
      selectNavigationHeader();
    }
  }

  protected abstract void selectNavigationHeader();

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    closeDrawerMenu();
    selectNewItem(item.getItemId());
    return false;
  }

  protected abstract void selectNewItem(int itemId);

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      openDrawerMenu();
    }
    return false;
  }

  @Override public void onBackPressed() {
    returnPreviousAction();
  }

  private void returnPreviousAction() {
    if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
      closeDrawerMenu();
    } else {
      super.onBackPressed();
    }
  }

  public void openDrawerMenu() {
    mDrawerLayout.openDrawer(GravityCompat.START);
  }

  public void closeDrawerMenu() {
    mDrawerLayout.closeDrawer(GravityCompat.START);
  }


}
