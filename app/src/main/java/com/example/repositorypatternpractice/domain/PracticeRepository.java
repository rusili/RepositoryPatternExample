package com.example.repositorypatternpractice.domain;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface PracticeRepository {

    Single<Integer> getSomeInt();

    Observable<Integer> getMultipleInts();
}
