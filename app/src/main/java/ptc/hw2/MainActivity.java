package ptc.hw2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * EXPLICIT EXAMPLE
     *
     * Intent i = new Intent(this, ActivityTwo.class);
     * i.putExtra("Value1", "This value one for ActivityTwo ");
     * i.putExtra("Value2", "This value two ActivityTwo");
     */
    // function for the implicit button in the main screen
    public void explicitIntentTap(View view)
    {
        // create the explicit intent
        Intent explicitScreen = new Intent(MainActivity.this, NumberActivity.class);
        // start the explicit intent
        startActivity(explicitScreen);
    }

    // function for the implicit button in the main screen
    public void implicitIntentTap(View view)
    {
        // parse the webpage
        Uri webpage = Uri.parse("https://developer.android.com/index.html");
        // create the implicit intent
        Intent implicitScreen = new Intent(Intent.ACTION_VIEW, webpage);
        // start the implicit intent
        if (getIntent().resolveActivity(getPackageManager()) != null)
            startActivity(implicitScreen);
    }
}
