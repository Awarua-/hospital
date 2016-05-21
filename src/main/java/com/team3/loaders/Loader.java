package com.team3.loaders;

import java.util.List;


public interface Loader<T> {

    List<T> load();
}
