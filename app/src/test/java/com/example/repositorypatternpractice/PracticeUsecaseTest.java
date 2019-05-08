package com.example.repositorypatternpractice;

import com.example.repositorypatternpractice.domain.PracticeRepository;
import com.example.repositorypatternpractice.domain.PracticeUsecaseImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.when;

public class PracticeUsecaseTest {
    @Mock PracticeRepository repository;
    private PracticeUsecaseImpl practiceUsecase;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        practiceUsecase = new PracticeUsecaseImpl(repository);
    }

    @Test
    public void returnIntsLargerThan20Test() {
        // Given
        Observable<Integer> observable = Observable.just(1, 500);

        // When
        when(repository.getMultipleInts()).thenReturn(observable);
        TestObserver<Integer> result = practiceUsecase.returnIntsLargerThan20().test();

        // Then
        result.assertValues(100, 500);
    }
}
