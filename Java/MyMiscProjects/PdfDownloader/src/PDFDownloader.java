import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PDFDownloader {
	static String num;
    public static List<String> getPDFLinks(String url) {
        List<String> pdfLinks = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            boolean s=true;
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                String href = link.attr("href");
                if (href.endsWith(".pdf")) {
                	if(s)
                	{
                		num=href.substring(0,2);
                	}
                	href=url+href;
                    pdfLinks.add(href);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pdfLinks;
    }

    public static File createTempDirectory() {
        try {
            Path tempDirPath = Files.createTempDirectory("pdfs");
            return tempDirPath.toFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void downloadPDFs(List<String> pdfLinks, File directory) {
        try {
            for (String pdfLink : pdfLinks) {
                URL url = new URL(pdfLink);
                InputStream in = url.openStream();
                Files.copy(in, Paths.get(directory.getAbsolutePath(), getFileName(pdfLink)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File createZipFile(File directory) {
        try {
            String zipFileName = directory.getName() + ".zip";
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            Files.walk(directory.toPath())
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(directory.toPath().relativize(path).toString());
                        try {
                            zos.putNextEntry(zipEntry);
                            zos.write(Files.readAllBytes(path));
                            zos.closeEntry();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            zos.close();
            fos.close();
            return new File(zipFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String createDownloadLink(File zipFile) {
        return zipFile.getAbsolutePath();
    }

    private static String getFileName(String url) {
        int lastSlashIndex = url.lastIndexOf("/");
        if (lastSlashIndex >= 0 && lastSlashIndex < url.length() - 1) {
            return url.substring(lastSlashIndex + 1);
        } else {
            return "download.pdf";
        }
    }
    
    public static void copyPDFsToDirectory(File tempDir, String directoryPath, String foldername) {
        String lastWord = foldername;
        File newDir = new File(directoryPath +num+" "+ lastWord);
        newDir.mkdir();
        File[] pdfFiles = tempDir.listFiles((dir, name) -> name.endsWith(".pdf"));
        for (File pdfFile : pdfFiles) {
            try {
                Files.copy(pdfFile.toPath(), new File(newDir.getAbsolutePath() + "/" + pdfFile.getName()).toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
    	System.out.println("Hi! How are you. Enter Your Web Site Link To Download All the PDf...");
    	Scanner sc=new Scanner(System.in);
    	String url=sc.next();
        List<String> pdfLinks = getPDFLinks(url);
        File tempDir = createTempDirectory();
        downloadPDFs(pdfLinks, tempDir);
        String directoryPath = "C:\\Users\\india\\Downloads\\Nuclear and Particle Physics\\";
        String lastWord = url.substring(url.lastIndexOf('/', url.lastIndexOf('/') - 1) + 1, url.lastIndexOf('/'));
        copyPDFsToDirectory(tempDir, directoryPath, lastWord);
        System.out.println("Done");
        //File zipFile = createZipFile(tempDir);
        //String downloadLink = createDownloadLink(zipFile);
        //System.out.println("Download link: " + downloadLink);
    }
}
