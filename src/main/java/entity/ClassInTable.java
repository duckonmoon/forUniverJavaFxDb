package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClassInTable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;


    private Double frequency;
    private Character symbol;
    private Double frequencyDecoded;
    private Character symbolDecoded;


    public ClassInTable() {
    }

    public ClassInTable(Double frequency, Character symbol, Double frequencyDecoded, Character symbolDecoded) {
        this.frequency = frequency;
        this.symbol = symbol;
        this.frequencyDecoded = frequencyDecoded;
        this.symbolDecoded = symbolDecoded;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public Double getFrequencyDecoded() {
        return frequencyDecoded;
    }

    public void setFrequencyDecoded(Double frequencyDecoded) {
        this.frequencyDecoded = frequencyDecoded;
    }

    public Character getSymbolDecoded() {
        return symbolDecoded;
    }

    public void setSymbolDecoded(Character symbolDecoded) {
        this.symbolDecoded = symbolDecoded;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
