package StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class N12CreateZipArchive {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("outputFile.zip");
            ZipOutputStream zip = new ZipOutputStream(fos);

            String file = "text.txt";

            writeToZipFile(file, zip);

            zip.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ignored) {
        }

    }

    private static void writeToZipFile(String path, ZipOutputStream zipStream)
            throws FileNotFoundException, IOException {
        System.out.println("Writing file : '" + path + "' to zip file");

        File aFile = new File(path);
        FileInputStream fis = new FileInputStream(aFile);
        ZipEntry zipEntry = new ZipEntry(path);
        zipStream.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipStream.write(bytes, 0, length);
        }
        zipStream.closeEntry();
        fis.close();


    }
}


