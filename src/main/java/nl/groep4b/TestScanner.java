package nl.groep4b;

public class TestScanner extends ScannerV2{
    String[] content;
    int current = -1;

    public TestScanner(String[] cont) {
        content = cont;
    }

    @Override
    public boolean nextBoolean() {
        current += 1;
        return Boolean.parseBoolean(content[current]);
    }

    @Override
    public int nextInt() {
        current += 1;
        return Integer.parseInt(content[current]);
    }

    @Override
    public String nextLine() {
        current += 1;
        return content[current];
    }
}
