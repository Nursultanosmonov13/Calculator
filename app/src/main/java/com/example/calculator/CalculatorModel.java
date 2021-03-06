package com.example.calculator;

public class CalculatorModel {
    private int firstArg;
    private int secondArg;

    private StringBuilder inputStr = new StringBuilder();
    private int actionSelected;
    private State state;

    private enum State{
        firstArgInput, secondArgInput, resultShow
    }
    public CalculatorModel(){
        state = State.firstArgInput;
    }
    public void onNumPressed(int buttonId){
        if (state == State.resultShow){
            state = State.firstArgInput;
            inputStr.setLength(0);
        }
        if (inputStr.length() < 9) {
            switch (buttonId){
                case R.id.zero:
                    if (inputStr.length() != 0){
                        inputStr.append("0");
                    }
                    break;
                case R.id.one:inputStr.append("1");
                break;
                case R.id.two:inputStr.append("2");
                    break;
                case R.id.three:inputStr.append("3");
                    break;
                case R.id.fory:inputStr.append("4");
                    break;
                case R.id.fife:inputStr.append("5");
                    break;
                case R.id.sex:inputStr.append("6");
                    break;
                case R.id.seven:inputStr.append("7");
                    break;
                case R.id.eich:inputStr.append("8");
                    break;
                case R.id.nine:inputStr.append("9");
                    break;
            }
        }
    }
    public void onActionPressed(int actionId){
        if (actionId == R.id.ravno && state == State.secondArgInput){
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionId) {
                case R.id.pluse:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.minus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.umnoj:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.delen:
                    inputStr.append(firstArg / secondArg);
                    break;

            }
        }else if (inputStr.length() > 0 && state == State.firstArgInput) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);
            switch (actionId) {
                case R.id.pluse:
                    actionSelected = R.id.pluse;
                    break;
                case R.id.minus:
                    actionSelected = R.id.minus;
                    break;
                case R.id.umnoj:
                    actionSelected = R.id.umnoj;
                    break;
                case R.id.delen:
                    actionSelected = R.id.delen;
                    break;
                case R.id.ravno:
                    actionSelected = R.id.ravno;
                    break;
            }
        }
    }
    public String getText(){
        return inputStr.toString();
    }
}
