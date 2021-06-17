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
import com.example.f1app.model.api.race.EventsItem;

import java.util.List;

public class RaceAdapter extends RecyclerView.Adapter<RaceAdapter.ViewHolder>{

    List<EventsItem> item;

    public RaceAdapter(List<EventsItem> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.race_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RaceAdapter.ViewHolder holder, int position) {
        holder.bind(item.get(position));
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDesc, tvLocation, tvDate;
        CardView cvRace;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvLocation = itemView.findViewById(R.id.tv_location);
            tvDate = itemView.findViewById(R.id.tv_date);
            cvRace = itemView.findViewById(R.id.cv_race);
        }

        @SuppressLint("SetTextI18n")
        void bind(EventsItem item){
            tvTitle.setText(item.getStrEvent());
            tvDesc.setText(item.getStrDescriptionEN());
            tvLocation.setText("Location : "+item.getStrVenue()+", "+item.getStrCountry());
            tvDate.setText("Date : "+item.getDateEvent());
            cvRace.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), LineupActivity.class);
                intent.putExtra(LineupActivity.EXTRA_DATA, item);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
