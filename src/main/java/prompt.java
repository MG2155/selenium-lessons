import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;


public class prompt {

    public static void main(String[] args) throws IOException{
        writeCSV("D:\\test.csv", ",");
    }
    public static void writeCSV(String filePath, String separator) throws IOException {
        /**
         * We use try with resource so we don't need to call close
         * method or write finally block explicitly it will be called automatically. 
         */
        try (OutputStream fileStream = new BufferedOutputStream(new FileOutputStream(filePath));
             Writer outStreamWriter = new OutputStreamWriter(fileStream, StandardCharsets.UTF_8);
             BufferedWriter buffWriter = new BufferedWriter(outStreamWriter)) {
            buffWriter.append("Data1");
            buffWriter.append(separator);
            buffWriter.append("Data2");
            buffWriter.newLine();
            buffWriter.flush();
            buffWriter.append("1");
            buffWriter.append(separator);
            buffWriter.append("2");
            buffWriter.newLine();
            buffWriter.flush();
            buffWriter.append("11");
            buffWriter.append(separator);
            buffWriter.append("22");
            buffWriter.flush();

        }
    }
}