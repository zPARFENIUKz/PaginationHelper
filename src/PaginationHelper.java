import java.util.List;

public class PaginationHelper<I> {
    private final int itemsPerPage;
    private final int countOfItems;
    private final int countOfPages;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        countOfItems = collection.size();
        countOfPages = collection.size() / itemsPerPage + 1;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return countOfItems;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return countOfPages;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        final int firstPagesItemIndex = itemsPerPage * pageIndex;
        if (firstPagesItemIndex >= countOfItems) return -1;
        return Math.min(countOfItems - firstPagesItemIndex, itemsPerPage);
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= countOfItems) return -1;
        return (itemIndex + 1) / itemsPerPage;
    }
}