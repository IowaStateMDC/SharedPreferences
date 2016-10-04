package woodring.evan.sharedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayActivity extends AppCompatActivity {
    private TextView text;
    private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        text = (TextView) findViewById(R.id.displayText);
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String name = prefs.getString("name", "Default");
        String date = prefs.getString("dob", "None");
        String email = prefs.getString("email", "None");
        text.setText("Welcome back " + name + "!\nYou told me your birthday was " + date + " and that your email was " + email + "!");
    }
}
