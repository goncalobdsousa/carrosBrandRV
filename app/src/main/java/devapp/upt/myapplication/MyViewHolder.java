package devapp.upt.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textViewMarca;
    ImageView imageViewLogo;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewMarca = itemView.findViewById(R.id.textViewMarca);
        imageViewLogo = itemView.findViewById(R.id.imageViewLogo);
    }


}
