package com.example.mvpsinglecontract.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.mvpsinglecontract.R;
import com.example.mvpsinglecontract.databinding.ActivityMainBinding;
import com.example.mvpsinglecontract.model.GetNextPriceInteractorImpl;
import com.example.mvpsinglecontract.presenter.MainContract;
import com.example.mvpsinglecontract.presenter.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    ActivityMainBinding binding = null;
    MainContract.MainPresenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        Initialise main presenter
        presenter = new MainPresenterImpl(this, new GetNextPriceInteractorImpl());

        binding.btnGetPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getPriceClick();
            }
        });
    }

    @Override
    public void showProgress() {
        binding.pbProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void setPrice(String price) {
        binding.txtMessage.setText(price);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
