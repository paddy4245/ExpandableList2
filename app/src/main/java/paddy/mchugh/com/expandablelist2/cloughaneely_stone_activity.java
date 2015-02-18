package paddy.mchugh.com.expandablelist2;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;


public class cloughaneely_stone_activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Bundle extras = getIntent().getExtras();
       // String name = "Name";
       // if (extras != null){
       //     name = extras.getString("name");
       // }
       setContentView(R.layout.activity_cloughaneely_stone_activity);
       //TextView nameText = (TextView)findViewById(R.id.cl_textview);
       //nameText.setText(R.string.cloughaneely_stone_heading);

       TextView descTextGA = (TextView)findViewById(R.id.textView3);
       descTextGA.setTypeface(null, Typeface.ITALIC);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cloughaneely_stone_activity, menu);
        return true;
    }

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
