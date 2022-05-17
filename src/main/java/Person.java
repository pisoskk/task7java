import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private String name, lastName, patronymic;
    private int day, month, year;

    Person() {
        name = "";
        lastName = "";
        patronymic = "";
        day = 0;
        month = 0;
        year = 0;
    }
    public Person(String name, String lastName, String patronymic, int day, int month, int year) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year)  {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return day == person.day && month == person.month && year == person.year &&
                name.equals(person.name) && lastName.equals(person.lastName) && patronymic.equals(person.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, patronymic, day, month, year);
    }

    @Override
    public String toString() {
        return "Person[" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                "]";
    }
}
