package zn.leave.domain.designpattern.decorator.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/02/01
 */
public class Simulator {

    public static void main(String[] args) {

        int c;
        try {

            InputStream in = new LowCaseInputStream(new BufferedInputStream(new FileInputStream("/Users/ning/Downloads/test.txt")));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
