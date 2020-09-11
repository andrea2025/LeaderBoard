package com.example.leaderboard.learning;

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
import com.example.leaderboard.MainActivity;
import com.example.leaderboard.R;
import com.example.leaderboard.data.Api.LearnerResponse;
import com.example.leaderboard.data.AppUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeaderFragment extends Fragment {
    ArrayList<BoardList> mBoardLists = new ArrayList<>();
    RecyclerView mRecyclerView;
    private OnFragmentInteractionListener mListener;

    public LearningLeaderFragment() {
        // Required empty public constructor
    }


    public static LearningLeaderFragment newInstance() {
        return new LearningLeaderFragment();

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait data is Processing");
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.getProgress();
        progressDialog.show();

        View rootView = inflater.inflate(R.layout.fragment_learning_leader, container, false);
        mRecyclerView = rootView.findViewById(R.id.learnerRecyclerView);

        Call<List<LearnerResponse>> call = AppUtils.mService().learner();
        call.enqueue(new Callback<List<LearnerResponse>>() {

            @Override
            public void onResponse(Call<List<LearnerResponse>> call, Response<List<LearnerResponse>> response) {
               if (response.isSuccessful()){
                   allLearner(response);
                   progressDialog.dismiss();
               }
                Log.i("RESPONSE ", String.valueOf(response.body()));

            }

            @Override
            public void onFailure(Call<List<LearnerResponse>> call, Throwable t) {
                System.out.println("ERROR here");
                Log.i("ERROR ", String.valueOf(t.getMessage()));
            }
        });

        return  rootView;
    }

    public void allLearner(Response<List<LearnerResponse>> response) {
        List<LearnerResponse> list = response.body();
        Log.i("response", "learner: " + response.body());
        for (int i = 0; i < list.size(); i++) {
            LearnerResponse dataList = list.get(i);
            String name = dataList.getUsername();
            String hours = dataList.getHours();
            String country = dataList.getCountry();
            String url = dataList.getBadge();
          mBoardLists.add(new BoardList(name,hours,country,url));
           LearningLeaderAdapter adapter = new LearningLeaderAdapter(getActivity(),mBoardLists);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(layoutManager);
           mRecyclerView.setAdapter(adapter);

        }

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
