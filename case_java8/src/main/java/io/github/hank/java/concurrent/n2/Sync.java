package io.github.hank.java.concurrent.n2;

import io.github.hank.java.concurrent.Constants;
import io.github.hank.java.concurrent.n2.util.FileReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Sync")
public class Sync {

    public static void main(String[] args) {
        FileReader.read(Constants.JPG_FULL_PATH);
        log.debug("do other things ...");
    }

}
