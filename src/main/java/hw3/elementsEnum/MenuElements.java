package hw3.elementsEnum;


public enum MenuElements {
    HOME("HOME", "https://epam.github.io/JDI/index.html"),
    CONTACT_FORM("CONTACT FORM", "https://epam.github.io/JDI/contacts.html"),
    METALS_COLORS("METALS & COLORS", "https://epam.github.io/JDI/metals-colors.html"),
    SUPPORT("SUPPORT", "https://epam.github.io/JDI/support.html"),
    DATES("DATES", "https://epam.github.io/JDI/dates.html"),
    COMPLEX_TABLE("COMPLEX TABLE", "https://epam.github.io/JDI/complex-table.html"),
    SIMPLE_TABLE("SIMPLE TABLE", "https://epam.github.io/JDI/simple-table.html"),
    TABLE_WITH_PAGES("TABLE WITH PAGES", "https://epam.github.io/JDI/table-pages.html"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS", "https://epam.github.io/JDI/different-elements.html");

    private String description;
    private String url;

    MenuElements(String description, String url) {
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
