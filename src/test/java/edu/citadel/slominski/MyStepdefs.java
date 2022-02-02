package edu.citadel.slominski;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.*;

import java.util.ArrayDeque;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class MyStepdefs {
    Deque<Integer> deque = new Deque<Integer>();

    @Given("The deque contains {int} elements")
    public void theDequeContainsZeroElements(int num) {
        if(deque.size() == num) System.out.println("The deque is empty");
    }

    @And("I add {int} to the front")
    public void iAddAnElementToTheFront(int int1) {
        deque.addFront(int1);
    }

    @Then("I should see the {int} as the first element")
    public void iShouldSeeTheElementAsTheFirstElement(int int1) {
        int firstElement = 0;
        int x = 0;
        while(x == 0){
            for(Integer s : deque){
                firstElement = s;
            }
            x = 1;
        }
        assertTrue(int1 == firstElement);
    }

    @And("I add {int} to the end")
    public void iAddAnElementToTheEnd(int int1) {
        deque.addBack(int1);
        assertTrue(int1 == (deque.peekLast()));
    }

    @Given("The deque contains {int} , {int} , {int}, in that order")
    public void theDequeContainsStringStringgStringggInThatOrder(int int1, int int2, int int3) {
        deque.addBack(int1);
        deque.addBack(int2);
        deque.addBack(int3);
        assertTrue(int3 == (deque.peekLast()));
    }

    @And("I remove the first element")
    public void iRemoveTheFirstElement() {
        deque.removeFront();
    }

    @Then("I should see the {int} as the new first")
    public void iShouldSeeTheElementAsTheNewFirst(int int1) {
        assertTrue(int1 == (deque.peekFirst()));
    }

    @And("I remove the last element")
    public void iRemoveTheLastElement() {
        deque.removeBack();
    }

    @Then("I should see the {int} as the new end")
    public void iShouldSeeTheElementAsTheNewEnd(int int1) {
        assertTrue(int1 == (deque.peekLast()));
    }

    @And("I remove the second element")
    public void iRemoveTheSecondElement() {
        deque.removeSecond();
    }

    @Then("The deque should contain two elements, {int} and {int}")
    public void theDequeShouldContainTwoElementsStringAndStringgg(int int1, int int2) {
        assertTrue(int1 == deque.peekFirst() && int2 == deque.peekLast());
    }

    @Given("The deque adds {int}")
    public void theDequeAddsString(int int1) {
        deque.addFront(int1);
    }

    @And("I try to remove the second element")
    public void iTryToRemoveTheSecondElement() {
        try {
            deque.removeSecond();
        } catch (NoSuchElementException e){
            
        }
    }

    @Given("The deque has less than two items")
    public void theDequeHasLessThanTwoItems() {
        deque.toEmptyDeque();
    }

    @Then("The program should tell me {string}")
    public void theProgramShouldTellMe(String s) {
        s = "";
        try{
            deque.removeSecond();
        } catch (NoSuchElementException e){
            s = "no element in that position";
        }
    }

    @Then("The program should catch an exception")
    public void theProgramShouldCatchAnException() {
    }
}
