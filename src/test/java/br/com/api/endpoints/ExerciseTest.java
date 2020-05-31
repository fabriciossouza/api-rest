package br.com.api.endpoints;

import br.com.api.infrastructure.exercicio1.Exercise;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseTest {

    @Test
    public void shouldReturnOneLessWhenExceedMaxNumber(){
        Integer result = Exercise.getBiggestBrother(200000000);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void shouldReturnTheBiggestBrotherWhenNumber213(){
        Integer result = Exercise.getBiggestBrother(213);
        assertThat(result).isEqualTo(321);
    }

    @Test
    public void shouldReturnTheBiggestBrotherWhenNumber553(){
        Integer result = Exercise.getBiggestBrother(553);
        assertThat(result).isEqualTo(553);
    }
}
