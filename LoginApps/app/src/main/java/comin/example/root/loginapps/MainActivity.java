package comin.example.root.loginapps;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText uname;
    private EditText pass;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = findViewById(R.id.uname);
        pass = findViewById(R.id.pass);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = uname.getText().toString();
                String password = pass.getText().toString();
                String validusername1 = "erick";
                String validusername2 = "berlian";
                String validpasswrod1 = "erick";
                String validpassword2 = "berlian";

                if ((username.equals(validusername1))&&(password.equals(validpasswrod1))||(username.equals(validusername2)&&password.equals(validpassword2))){
                    Intent detailintent = new Intent(MainActivity.this, DetailActivity.class);
                    detailintent.putExtra(Intent.EXTRA_TEXT, username);
                    startActivity(detailintent);
                }else{
                    Toast.makeText(MainActivity.this,"Username dan/atau Password Salah !",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}