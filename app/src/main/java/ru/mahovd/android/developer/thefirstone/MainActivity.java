package ru.mahovd.android.developer.thefirstone;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "ru.mahovd.android.developer.thefirstone.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(item.getItemId()){
            case R.id.action_settings:
                Toast settingToast = Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_SHORT);
                settingToast.show();
                return true;
            case R.id.action_search:
                Toast searchToast = Toast.makeText(getApplicationContext(),"Search",Toast.LENGTH_SHORT);
                searchToast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    //Starts only if you set parameter  in the AndroidManifest
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this,"landscape",Toast.LENGTH_SHORT).show();
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this,"portrait",Toast.LENGTH_SHORT).show();
        }

    }
}
