package com.team3.parser;

import java.io.IOException;
import java.util.List;


public interface Parser {

     List<String[]> process() throws IOException;
}
