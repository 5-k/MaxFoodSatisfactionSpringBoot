package com.prateek.maxFoodSatifactionProblem.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.prateek.maxFoodSatifactionProblem.exceptions.CustomAPIException;

@RunWith(MockitoJUnitRunner.class)
public class FoodSatisfactionCalculatorServiceTest {

	@InjectMocks
	private FoodSatisfactionCalculatorService foodSatisfactionCalculatorService;

	@Test
	public void testCaculateSatisFactionService() {
		String input = "7 4" + "\n 1 1" + "\n4 3" + "\n5 4" + "\n7  5";
		int value = foodSatisfactionCalculatorService.maximumSatisfaction(input);
		System.out.println("Value is " + value);
		Assert.assertTrue(value == 9);
	}
	
	@Test
	public void testCaculateSatisFactionServiceWithMoreData() {
		String input = "10000 100\n" + "16808 250\n" + "50074 659\n" + "8931 273\n" + "27545 879\n"
				+ "77924 710\n" + "64441 166\n" + "84493 43\n" + "7988 504\n" + "82328 730\n" + "78841 613\n"
				+ "44304 170\n" + "17710 158\n" + "29561 934\n" + "93100 279\n" + "51817 336\n" + "99098 827\n"
				+ "13513 268\n" + "23811 634\n" + "80980 150\n" + "36580 822\n" + "11968 673\n" + "1394 337\n"
				+ "25486 746\n" + "25229 92\n" + "40195 358\n" + "35002 154\n" + "16709 945\n" + "15669 491\n"
				+ "88125 197\n" + "9531 904\n" + "27723 667\n" + "28550 25\n" + "97802 854\n" + "40978 409\n" + "8229 934\n"
				+ "60299 982\n" + "28636 14\n" + "23866 815\n" + "39064 537\n" + "39426 670\n" + "24116 95\n"
				+ "75630 502\n" + "46518 196\n" + "30106 405\n" + "19452 299\n" + "82189 124\n" + "99506 883\n"
				+ "6753 567\n" + "36717 338\n" + "54439 145\n" + "51502 898\n" + "83872 829\n" + "11138 359\n"
				+ "53178 398\n" + "22295 905\n" + "21610 232\n" + "59746 176\n" + "53636 299\n" + "98143 400\n"
				+ "27969 413\n" + "261 558\n" + "41595 9\n" + "16396 969\n" + "19114 531\n" + "71007 963\n" + "97943 366\n"
				+ "42083 853\n" + "30768 822\n" + "85696 713\n" + "73672 902\n" + "48591 832\n" + "14739 58\n"
				+ "31617 791\n" + "55641 680\n" + "37336 7\n" + "97973 99\n" + "49096 320\n" + "83455 224\n" + "12290 761\n"
				+ "48906 127\n" + "36124 507\n" + "45814 771\n" + "35239 95\n" + "96221 845\n" + "12367 535\n"
				+ "25227 395\n" + "41364 739\n" + "7845 591\n" + "36551 160\n" + "8624 948\n" + "97386 218\n"
				+ "95273 540\n" + "99248 386\n" + "13497 886\n" + "40624 421\n" + "28145 969\n" + "35736 916\n"
				+ "61626 535\n" + "46043 12\n" + "54680 153";

		
		int value = foodSatisfactionCalculatorService.maximumSatisfaction(input);
		System.out.println("Value is " + value);
		Assert.assertTrue(value == 2493893);
	}

	@Test(expected=CustomAPIException.class)
	public void testCaculateSatisFactionServiceWithInvalidInput() {
		String input = "7 4" + "\n 1 1" + "\n3 4" + "\n4 5" + "\n5  7hdsjhbj";
		foodSatisfactionCalculatorService.maximumSatisfaction(input);
	}
	
	@Test(expected=CustomAPIException.class)
	public void testCaculateSatisFactionServiceWithInvalidCount() {
		String input = "7 2" + "\n 1 1" + "\n3 4" + "\n4 5" + "\n5  7";
		foodSatisfactionCalculatorService.maximumSatisfaction(input);
	}
}
