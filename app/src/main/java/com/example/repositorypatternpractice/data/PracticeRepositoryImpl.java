package com.example.repositorypatternpractice.data;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.example.repositorypatternpractice.domain.PracticeRepository;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public class PracticeRepositoryImpl implements PracticeRepository {
    private final SharedPreferences sharedPreferences;

    public PracticeRepositoryImpl(@NonNull SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

//    public Single<ResponseBody> makeApiCall() {
//        return someApi.getStuff();
//    }

    public Completable saveToSharedPrefs(String value) {
        return Completable.fromCallable(() -> sharedPreferences.edit().putString("SOMEKEY", value));
    }
    
    public Single<String> getFromSharedPrefs() {
        return Single.fromCallable(() -> sharedPreferences.getString("SOMEKEY", ""));
    }

    @Override
    public Single<Integer> getSomeInt() {
        return Single.just(10);
    }

    public int getSomeInt2(){
        return 10;
    }

    @Override
    public Observable<Integer> getMultipleInts() {
        return Observable.just(1, 5, 10, 15, 100, 500);
    }
}
