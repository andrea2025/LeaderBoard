package com.example.leaderboard.skill;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leaderboard.BoardList;
import com.example.leaderboard.R;
import com.example.leaderboard.data.Api.Skills;
import com.example.leaderboard.data.AppUtils;
import com.example.leaderboard.learning.LearningLeaderAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SkillLeaderFragment extends Fragment {
ArrayList<BoardList> mBoardList = new ArrayList<>();
RecyclerView mRecyclerView;
    private OnFragmentInteractionListener mListener;

    public SkillLeaderFragment() {
        // Required empty public constructor
    }



    public static SkillLeaderFragment newInstance() {
        return new SkillLeaderFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait data is Processing");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        View rootView = inflater.inflate(R.layout.fragment_skill_leader_g, container, false);
        mRecyclerView = rootView.findViewById(R.id.skillRecycler);
        Call<List<Skills>> call = AppUtils.mService().skill();
        call.enqueue(new Callback<List<Skills>>() {


            @Override
            public void onResponse(Call<List<Skills>> call, Response<List<Skills>> response) {
                if (response.isSuccessful()){
                    skillIQ(response);
                    progressDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<List<Skills>> call, Throwable t) {

            }
        });

        return rootView;
    }


    public void skillIQ(Response<List<Skills>> response) {
        List<Skills> list = response.body();
        Log.i("response", "learner: " + response.body());
        for (int i = 0; i < list.size(); i++) {
            Skills dataList = list.get(i);
            String name = dataList.getUsername();
            String hours = dataList.getScore();
            String country = dataList.getCountry();
            String url = dataList.getBadge();
            mBoardList.add(new BoardList(name,hours,country,url));
            LearningLeaderAdapter adapter = new LearningLeaderAdapter(getActivity(),mBoardList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setAdapter(adapter);

        }

    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
