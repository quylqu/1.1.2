package jm.task.core.jdbc;

import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        //Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Util util = new Util();
        util.getConnection();


    }

}

