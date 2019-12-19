package hw8.entities;

public class SummaryEntity {
    private Integer oddElementIndex;

    private Integer evenElementIndex;

    public SummaryEntity(Integer oddElementIndex, Integer evenElementIndex) {
        this.oddElementIndex = oddElementIndex;
        this.evenElementIndex = evenElementIndex;
    }

    public Integer getOddElementIndex() {
        return oddElementIndex;
    }

    public Integer getEvenElementIndex() {
        return evenElementIndex;
    }
}
