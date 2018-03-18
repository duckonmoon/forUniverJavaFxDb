package controller;

public class ClassInTable {
    private double frequency;
    private char symbol;
    private double frequencyDecoded;
    private char symbolDecoded;


    public ClassInTable() {
    }

    public ClassInTable(double frequency, char symbol, double frequencyDecoded, char symbolDecoded) {
        this.frequency = frequency;
        this.symbol = symbol;
        this.frequencyDecoded = frequencyDecoded;
        this.symbolDecoded = symbolDecoded;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public double getFrequencyDecoded() {
        return frequencyDecoded;
    }

    public void setFrequencyDecoded(double frequencyDecoded) {
        this.frequencyDecoded = frequencyDecoded;
    }

    public char getSymbolDecoded() {
        return symbolDecoded;
    }

    public void setSymbolDecoded(char symbolDecoded) {
        this.symbolDecoded = symbolDecoded;
    }
}
