package hw6.elementsEnum;


public enum ServiceMenuElements {
    SUPPORT("SUPPORT", "https://epam.github.io/JDI/support.html"),
    DATES("DATES", "https://epam.github.io/JDI/dates.html"),
    COMPLEX_TABLE("COMPLEX TABLE", "https://epam.github.io/JDI/complex-table.html"),
    SIMPLE_TABLE("SIMPLE TABLE", "https://epam.github.io/JDI/simple-table.html"),
    TABLE_WITH_PAGES("TABLE WITH PAGES", "https://epam.github.io/JDI/table-pages.html"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS", "https://epam.github.io/JDI/different-elements.html");

    private String description;
    private String url;

    ServiceMenuElements(String description, String url) {
        this.description = description;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
