package com.payclip.clip_in_app_checkout_example;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.payclip.mpl.ClipWidget;

import retrofit.RetrofitError;


public class MyActivity extends Activity implements ClipWidget.ClipWidgetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ClipWidget _widget = new ClipWidget(this, "fJbkv0ipMUi1tPxbzT4AmCpikwzlKt9X2dO2e8Us0U8", "kumar-startbucks1", "ksdafkljdsakjfso3edsfs", "25.00", getResources().getDrawable(R.drawable.clip_icon) , "My App");
        _widget.setColorScheme(ClipWidget.ClipWidgetColorScheme.CLIP_WIDGET_COLOR_SCHEME_DARK);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.widget_container, _widget.fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**** Clip Widget Listener Methods ****/
    @Override
    public void widgetViewReady() {

    }

    @Override
    public void paymentFinishedWithTransactionId(String s) {

    }

    @Override
    public void clipWidgetDismissedWithError(Error error) {

    }

    @Override
    public void clipWidgetPaymentCanceled() {

    }

    @Override
    public void clipWidgetSetupDidFailWithError(RetrofitError retrofitError) {

    }
}
