package com.oocl;

public class GuessNumberGame {
    public static final String ANSWER_RESULT_PATTERN = "%sA%sB";
    private final String answer;

    public GuessNumberGame(String answer) {
        this.answer = answer;
    }

    public String guess(String inputNumbers) {
        int positionAndNumberCorrectCount = 0;
        int onlyNumberCorrectCount = 0;
        for (char number : inputNumbers.toCharArray()) {
            boolean isPositionAndNumberCorrect = this.answer.contains(Character.toString(number))
                && this.answer.indexOf(number) == inputNumbers.indexOf(number);
            boolean isNumberCorrectWithWrongPosition = this.answer.contains(Character.toString(number))
                && this.answer.indexOf(number) != inputNumbers.indexOf(number);
            if (isPositionAndNumberCorrect) {
                positionAndNumberCorrectCount++;
            }
            if (isNumberCorrectWithWrongPosition) {
                onlyNumberCorrectCount++;
            }
        }
        return String.format(ANSWER_RESULT_PATTERN, positionAndNumberCorrectCount, onlyNumberCorrectCount);
    }
}
