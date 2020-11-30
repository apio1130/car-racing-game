import  static org.assertj.core.api.Assertions.*;

import com.practice.components.Car;
import com.practice.exception.CarNameEmptyException;
import com.practice.exception.CarNameLengthOverFiveException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

class CarTest {

    @DisplayName("자동차 이름이 5글자 이상인 경우 예외 발생")
    @Test
    void constructWithNameLengthOverFive() {
        assertThatThrownBy(() -> {
            Car car = new Car("자동차입니다");
        }).isInstanceOf(CarNameLengthOverFiveException.class).hasMessage("자동차 이름은 5글자 이하만 가능합니다.");
    }

    @DisplayName("자동차 이름이 공백인 경우 예외 발생")
    @ParameterizedTest
    @EmptySource
    void constructWithNameEmpty(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(CarNameEmptyException.class).hasMessage("자동차 이름은 공백일 수 없습니다.");
    }


}
