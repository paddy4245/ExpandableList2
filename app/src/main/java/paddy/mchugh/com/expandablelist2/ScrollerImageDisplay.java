package paddy.mchugh.com.expandablelist2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by paddy on 06/02/15.
 */
public class ScrollerImageDisplay extends Activity {

    ImageView image;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.image_display);

        int value = bundle.getInt("ImageName");

        image = (ImageView)findViewById(R.id.imageToDisplay);
        image.setImageResource(value);




    }


}
