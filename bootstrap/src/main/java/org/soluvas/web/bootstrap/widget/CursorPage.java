package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.markup.html.navigation.paging.IPageable;

import java.io.Serializable;
import java.util.List;

/**
 * Similar to {@link org.apache.wicket.markup.html.navigation.paging.IPageable} but intended for cursor-based pagination.
 * However, it's still work in progress, meaning that the "current page" is not exactly a cursor.
 * The primary difference is that it doesn't have {@link IPageable#getPageCount()}
 * which is not possible in curser-based pagination.
 */
public class CursorPage<T> implements Serializable {
    private long currentPage;
    private boolean nextAvailable;
    private List<T> content;

    public CursorPage() {
    }

    public CursorPage(long currentPage, boolean nextAvailable, List<T> content) {
        this.currentPage = currentPage;
        this.nextAvailable = nextAvailable;
        this.content = content;
    }

    /**
     * @return The current page that is or will be rendered (page number is zero-based)
     */
    long getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets the a page that should be rendered (page number is zero-based)
     *
     * @param page
     *            The page that should be rendered.
     */
    void setCurrentPage(long page) {
        this.currentPage = page;
    }

    public boolean isNextAvailable() {
        return nextAvailable;
    }

    public void setNextAvailable(boolean nextAvailable) {
        this.nextAvailable = nextAvailable;
    }

    public List<T> getContent() {
        return content;
    }
}
