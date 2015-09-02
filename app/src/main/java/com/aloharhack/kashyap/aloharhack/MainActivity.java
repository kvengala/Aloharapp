package com.aloharhack.kashyap.aloharhack;
import com.alohar.context.api.AcxServiceManager;
import com.alohar.context.api.model.AcxError;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AcxServiceManager.initialize(getApplicationContext(), 606, "c6ed774c5b843502cb6171e00f22d47e68cd3e5f");
        setContentView(R.layout.activity_main);
    }

    AcxServiceManager serviceManager = AcxServiceManager.getInstance();

    final AcxServiceManager.AcxServerCallback<String> callback = new AcxServiceManager.AcxServerCallback<String>() {
        @Override
        public void onSuccess(String aloharUid) {
            aloharUid = "Testvalue";
            Context context = getApplicationContext();

            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, aloharUid, duration);
            toast.show();
        }
        @Override
        public void onError(AcxError error) {
            // handle error
        }
    };



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
