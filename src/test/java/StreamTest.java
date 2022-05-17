import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class StreamTest {
    @Test
    public void firstTest(){
        try(OutputStream out = new FileOutputStream("test.txt");
            InputStream in = new FileInputStream("test.txt")){
            int[] arr1 = {0, 1, 2, 3, 4, 5};
            int[] arr2 = new int[arr1.length];
            StreamClass.writeArrInStream(out, arr1);
            StreamClass.readArrFromStream(in, arr2);
            assertArrayEquals(arr1, arr2);

        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void secondTest(){
        try(Writer writer = new FileWriter("test.txt");
            Reader reader = new FileReader("test.txt")){
            int [] arr = {'a', 'b', 'c', 'd', 'e'};
            int [] arr2 = new int[arr.length];
            StreamClass.writeCharsInStream(writer, arr);
            StreamClass.readCharsFromStream(reader, arr2);
            assertArrayEquals(arr, arr2);
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void thirdTest() throws IOException {
        long pos = 3 * Integer.BYTES;
        RandomAccessFile raf = new RandomAccessFile("C:\\Users\\User\\IdeaProjects\\Stream\\test1.txt", "rw");
        raf.writeInt(125);
        raf.writeInt(500);
        raf.writeInt(245);
        raf.writeInt(588);
        raf.writeInt(714);
        int[] answer = {588, 714};
        assertArrayEquals(StreamClass.readRandomAccessFile(raf, pos), answer);
        raf.close();
    }

    @Test
    public void fourthTest() throws IOException {
        File dir = new File("C:\\Users\\User\\IdeaProjects\\Stream");
        File file1 = new File(dir, "test.txt");
        File file2 = new File(dir, "test1.txt");
        List<File> res = new ArrayList<>();
        res.add(file1);
        res.add(file2);
        List<File> fileRes = StreamClass.filesCatalog("txt", dir);
        assertEquals(res, fileRes);
    }

    @Test
    public void sixthTest() throws Exception{
        List<Person> personFlat1 = new ArrayList<>();
        personFlat1.add(new Person("Вадим", "Пискунов", "Алесандрович", 17, 3, 2002));
        personFlat1.add(new Person("Валерия", "Даниель", "Вадимовна", 4, 11, 2002));
        List<Person> personFlat2 = new ArrayList<>();
        personFlat2.add(new Person("Иван", "Загребин", "Евгеньевич", 21, 4, 2001));
        List<Person> personFlat3 = new ArrayList<>();
        personFlat3.add(new Person("Андрей", "Козлов", "Дмитриевич", 4, 11, 2003));
        personFlat3.add(new Person("Елизавета", "Петрунишина", "Павловна", 12, 7, 1999));

        List<Flat> flats = new ArrayList<>();
        flats.add(new Flat(1, 120, personFlat1));
        flats.add(new Flat(2, 80, personFlat2));
        flats.add(new Flat(3, 96, personFlat3));

        House house = new House("31:57:63:12", "ул. Туполева 4/1", new Person
                ("Иван", "Иванов", "Иванович", 31, 1, 1999), flats);

        OutputStream outputStream = new DataOutputStream(new FileOutputStream("test2.txt"));
        InputStream inputStream = new DataInputStream(new FileInputStream("test2.txt"));
        SerializeAndDeserialize.houseSerialize(house, outputStream);
        assertEquals(house, SerializeAndDeserialize.houseDeserialize(inputStream));
    }

    @Test
    public void eightTest() throws IOException {
        List<Person> personFlat1 = new ArrayList<>();
        personFlat1.add(new Person("Вадим", "Пискунов", "Алесандрович", 17, 3, 2002));
        personFlat1.add(new Person("Валерия", "Даниель", "Вадимовна", 4, 11, 2002));
        List<Person> personFlat2 = new ArrayList<>();
        personFlat2.add(new Person("Иван", "Загребин", "Евгеньевич", 21, 4, 2001));
        List<Person> personFlat3 = new ArrayList<>();
        personFlat3.add(new Person("Андрей", "Козлов", "Дмитриевич", 4, 11, 2003));
        personFlat3.add(new Person("Елизавета", "Петрунишина", "Павловна", 12, 7, 1999));

        List<Flat> flats = new ArrayList<>();
        flats.add(new Flat(1, 120, personFlat1));
        flats.add(new Flat(2, 80, personFlat2));
        flats.add(new Flat(3, 96, personFlat3));

        House house = new House("31:57:63:12", "ул. Туполева 4/1", new Person
                ("Иван", "Иванов", "Иванович", 31, 1, 1999), flats);
        assertEquals(house, House.HouseFromJson(House.HouseToJson(house)));
    }
}
