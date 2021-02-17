package com.shoppingcart.sbhibernateshoppingcart.pagination;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PaginationResult <E>{

    private int totalRecords;
    private int currentPage;
    private List<E> list;
    private int maxResult;
    private int totalPages;
    private int maxNavigationPage;
    private List<Integer> navigationPages;

    //@page: 1, 2...
    public PaginationResult(Query<E>query, int page, int maxResult, int maxNavigationPage) {
        final int pageIndex = Math.max(page - 1, 0);

        int fromRecordIndex = pageIndex * maxResult;
        int maxRecordIndex = fromRecordIndex + maxResult;

        ScrollableResults resultScroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);

        List<E> results = new ArrayList<>();

        boolean hasResult = resultScroll.first();
        if (hasResult) {
            do {
                E record = (E) resultScroll.get(0);
                results.add(record);

            } while (resultScroll.next()
                    && resultScroll.getRowNumber() >= fromRecordIndex
                    && resultScroll.getRowNumber() < maxRecordIndex);
        }
    }
}
