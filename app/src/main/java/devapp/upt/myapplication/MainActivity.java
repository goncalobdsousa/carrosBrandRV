package devapp.upt.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Carro> ListaCarros;
    MyAdapter myadapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insereCarros();
        sortArrayListAsc();
        //sortArrayListDes();

        myadapter = new MyAdapter(ListaCarros);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(myadapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void insereCarros() {
        ListaCarros = new ArrayList<>();
        ListaCarros.add(new Carro("Audi", R.drawable.audi));
        ListaCarros.add(new Carro("Bentley", R.drawable.bentley));
        ListaCarros.add(new Carro("BMW", R.drawable.bmw));
        ListaCarros.add(new Carro("Citroen", R.drawable.citroen));
        ListaCarros.add(new Carro("Jaguar", R.drawable.jaguar));
        ListaCarros.add(new Carro("Jeep", R.drawable.jeep));
        ListaCarros.add(new Carro("Mercedes", R.drawable.mercedes));
        ListaCarros.add(new Carro("Mini", R.drawable.mini));
        ListaCarros.add(new Carro("Opel", R.drawable.opel));
        ListaCarros.add(new Carro("Porsche", R.drawable.porsche));
        ListaCarros.add(new Carro("Toyota", R.drawable.toyota));
        ListaCarros.add(new Carro("Volkswagen", R.drawable.volkswagen));
        ListaCarros.add(new Carro("Pagani", R.drawable.pagani));
    }

    public void sortArrayListAsc(){
        Collections.sort(ListaCarros, new Comparator<Carro>() {
            @Override
            public int compare(Carro obj1, Carro obj2) {
                return obj1.marca.compareTo(obj2.marca);
            }
        });
    }

    public void sortArrayListDes(){
        Collections.sort(ListaCarros, (obj1, obj2) -> obj2.marca.compareTo(obj1.marca));
    }

    public void onClick(View view) {
        System.out.println("DebugOC");
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        TextView textV = (TextView) constraintLayout.getChildAt(0);
        ImageView imageV = (ImageView) constraintLayout.getChildAt(1);
        String textoMarca = textV.getText().toString();
        requestHttp(textoMarca);
    }

    public void requestHttp(String textM) {
        System.out.println("DebugRH");
        System.out.println(textM);
        String url = "https://alunos.upt.pt/~abilioc/" + textM.toLowerCase() + ".html";
        StringRequest request = new StringRequest(url, response -> {
            String text = response;
            System.out.println("DebugRH2");
            Intent intent = new Intent(getApplicationContext(), redirectBranc.class);
            intent.putExtra("text", text);
            intent.putExtra("marca", textM);
            startActivity(intent);

        }, error -> {
            System.out.println("DebugRHError");
            Toast toast = Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_SHORT);
            toast.show();
        });
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}