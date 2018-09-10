package comin.example.root.loginapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class DetailActivity extends AppCompatActivity {
    private TextView textView2, textViewdesign, textViewpcd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView2= findViewById(R.id.textView2);
        textViewdesign = findViewById(R.id.textViewdesign);
        textViewpcd = findViewById(R.id.textViewpcd);

        Intent mainIntent = getIntent();
        String username = mainIntent.getStringExtra(Intent.EXTRA_TEXT);
        textView2.setText("Welcome, " + username);
        textViewdesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage ("http://bse.kemdikbud.go.id/index.php/buku/filters?kategori=buku_judul&cari=desain");
            }
        });

        textViewpcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage("http://bse.kemdikbud.go.id/index.php/buku/filters?kategori=buku_judul&cari=pengolahan+citra+");
            }
        });

        Toast.makeText(this," You Are Logged In", Toast.LENGTH_LONG).show();
    }

    private void openWebPage(String url){
        Uri webpage = Uri.parse(url);
        Intent broserintent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(broserintent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_siswa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(Menu item){
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.share:
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "My First App");
                shareIntent.setType(shareIntent);
                break;
            case R.id.signout:
                Intent signoutIntent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(signoutIntent);
                break;
                default:
                    break;
        }
        return super.onMenuItemSelected(item);
    }
}
