package com.example.cs441program4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<String> localDataSet;
    private DataStorage data = DataStorage.getInstance();
    private boolean removing = false;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final FloatingActionButton button;

        public ViewHolder(View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.textView);
            button = (FloatingActionButton) view.findViewById(R.id.floatingActionButton3);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    localDataSet.remove(pos);
                    notifyItemRemoved(pos);
                    notifyItemRangeChanged(pos, localDataSet.size());

                }
            });
        }

        public TextView getTextView() {
            return textView;
        }

        public FloatingActionButton getButton() { return button; }
    }

    public CustomAdapter(ArrayList<String> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rows, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.getTextView().setText(localDataSet.get(position));
        if (removing == true) {
            viewHolder.getButton().setVisibility(View.VISIBLE);
        } else {
            viewHolder.getButton().setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public void setRemoving(boolean removing){ this.removing = removing; }
}
