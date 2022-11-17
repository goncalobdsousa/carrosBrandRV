package devapp.upt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class redirectBranc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect_branc);

        Intent recebido = getIntent();
        String marca = recebido.getStringExtra("marca");
        String text = recebido.getStringExtra("text");
        int logo = recebido.getIntExtra("image", 0);

        TextView textv = findViewById(R.id.textView2);
        ImageView image = findViewById(R.id.imageView);
        TextView textv2 = findViewById(R.id.textView3);

        int drID = getResources().getIdentifier(marca.toLowerCase(), "drawable", getPackageName());
        textv.setText(marca);
        image.setImageResource(drID);
        textv2.setText(text);





    }

}