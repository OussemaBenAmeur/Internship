import java.util.Objects;
class Pair<T, U> {
    private T tHaja;
    private U uHaja;

    public Pair(T tHaja, U uHaja) {
        this.tHaja = tHaja;
        this.uHaja = uHaja;
    }

    public T getHajaLoula() {
        return tHaja;
    }

    public U getHajaThenia() {
        return uHaja;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair<?, ?> other = (Pair<?, ?>) obj;
        return Objects.equals(tHaja, other.tHaja) &&
                Objects.equals(uHaja, other.uHaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tHaja, uHaja);
    }

    @Override
    public String toString() {
        return "(" + tHaja + ", " + uHaja + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("ahla", 42);
        Pair<String, Integer> p2 = new Pair<>("ahla", 42);
        Pair<String, Integer> p3 = new Pair<>("hola", 99);
        Pair<String, Integer> p4 = new Pair<>("hello", 99);

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
        System.out.println("p4: " + p4);

        System.out.println("\np1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.equals(p3): " + p1.equals(p3));
        System.out.println("p1.equals(p4): " + p1.equals(p4));

        System.out.println("\nHashCodes:");
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("p3.hashCode(): " + p3.hashCode());
        System.out.println("p4.hashCode(): " + p4.hashCode());
    }
}
