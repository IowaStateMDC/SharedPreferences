package woodring.evan.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences.Editor editor;
    private SharedPreferences prefs;
    private EditText name;
    private EditText date;
    private EditText email;
    private Button button;
    private Button viewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editor = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Toast.makeText(getApplicationContext(), "Hello " + prefs.getString("name", "Default"), Toast.LENGTH_LONG).show();
        name = (EditText)findViewById(R.id.nameText);
        date = (EditText) findViewById(R.id.birthText);
        email = (EditText) findViewById(R.id.emailText);
        button = (Button) findViewById(R.id.doneButton);
        viewButton = (Button) findViewById(R.id.viewButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = name.getText().toString();
                String dateString = date.getText().toString();
                String emailString = email.getText().toString();
                editor.putString("name", nameString);
                editor.putString("email", emailString);
                editor.putString("dob", dateString);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();
                name.setText("");
                date.setText("");
                email.setText("");

            }
        });
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DisplayActivity.class);
                startActivity(i);
            }
        });


    }
}
