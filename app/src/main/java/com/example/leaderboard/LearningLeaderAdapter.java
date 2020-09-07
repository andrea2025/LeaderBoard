package com.example.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LearningLeaderAdapter extends RecyclerView.Adapter<LearningLeaderAdapter.LearningViewHolder> {
    Context context;
    List<BoardList> mBoardLists;

    public LearningLeaderAdapter(Context context, List<BoardList> boardList) {
        this.context = context;
        mBoardLists = boardList;
    }

    @NonNull
    @Override
    public LearningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.learning_user, parent, false);
       return new LearningViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningViewHolder holder, int position) {
        BoardList boardList = mBoardLists.get(position);
  holder.description.setText(boardList.getUserInfo());
  holder.name.setText(boardList.getUserName());

    }

    @Override
    public int getItemCount() {
        return mBoardLists.size();
    }

    public class LearningViewHolder extends RecyclerView.ViewHolder {
        TextView name,description;
        public LearningViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.info);
        }
    }
}