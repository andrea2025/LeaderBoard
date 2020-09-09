package com.example.leaderboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leaderboard.data.AppUtils;

import com.example.leaderboard.data.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProjectActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mFirstname, mLastname, mEmail, mLink;
    String firstNameText, lastnameText, emailText, linkText;
    Button mButton;
    UserService mUserService;
    AlertDialog alertOne, alertTwo, alertThree;
    ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        mUserService = AppUtils.mService();

        mButton = findViewById(R.id.submitBtn);
        mFirstname = findViewById(R.id.firstName);
        mLastname = findViewById(R.id.lastName);
        mEmail = findViewById(R.id.emailAddress);
        mLink = findViewById(R.id.link);
        backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        mButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        firstNameText = mFirstname.getText().toString();
        lastnameText = mLastname.getText().toString();
        emailText = mEmail.getText().toString();
        linkText = mLink.getText().toString();

        final AlertDialog.Builder builder = new AlertDialog.Builder(ProjectActivity.this);
        LayoutInflater inflater = ProjectActivity.this.getLayoutInflater();
        final View view = inflater.inflate(R.layout.submit_dialog, null);
        builder.setView(view);
        Button yes = view.findViewById(R.id.yesBtn);
        ImageView cancel = view.findViewById(R.id.cancel);
        alertOne = builder.create();
        alertOne.show();
        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.55);

        alertOne.getWindow().setLayout(width, height);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertOne.dismiss();
                mUserService.submitProject(firstNameText, lastnameText, emailText, linkText,
                        "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
                        .enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if (response.isSuccessful()) {
                                    LayoutInflater inflaterTwo = ProjectActivity.this.getLayoutInflater();
                                    View viewTwo = inflaterTwo.inflate(R.layout.success, null);
                                    builder.setView(viewTwo);
                                    alertTwo = builder.create();
                                    alertTwo.show();

                                    Log.i("SUCCESSFULL", "SUCCESSFULL");
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.i("Error", "Error" + t.getMessage());

                            }
                        });


            }
        });



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertOne.dismiss();
                LayoutInflater inflaterTwo = ProjectActivity.this.getLayoutInflater();
                View viewTwo = inflaterTwo.inflate(R.layout.success, null);
                builder.setView(viewTwo);
                ImageView iconFail  = viewTwo.findViewById(R.id.dialogImage);
                TextView textFail = viewTwo.findViewById(R.id.textDialog);
                iconFail.setImageDrawable(getResources().getDrawable(R.drawable.ic_warning));
                textFail.setText("Submission not Successful");
                alertTwo = builder.create();
                alertTwo.show();

            }
        });
    }
}






