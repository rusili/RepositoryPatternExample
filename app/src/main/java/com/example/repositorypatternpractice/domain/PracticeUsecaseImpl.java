package com.example.repositorypatternpractice.domain;

import io.reactivex.Observable;
import io.reactivex.Single;

public class PracticeUsecaseImpl {
    private final PracticeRepository repository;

    public PracticeUsecaseImpl(PracticeRepository practiceRepository) {
        this.repository = practiceRepository;
    }

    public Single<Integer> returnSomeIntPlusFive() {
        return repository.getSomeInt()
                .map(intt -> intt + 5);
    }

    public Observable<Integer> returnIntsLargerThan20(){
        return repository.getMultipleInts()
                .filter(intt -> intt > 20);
    }
}
