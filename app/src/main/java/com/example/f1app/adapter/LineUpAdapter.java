package com.example.f1app.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1app.LineupActivity;
import com.example.f1app.R;
import com.example.f1app.RacerActivity;
import com.example.f1app.model.api.lineup.ResultsItem;

import java.util.List;

public class LineUpAdapter extends RecyclerView.Adapter<LineUpAdapter.ViewHolder>{

    List<ResultsItem> item;

    public LineUpAdapter(List<ResultsItem> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.lineup_item, parent, false);

        return new LineUpAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LineUpAdapter.ViewHolder holder, int position) {
        holder.bind(item.get(position));
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRank, tvName, tvCountry;
        CardView cvLineUp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRank = itemView.findViewById(R.id.tv_rank);
            tvName = itemView.findViewById(R.id.tv_name);
            tvCountry = itemView.findViewById(R.id.tv_country);
            cvLineUp = itemView.findViewById(R.id.cv_lineup);
        }

        @SuppressLint("SetTextI18n")
        void bind(ResultsItem item){
            tvRank.setText("Rank "+item.getIntPosition()+" | "+item.getStrDetail());
            tvName.setText("Name\t: "+item.getStrPlayer());
            tvCountry.setText("Country\t: "+item.getStrCountry());
            cvLineUp.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), RacerActivity.class);
                intent.putExtra(RacerActivity.EXTRA_DATA, item);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
