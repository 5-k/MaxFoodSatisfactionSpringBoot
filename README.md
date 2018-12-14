# MaxFoodSatisfactionSpringBoot

Problem Statement

John , a very smart guy, like eating food. Now, John is at a restaurant and he has many different types of food to choose from. Gordon gets x amount of satisfaction and requires y amount of time to eat an item from the menu. Given t minutes, write a java program that reads the text file and ﬁnds out the maximum satisfaction that John can get from eating at the restaurant. You will be given a text file with the following format:

 [t][Number of items on menu]

[amount of satisfaction from eating dish 1][time taken for dish 1]

[amount of satisfaction from dish 2][time taken for dish 2]


Understanding
This is a example of traditional 0/1 KnapSack problem. In KnapSack problem, we need to be maximum value with a defined weight limit.

In our problem statement, we need to find out maximum food satisfaction value within a given time frame.

Approach:

We follow the approach of building a 2D array of Weights (on Y axis) and Time starting from 0 uptill desired value (on X axis)

This array will have values such that if X item is picked up from Y axis values, then at time T what would be the value if we pick that item. We chose such a value that is maximum of if we pick the item or if we leave and consider whats already there in bag

We fill 0th row and 0th Column by all zero's, since if we dont pick anything we don't have any value.

From matrix index (1,1) we start and set the matrix Value to the satisfaction value V from first item. This indicates if this item is picked at minute T1(1) then we would hve a satisfaction value V. 
From 2nd Row, we select the item and now compare if we pick this at t2, would be have more value within given time frame and so on.

Solution
Created a Spring boot application which contains a rest API call to be used as the end point for getting the values.



API CALL:

POST: /app/calculateFoodSatisfactionValue
Sample Body :
7 4
1 1
4 3
5 4
7 5

Sample File is added for more data
