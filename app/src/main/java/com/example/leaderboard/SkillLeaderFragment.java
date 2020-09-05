package com.example.leaderboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class SkillLeaderFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public SkillLeaderFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SkillLeaderFragment newInstance(String param1, String param2) {
        return new SkillLeaderFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_leader_g, container, false);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
