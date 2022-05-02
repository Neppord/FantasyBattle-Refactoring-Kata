package codingdojo;


import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;

class Equipment<T> {
    private final T leftHand;
    private final T rightHand;
    private final T head;
    private final T feet;
    private final T chest;
    private final T ring;

    Equipment(T leftHand, T rightHand, T head, T feet, T chest, T ring) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.head = head;
        this.feet = feet;
        this.chest = chest;
        this.ring = ring;
    }

    public <R> Equipment<R> map(Function<T, R> f) {
        return new Equipment<>(
            f.apply(leftHand),
            f.apply(rightHand),
            f.apply(head),
            f.apply(feet),
            f.apply(chest),
            f.apply(ring)
        );
    }

    public T reduce(BinaryOperator<T> f) {
        return allItems().stream().reduce(f).orElseThrow();
    }

    private List<T> allItems() {
        return List.of(leftHand, rightHand, head, feet, chest, ring);
    }

    public T leftHand() {
        return leftHand;
    }

    public T rightHand() {
        return rightHand;
    }

    public T head() {
        return head;
    }

    public T feet() {
        return feet;
    }

    public T chest() {
        return chest;
    }

    public T ring() {
        return ring;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (Equipment) obj;
        return Objects.equals(this.leftHand, that.leftHand) &&
            Objects.equals(this.rightHand, that.rightHand) &&
            Objects.equals(this.head, that.head) &&
            Objects.equals(this.feet, that.feet) &&
            Objects.equals(this.chest, that.chest) &&
            Objects.equals(this.ring, that.ring);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftHand, rightHand, head, feet, chest, ring);
    }

    @Override
    public String toString() {
        return "Equipment[" +
            "leftHand=" + leftHand + ", " +
            "rightHand=" + rightHand + ", " +
            "head=" + head + ", " +
            "feet=" + feet + ", " +
            "chest=" + chest + ", " +
            "ring=" + ring + ']';
    }

}
