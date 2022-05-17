import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StreamClass {

    public static void writeArrInStream(OutputStream out, int [] arr) {
        try (DataOutputStream outputStream = new DataOutputStream(out)) {
            for (int temp : arr) {
                outputStream.writeInt(temp);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readArrFromStream(InputStream in, int[] arr){
        try(DataInputStream InputStream = new DataInputStream(in)){
            for(int i = 0; i < arr.length; i++){
                arr[i] = InputStream.readInt();
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void writeCharsInStream(Writer out, int[] arr){
        try(BufferedWriter writer = new BufferedWriter(out)){
            for(int temp : arr){
                writer.write(String.valueOf(temp));
                writer.write(' ');
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void readCharsFromStream(Reader in, int[] res){
        try(BufferedReader reader = new BufferedReader(in)){
            String[] numbers = reader.readLine().split(" ");
            for(int i = 0; i < res.length; i++){
                res[i] = Integer.parseInt(numbers[i]);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static int[] readRandomAccessFile(RandomAccessFile raf, long position) throws IOException{
        int[] res = new int[(int) (raf.length() - position) / Integer.BYTES];
        raf.seek(position);
        for (int i = 0; i < res.length; i++) {
            res[i] = raf.readInt();
        }
        return res;
    }

    public static List<File> filesCatalog(String expansion, File dir) throws IOException{
        List<File> res = new ArrayList<>();
        File[] listFiles = dir.listFiles(File::isFile);
        if (listFiles == null){
            throw new IOException("Empty catalog");
        }
        for (File temp : listFiles){
            if (temp.getName().endsWith(expansion)){
                res.add(temp);
            }
        }
        return res;
    }
}
