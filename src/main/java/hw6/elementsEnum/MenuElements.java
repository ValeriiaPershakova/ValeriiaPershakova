package hw6.elementsEnum;


public enum MenuElements {
    HOME("HOME", "https://epam.github.io/JDI/index.html"),
    CONTACT_FORM("CONTACT FORM", "https://epam.github.io/JDI/contacts.html"),
    METALS_COLORS("METALS & COLORS", "https://epam.github.io/JDI/metals-colors.html"),
    SUPPORT("Support", "https://epam.github.io/JDI/support.html"),
    DATES("Dates", "https://epam.github.io/JDI/dates.html"),
    COMPLEX_TABLE("Complex Table", "https://epam.github.io/JDI/complex-table.html"),
    SIMPLE_TABLE("Simple Table", "https://epam.github.io/JDI/simple-table.html"),
    TABLE_WITH_PAGES("Table with pages", "https://epam.github.io/JDI/table-pages.html"),
    DIFFERENT_ELEMENTS("Different elements", "https://epam.github.io/JDI/different-elements.html"),
    USER_TABLE("User Table", "https://epam.github.io/JDI/user-table.html");

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
