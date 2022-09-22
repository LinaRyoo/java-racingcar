package racing_car.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.step3.dto.CarDTO;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    
    @BeforeEach
    void setUp() {
        car = new Car(new Position(0));
        for (int i = 0; i < 3; i++) {
            car = car.moveTry(() -> true);
        }
        car = car.moveTry(() -> false);
    }
    
    @Test
    @DisplayName("랜덤 숫자가 4이상이면 move, 3이하이면 stop")
    void move() {
        assertThat(car).isEqualTo(new Car(new Position(3)));
    }
    
    @Test
    @DisplayName("해당 차량의 정보(CarDTO) 확인")
    void carInfo() {
        CarDTO carDTO = car.information();
        assertThat(carDTO.getPosition()).isEqualTo(3);
    }
}
