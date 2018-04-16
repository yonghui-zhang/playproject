package com.zyh.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SearchFactory {
    private SearchFactory()
    {

    }

  //  @Deprecated
    public static Search newSearch()
    {
        Search search = null;
        ServiceLoader<Search> searchServiceLoader = ServiceLoader.load(Search.class);
        Iterator<Search> searchIterator = searchServiceLoader.iterator();


        if (searchIterator.hasNext())
        {
            search = searchIterator.next();
        }
        return search;
    }
}
