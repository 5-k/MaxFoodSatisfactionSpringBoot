package com.prateek.maxFoodSatifactionProblem.service;

import com.prateek.maxFoodSatifactionProblem.exceptions.CustomAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodSatisfactionCalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(FoodSatisfactionCalculatorService.class);

    public int maximumSatisfaction(String input) {

        if (null == input || input.length() == 0) {
            throw new CustomAPIException("Input cannot be null");
        }

        String rowsInList[] = input.split("[\n]");
        List<Integer> satisFactionList = new ArrayList<Integer>();
        List<Integer> timeList = new ArrayList<Integer>();

        int totalTimeT = 0;
        int totalItemsOnMenu = 0;

        try {
            for (int i = 0; i < rowsInList.length; i++) {
                String currentRow = rowsInList[i].trim();

                if (null == currentRow || currentRow.trim().length() == 0) {
                    continue;
                }

                String keyAndValue[] = currentRow.split(" ");
                int key;
                int value;

                if (keyAndValue.length < 2) {
                    throw new CustomAPIException("The Input at line " + (i+1) + " is only a single value.");
                } else if (keyAndValue.length == 2) {
                    key = Integer.parseInt(keyAndValue[0].trim());
                    value = Integer.parseInt(keyAndValue[1].trim());
                } else {
                    // Extra spaces in between
                    key = Integer.parseInt(keyAndValue[0].trim());
                    value = Integer.parseInt(keyAndValue[keyAndValue.length - 1].trim());
                }

                if (i == 0) {
                    logger.info("First Row, Time t = " + key + " and number of items on menu = " + value);
                    totalTimeT = key;
                    totalItemsOnMenu = value;
                } else {
                    logger.debug(i + " Amount of satisfaction " + key + " and time taken " + value);
                    satisFactionList.add(key);
                    timeList.add(value);
                }
            }
        } catch (NumberFormatException e) {
            throw new CustomAPIException("Input String not in proper input format as expected.");
        }

        logger.info("As per input total Elements in input list should be equal to the totalItemsInMenu + 1");
        // Plus 1 because First Row indicated totaltime T and the totalItemsonMenu
        if (rowsInList.length != totalItemsOnMenu + 1) {
            throw new CustomAPIException("Invalid Input. TotalItemsMentioned in Line1 = " + totalItemsOnMenu + " but recieved only " + (rowsInList.length - 1) + "items");
        }

        return getMaxiumFoodSatisfactionValue(satisFactionList, timeList, totalTimeT);

    }

    private int getMaxiumFoodSatisfactionValue(List<Integer> satisfactionList, List<Integer> time, int totalTimeT) {
        int maxSatisFactionCalulatorArray[][] = new int[satisfactionList.size() + 1][totalTimeT + 1];

        for (int satisFactionElement = 0; satisFactionElement <= satisfactionList.size(); satisFactionElement++) {
            for (int increasingTimeUnit = 0; increasingTimeUnit <= totalTimeT; increasingTimeUnit++) {
                if (satisFactionElement == 0 || increasingTimeUnit == 0) {
                    maxSatisFactionCalulatorArray[satisFactionElement][increasingTimeUnit] = 0;
                    continue;
                }
                if (increasingTimeUnit - time.get(satisFactionElement - 1) >= 0) {
                    maxSatisFactionCalulatorArray[satisFactionElement][increasingTimeUnit] = Math.max(maxSatisFactionCalulatorArray[satisFactionElement - 1][increasingTimeUnit], maxSatisFactionCalulatorArray[satisFactionElement - 1][increasingTimeUnit - time.get(satisFactionElement - 1)] + satisfactionList.get(satisFactionElement - 1));
                } else {
                    maxSatisFactionCalulatorArray[satisFactionElement][increasingTimeUnit] = maxSatisFactionCalulatorArray[satisFactionElement - 1][increasingTimeUnit];
                }
            }
        }
        return maxSatisFactionCalulatorArray[satisfactionList.size()][totalTimeT];
    }

}
