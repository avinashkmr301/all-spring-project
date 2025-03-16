package com.healthycoderapp;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

class BMICalculatorTest {
	/*
		@BeforeAll
	    must be static, run exact once before each test, used to DB connection/starting server.
	 */
	@BeforeAll  // setup DB connection
	static void beforeAll(){
		System.out.println("Before All unit test, for costly operation, start DB connection ");
	}
	@AfterAll // close DB connection
	static void afterAll(){
		System.out.println("After all unit test, close DB connection");
	}

	//@Test
	@ParameterizedTest(name = "weight={0},height={1}") //
	//@ValueSource(doubles = {89.3,95.7,110.8}) //passing oneValue ie weight
	//@CsvSource(value = {"89.0, 1.72", "95.0, 1.75", "110, 1.78"}) //passing both value weight & height
	@CsvFileSource(resources = "/diet-recommended-input-data.csv",numLinesToSkip = 1)
	void should_return_true_diet_Recommended(double coderWeight, double coderHeight) {
		//given
		double weight = coderWeight;
		double height = coderHeight;
		//double weight = 89.7; //we are using parameterized test value execute with @Test
		//double height = 1.7; //@Test
		//double weight = coderWeight;	@ValueSource

		//when
		boolean recomended = BMICalculator.isDietRecommended(weight,height);
		//then
		assertTrue(recomended);
	}
	@Test
	void should_returnFalse_dietNot_Recommended() {
		//given
		double weight = 45.9;
		double height = 1.7;
		//when
		boolean recomended = BMICalculator.isDietRecommended(weight,height);
		//then
		assertFalse(recomended);
	}
	@Test
	void should_ThrowException_whenHightZero() {
		//given
		double weight = 45.9;
		double height = 0.0;
		//when
		Executable executable = () -> BMICalculator.isDietRecommended(weight,height);
		//then
		assertThrows(ArithmeticException.class,executable);
	}
	@Test
	void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty(){
		//given
		List<Coder> coders = new ArrayList<>();
		coders.add(new Coder(1.80,60.0));
		coders.add(new Coder(1.82,89.2));
		coders.add(new Coder(1.83,64.7));
		//when
		Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
		//then
		assertAll(
				()->assertEquals(1.82, coderWorstBMI.getHeight()),
				()->assertEquals(89.2, coderWorstBMI.getWeight())
		);
	}
	@Test
	void should_ReturnNullWithWorstBMI_When_CoderListEmpty(){
		//given
		List<Coder> coders = new ArrayList<>();
		//when
		Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
		//then
		assertNull(coderWorstBMI);
	}
	@Test
	void should_ReturnCorrectBMIScoreArray_When_CodetListNotEmpty(){
		//given
		List<Coder> coders = new ArrayList<>();
		coders.add(new Coder(1.80,60.0));
		coders.add(new Coder(1.82,89.2));
		coders.add(new Coder(1.83,64.7));
		double[] expected = {18.52,26.93,19.32};
		//when
		double[] bmiScores = BMICalculator.getBMIScores(coders);
		//then
		assertArrayEquals(expected,bmiScores);
	}

}
