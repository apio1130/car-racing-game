import static org.assertj.core.api.Assertions.*;

import com.practice.components.Car;
import com.practice.components.Cars;
import com.practice.exception.CarNameEmptyException;
import com.practice.exception.CarNameLengthOverFiveException;
import com.practice.exception.OverRaceNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("랜덤 숫자가 1~9 범위를 벗어나는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-2, 0, 10, 12, 50})
    void moveWithInvalidAttributes(int number) {
        assertThatThrownBy(() -> {
            Car car = new Car("모닝");
            car.move(number);
        }).isInstanceOf(OverRaceNumberRangeException.class).hasMessage("1~9까지의 숫자만 가능합니다.");
    }

    @DisplayName("랜덤 숫자가 4이상인 경우 position 증가")
    @Test
    void moveWithValidAttributesOverFour() {
        Car car = new Car("모닝");
        int positionBeforeMove = car.getPosition();
        car.move(4);
        assertThat(car.getPosition() - positionBeforeMove).isEqualTo(1);
    }

    @DisplayName("랜덤 숫자가 4미만인 경우 position 그대로")
    @Test
    void moveWithValidAttributesUnderFour() {
        Car car = new Car("모닝");
        int positionBeforeMove = car.getPosition();
        car.move(3);
        assertThat(car.getPosition() - positionBeforeMove).isEqualTo(0);
    }

    @DisplayName("Max Position 구하기")
    @Test
    void findMaxPosition() {
        Cars cars = new Cars(Car.of("모닝", 3), Car.of("스파크", 5), Car.of("미니", 7));
        assertThat(cars.findMaxPosition()).isEqualTo(7);
    }

    @DisplayName("Winner 구하기")
    @Test
    void findWinner() {
        Car winner = new Car("미니", 7);
        Cars cars = new Cars(Car.of("모닝", 3), Car.of("스파크", 5), winner);
        assertThat(cars.findWinner()).containsExactly(winner);
    }

    @DisplayName("공동 Winner 구하기")
    @Test
    void findWinners() {
        Car winner1 = new Car("미니", 7);
        Car winner2 = new Car("모닝", 7);
        Cars cars = new Cars(winner1, Car.of("스파크", 5), winner2);
        assertThat(cars.findWinner()).containsExactly(winner1, winner2);
    }



}
