package hello;

import java.util.Objects;

public class Bulb {
    private String id;
    private String currentState;

    public Bulb() {
    }

    public Bulb(String id, String currentState) {
        this.id = id;
        this.currentState = currentState;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public Bulb(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bulb{" +
                "id='" + id + '\'' +
                ", currentState='" + currentState + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bulb)) return false;
        Bulb that = (Bulb) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
