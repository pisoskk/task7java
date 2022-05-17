import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable {
    private int apartmentNumber, area;
    private List<Person> Owners;

    Flat() {
        apartmentNumber = 0;
        area = 0;
        Owners = new ArrayList<>();
    }

    public Flat(int apartmentNumber, int area, List<Person> owners) {
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.Owners = owners;
    }

    public List<Person> getOwners() {
        return Owners;
    }

    public void setOwners(List<Person> owners) {
        Owners = owners;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return apartmentNumber == flat.apartmentNumber && area == flat.area && Owners.equals(flat.Owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apartmentNumber, area, Owners);
    }

    @Override
    public String toString() {
        return "Flat[" +
                "apartmentNumber=" + apartmentNumber +
                ", area=" + area +
                ", Owners=" + Owners +
                "]";
    }
}
