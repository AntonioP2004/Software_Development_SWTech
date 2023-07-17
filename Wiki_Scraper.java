package Capstone_Project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Wiki_Scraper {
    private Set<String> visitedUrls;

    public Wiki_Scraper() {
        visitedUrls = new HashSet<>();
    }

    public void crawl(String url) throws HttpStatusException, FileNotFoundException {
    	try {
            Document document = Jsoup.connect(url).get();
            
            Elements links = document.select("a[href]");
            
            for (Element link : links) {
                String href = link.attr("abs:href");

                String fragment = "";
                int fragmentIndex = href.indexOf('#');
                if (fragmentIndex != -1) {
                    fragment = href.substring(fragmentIndex);
                    href = href.substring(0, fragmentIndex);
                }
                
                if (!visitedUrls.contains(href) && href.contains("https://scp-wiki.wikidot.com/scp")) {
                    visitedUrls.add(href);
                    
                    final String finalHref = href;
                    final String finalFragment = fragment;

                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    executor.submit(() -> {
                        try {
                            System.out.println("New Thread: " + finalHref + " " + visitedUrls.size());
                            
                            crawl(finalHref + finalFragment);
                            
                            String excludedText = "https://scp-wiki.wikidot.com/";
                            String extractedText = finalHref.replace(excludedText, "");
                            String newFileName = extractedText + ".html";
                            
                            String directoryPath = "C:/SCP Files/SCP-Index";
                            String filePath = directoryPath + File.separator + newFileName;
                            
                            File directory = new File(directoryPath);
                            File file = new File(filePath);
                            
                            if (!directory.exists()) {
                                boolean created = directory.mkdirs();
                                if (created) {
                                    System.out.println("Directory path created: " + directory.getAbsolutePath());
                                } else {
                                    System.out.println("Failed to create directory path");
                                }
                            }
                            
                            try {
                                if (file.createNewFile()) {
                                    System.out.println("File created: " + file.getAbsolutePath());
                                } else {
                                    System.out.println("File already exists");
                                }
                            } catch (IOException e) {
                                System.out.println("Failed to create file: " + e.getMessage());
                            }

                            
                            int maxRetries = 100;
                            int retryCount = 0;
                            boolean passed = false;
                            while (retryCount < maxRetries && !passed) {
	                            try(PrintWriter output = new PrintWriter(file)) {
	                            	Document scrapingDocument = Jsoup.connect(finalHref).get();
	                            	
	                            	Element mainContentDiv = scrapingDocument.getElementById("main-content");
	                            	String mainContentText = mainContentDiv.text();
	                            	
	                            	output.print(mainContentText);
	                            	output.print("<p><a href=\"linksList.html\">to the links!</a></p>");
	                            	System.out.println("Page scraped for " + newFileName);
	                            	passed = true;
	                            } catch (HttpStatusException e) {
	                            	System.out.print("ERROR 404 page does not exist...");
	                            	break;
	                            } catch (SocketException e) {
	                            	System.out.print("ERROR Connection reset trying again...");
	                            	retryCount++;
	                            	System.out.println("Retry count: " + retryCount + " for " + newFileName);
	                            }catch (SocketTimeoutException e) {
	                            	System.out.print("ERROR too fast trying again...");
	                            	retryCount++;
	                            	System.out.println("Retry count: " + retryCount + " for " + newFileName);
	                            } catch (IOException e) {
	                            	System.out.print("ERROR unknown IOException...");
	                            	retryCount++;
	                            	System.out.println("Retry count: " + retryCount + " for " + newFileName);
	                            }

	                            
	                            String filePathLink = "C:/SCP Files/SCP-Index/linksList.html";

	                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePathLink, true))) {
	                                String textToAppend = "             		<p><a href=\"" + newFileName + "\">" + extractedText + "</a></p>\n";
	                                writer.write(textToAppend);

	                                System.out.println("Text appended to the file.");
	                            } catch (IOException e) {
	                                System.err.println("Error appending text to the file: " + e.getMessage());
	                            }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            executor.shutdown();
                        }
                    });
                }
            }
        } catch (HttpStatusException e) {
        	System.out.println("ERROR 404 page does not exist.");
        } catch (SocketException e) {
        	System.out.println("ERROR Connection reset.");
        }catch (SocketTimeoutException e) {
        	System.out.println("ERROR too fast. ");
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    public static void main(String[] args) throws HttpStatusException, FileNotFoundException {
        Wiki_Scraper crawler = new Wiki_Scraper();
        crawler.crawl("https://scp-wiki.wikidot.com");
        
        while (!Thread.currentThread().isInterrupted()) {
            if (Thread.activeCount() == 1)
                break;
        }
    }
}

