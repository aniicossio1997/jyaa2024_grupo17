package testsServlets;

import java.io.PrintWriter;
import java.util.List;

public class ResponseWriter {

    private PrintWriter writer;

    public ResponseWriter(PrintWriter writer) {
        this.writer = writer;
    }

    protected void h1(Object content) {
        writer.append("<h1 class='p-3 bg-primary text-white'>").append(content.toString()).append("</h1>");
    }

    protected void h2(Object content) {
        writer.append("<h2>").append(content.toString()).append("</h2>");
    }

    protected void item(Object content) {
        writer.append("<span  class=\"list-group list-group-item \">").append(content.toString()).append("</span>");

    }

    protected void list(List<?> content) {
        writer.append("<ul class=\"list-group\">");
        for (Object item : content) {
            writer.append("<li  class=\"list-group-item\">").append(item.toString()).append("</li>");
        }
        writer.append("</ul>");
    }
}
