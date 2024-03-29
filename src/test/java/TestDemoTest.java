import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {
	private TestDemo testDemo = new TestDemo(); 

	@BeforeEach
	void setUp() throws Exception {
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class); 
		}
		
	}
	
	public static Stream<Arguments> argumentsForAddPositive(){
		//@formatter:off
				return Stream.of(
						arguments(2, 4, 6, false),
						arguments(1, 2, 3, false),
						arguments(2, -2, 0, true),
						arguments(4, 5, 9, false),
						arguments(3, 0, 3, true),
						arguments(-2, -3, -5, true),
						arguments(0, 10, 10, true)
		//@formatter:on
						);
			
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo); 
		doReturn(5).when(mockDemo).getRandomInt(); 
		int fiveSquared = mockDemo.randomNumberSquared(); 
		assertThat(fiveSquared).isEqualTo(25); 
	}

}
