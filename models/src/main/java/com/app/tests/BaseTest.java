package com.app.tests;

import java.io.PrintWriter;
import java.util.List;

public abstract class BaseTest {

    protected static void h1(PrintWriter writer, Object content) {
        writer.append("<h1 class='p-3 bg-primary text-white'>").append(content.toString()).append("</h1>");
    }

    protected static  void h2(PrintWriter writer, Object content) {
        writer.append("<h2>").append(content.toString()).append("</h2>");
    }

    protected static void item(PrintWriter writer, Object content) {
        writer.append("<span  class=\"list-group list-group-item \">").append(content.toString()).append("</span>");

    }

    protected static void list(PrintWriter writer, List<?> content) {
        writer.append("<ul class=\"list-group\">");
        for (Object item : content) {
            writer.append("<li  class=\"list-group-item\">").append(item.toString()).append("</li>");
        }
        writer.append("</ul>");
    }
}
