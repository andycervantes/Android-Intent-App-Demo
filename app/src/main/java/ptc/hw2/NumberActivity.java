package ptc.hw2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberActivity extends AppCompatActivity {

    // used for the debug messages in logcat
    private static final String TAG = MainActivity.class.getSimpleName();
    // text field for the number
    EditText numberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        // set the variable with a "pointer" from the EditText field in the layout
        // numberTextField is set in the activity_main under the editText label
        numberText = (EditText) findViewById(R.id.numberTextField);
    }

    // function to process the number in the EditText field
    public void processNumber(View view)
    {
        String number = numberText.getText().toString();
        String match = "";
        String test = "987(324)554-3323kfdjl)(kjdsf";

        Log.i(TAG, "Original Text: " + number);
        Log.i(TAG, "Parsed Number: " + numberParser(number));

        // regex referenced from regexlib as posted from the piazza post
        String PHONE_REGEX = "^([\\(]{1}[0-9]{3}[\\)]{1}[ |\\-]{0,1}|^[0-9]{3}[\\-| ])?[0-9]{3}(\\-| ){1}[0-9]{4}$";
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(numberParser(number));

        if (matcher.find())
            match = matcher.group(0);

        Log.i(TAG, "Number Match: " + match );

        // after we have a match we call the dialer function
        dialNumber(match);
    }

    // remove everything but the digits in the text field
    public static String numberParser(String number)
    {
        // referenced from stackoverflow
        return number.replaceAll("[^0-9() | \\-]", "");
    }

    // function what handles the intent for the dialer
    public void dialNumber(String phoneNumber)
    {
        Intent dialer = new Intent(Intent.ACTION_DIAL);
        dialer.setData(Uri.parse("tel:" + phoneNumber));

        if (getIntent().resolveActivity(getPackageManager())!= null)
            startActivity(dialer);
    }
}
