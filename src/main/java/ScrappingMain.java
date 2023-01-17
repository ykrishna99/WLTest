/*
    -This is the main class
    -When you run this class it will retrieve products and generates Json file.
 */
public class ScrappingMain {
    public static void main(String[] args) {
        ScrappingService scrappingService = new ScrappingService();
        scrappingService.doScrape();
    }
}
