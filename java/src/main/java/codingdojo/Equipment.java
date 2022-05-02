package codingdojo;


import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

record Equipment<T>(T leftHand, T rightHand, T head, T feet, T chest, T ring) {

    public <R> Equipment<R> map(Function<T, R> f) {
        return new Equipment<>(f.apply(leftHand), f.apply(rightHand), f.apply(head), f.apply(feet), f.apply(chest), f.apply(ring));
    }

    public T reduce(BinaryOperator<T> f) {
        return allItems().stream().reduce(f).orElseThrow();
    }

    private List<T> allItems() {
        return List.of(leftHand, rightHand, head, feet, chest, ring);
    }
}
