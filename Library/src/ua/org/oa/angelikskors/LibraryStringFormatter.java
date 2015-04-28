package ua.org.oa.angelikskors;

public class LibraryStringFormatter {

    private static final String DEFAULT_DIVIDER = ";";

    private final String divider;

    public LibraryStringFormatter() {
        this(DEFAULT_DIVIDER);
    }

    public LibraryStringFormatter(String divider) {
        this.divider = divider;
    }

    public LibraryString parse(String string){
        String [] fields = string.split(divider);

        if(fields.length < 3){
            return null;
        }

        String author = fields[0].trim();
        String name = fields[1].trim();
        int year = Integer.parseInt(fields[2].trim());

        return new LibraryString(author, name, year);
    }

    public String format(LibraryString libraryString){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(libraryString.getAuthor()).append(divider);
        stringBuilder.append(libraryString.getName()).append(divider);
        stringBuilder.append(libraryString.getYear()).append("\n");
        return stringBuilder.toString();
    }
}
