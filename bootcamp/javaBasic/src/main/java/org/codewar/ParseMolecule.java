package org.codewar;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseMolecule {
    public static Map<String,Integer> getAtoms(String formula) {
        List<String> formulaElements = getFormulaElements(formula);
        List<String> listOfMolecules = flattenMolecule(formulaElements);
        listOfMolecules = getFormulaElements(listOfMolecules.stream().collect(joining()));
        return moleculeCount(listOfMolecules);
    }

    private static List<String> getFormulaElements(String formula) {
        List<String> formulaElements = new ArrayList<String>();
        for(int i = 0; i < formula.length(); i++)
        {
            char letter = formula.charAt(i);
            if(Character.isUpperCase(letter) && i < formula.length() - 1 && Character.isLowerCase(formula.charAt(i + 1)))
            {
                formulaElements.add(formula.substring(i, i + 2));
                i++;
            }
            else if(Character.isDigit(letter))
            {
                int beginningOfNumber = i;
                while(i < formula.length() - 1 && Character.isDigit(formula.charAt(i + 1)))
                {
                    i++;
                }
                formulaElements.add(formula.substring(beginningOfNumber, i + 1));
            }
            else
            {
                formulaElements.add(Character.toString(letter));
            }
        }

        return formulaElements;
    }

    private static class ParenAndLocation
    {
        private String paren;
        private int index;

        ParenAndLocation(String paren, int index)
        {
            this.paren = paren;
            this.index = index;
        }
    }

    private static List<String> flattenMolecule(List<String> formulaElements) {
        List<String> flattenedFormulaElements = new ArrayList<String>();
        Deque<ParenAndLocation> openingParenLocationStack = new ArrayDeque<ParenAndLocation>();

        for(int i = 0; i < formulaElements.size(); i++)
        {
            String element = formulaElements.get(i);
            if(element.equals("(") || element.equals("[") || element.equals("{"))
            {
                flattenedFormulaElements.add("");
                openingParenLocationStack.push(new ParenAndLocation(element, i));
            }
            else if(element.equals(")") || element.equals("]") || element.equals("}"))
            {
                if(openingParenLocationStack.isEmpty())
                {
                    throw new IllegalArgumentException("Closing parenthesis does not have matching opening parenthesis");
                }
                ParenAndLocation parenAndLocation = openingParenLocationStack.pop();
                switch(element)
                {
                    case ")":
                        validateBrace("(", parenAndLocation);
                        break;
                    case "]":
                        validateBrace("[", parenAndLocation);
                        break;
                    case "}":
                        validateBrace("{", parenAndLocation);
                        break;
                }
                flattenedFormulaElements.add("");
                if(i < formulaElements.size() - 1 && formulaElements.get(i + 1).matches("[1-9][0-9]*"))
                {
                    int numberOfRepeats = Integer.parseInt(formulaElements.get(i + 1)) - 1;
                    int startingIndex = parenAndLocation.index + 1;
                    List<String> subList = flattenedFormulaElements.subList(startingIndex, i);
                    flattenedFormulaElements.add(subList.stream().collect(joining()).repeat(numberOfRepeats));
                    i++;
                }
            }
            else if(element.matches("[1-9][0-9]*"))
            {
                if(i == 0)
                {
                    throw new IllegalArgumentException("Cannot start with a number");
                }
                int numberOfRepeats = Integer.parseInt(element) - 1;
                flattenedFormulaElements.add(flattenedFormulaElements.get(i - 1).repeat(numberOfRepeats));
            }
            else if(!element.matches("[A-Z][a-z]?"))
            {
                throw new IllegalArgumentException("Invalid element: " + element);
            }
            else
            {
                flattenedFormulaElements.add(element);
            }
        }

        if(!openingParenLocationStack.isEmpty())
        {
            throw new IllegalArgumentException("Opening parenthesis does not have matching closing parenthesis");
        }

        return flattenedFormulaElements;
    }

    private static void validateBrace(String brace, ParenAndLocation parenAndLocation)
    {
        if(!(brace.equals(parenAndLocation.paren)))
        {
            throw new IllegalArgumentException("Mismatched brace types");
        }
    }

    private static Map<String, Integer> moleculeCount(List<String> moleculeList)
    {
        return moleculeList.stream()
                .collect(groupingBy(
                        identity(), collectingAndThen(
                                counting(),
                                Long::intValue)));
    }
}