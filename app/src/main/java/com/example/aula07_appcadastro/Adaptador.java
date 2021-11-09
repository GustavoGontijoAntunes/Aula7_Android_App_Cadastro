package com.example.aula07_appcadastro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyPagerViewHolder> {

    List<Slide> slides = new ArrayList<>();

    public Adaptador(List<Slide> slides) {
        this.slides = slides;
    }

    @Override
    public MyPagerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.slide, parent, false);
        return new MyPagerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyPagerViewHolder holder, int position) {
        Slide sl = slides.get(position);
        holder.txtTutorial.setText(sl.getDescricao());
        holder.imgTutorial.setImageResource(sl.getImgRes());
    }

    @Override
    public int getItemCount() {
        return slides.size();
    }

    public class MyPagerViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTutorial;
        TextView txtTutorial;

        public MyPagerViewHolder(View itemView) {
            super(itemView);

            imgTutorial = itemView.findViewById(R.id.tutorial_img);
            txtTutorial = itemView.findViewById(R.id.tutorial_txtDescricao);
        }
    }
}
