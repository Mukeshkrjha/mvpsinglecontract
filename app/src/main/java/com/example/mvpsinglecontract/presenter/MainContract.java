package com.example.mvpsinglecontract.presenter;

public interface MainContract {

//    View
    interface MainView {
        void showProgress();
        void hideProgress();
        void setPrice(String price);
    }

//    Presenter
    interface MainPresenter {
        void getPriceClick();
        void onDestroy();
    }

//    Model
    interface GetNextPriceInteractor{
        interface OnFinishedListener{
            void onFinish(String text);
        }

        void getNextPrice(OnFinishedListener onFinishedListener);
    }

}
