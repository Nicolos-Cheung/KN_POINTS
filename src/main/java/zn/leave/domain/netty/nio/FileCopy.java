package zn.leave.domain.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/04
 */
public class FileCopy {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("/Users/ning/a.txt");
        FileOutputStream fos = new FileOutputStream("/Users/ning/a.txt");


        FileChannel sourceChannel = fis.getChannel();

        FileChannel destChannel = fos.getChannel();

        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

        sourceChannel.close();
        destChannel.close();
        fis.close();
        fos.close();
    }
}
