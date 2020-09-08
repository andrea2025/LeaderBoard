package com.example.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SkillIQAdapter extends RecyclerView.Adapter<SkillIQAdapter.SkillViewHolder> {
    Context context;
    List<BoardList> mBoardList;


    public SkillIQAdapter(Context context, List<BoardList> boardList) {
        this.context = context;
        mBoardList = boardList;
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.skill_iq_user, parent, false);
        return new SkillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {
        BoardList board = mBoardList.get(position);
        holder.mName.setText(board.getUserName());
        holder.mScore.setText(board.getUserHours() + " skill IQ Score,");
        holder.mCountry.setText(board.getUserCountry());
        Picasso.get().load(board.getBadgeUrl()).into(holder.mBadge);

    }

    @Override
    public int getItemCount() {
        return mBoardList.size();
    }

    public class SkillViewHolder extends RecyclerView.ViewHolder {
        TextView mName, mScore,mCountry;
        ImageView mBadge;
        public SkillViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.iqName);
            mScore = itemView.findViewById(R.id.score);
            mCountry = itemView.findViewById(R.id.iqCountry);
            mBadge = itemView.findViewById(R.id.learnerBadge);
        }
    }
}
