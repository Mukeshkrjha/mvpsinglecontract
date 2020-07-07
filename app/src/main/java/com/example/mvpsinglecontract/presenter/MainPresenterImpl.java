package com.example.mvpsinglecontract.presenter;

public class MainPresenterImpl implements MainContract.MainPresenter, MainContract.GetNextPriceInteractor.OnFinishedListener {

    MainContract.MainView mainView;
    MainContract.GetNextPriceInteractor priceInteractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetNextPriceInteractor priceInteractor){
        this.mainView = mainView;
        this.priceInteractor = priceInteractor;
    }

    @Override
    public void getPriceClick() {
        if(mainView != null){
            mainView.showProgress();
            priceInteractor.getNextPrice(this);
        }
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinish(String text) {
        if(mainView != null) {
            mainView.setPrice(text);
            mainView.hideProgress();
        }
    }
}
