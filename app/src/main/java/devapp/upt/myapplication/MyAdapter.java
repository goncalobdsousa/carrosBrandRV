package devapp.upt.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    ArrayList<Carro> carros;
    MyViewHolder myViewHolder;

    public MyAdapter(ArrayList<Carro> listaCarros) {
        carros = listaCarros;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_linha_carros, parent, false);

        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        myViewHolder.textViewMarca.setText(carros.get(position).getMarca());
        myViewHolder.imageViewLogo.setImageResource(carros.get(position).getLogo());
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
