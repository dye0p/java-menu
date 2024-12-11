package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @DisplayName("코치의 이름 길이가 2보다 작거나 4보다 크다면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"우", "우아한테크"})
    void validateNameSize(String name) {
        //when //then
        assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NAME_SIZE.getErrorMessage());
    }

    @DisplayName("못 먹는 음식을 추가할 수 있다.")
    @Test
    void updateNonEat() {
        //given
        Coach coach = new Coach("포비");
        NonEat nonEat = new NonEat(List.of("우동", "스시"));

        //when
        coach.updateNonEat(nonEat);

        //then
        assertThat(coach.getNonEat()).isNotNull();
    }
}
