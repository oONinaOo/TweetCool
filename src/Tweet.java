import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Tweet extends javax.servlet.http.HttpServlet {
    List<TweetInfo> tweets = new ArrayList<>();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        String message = request.getParameter("tweet");
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();

        if(name.equals("") || message.equals("")){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('No name or message given!');");
            out.println("location='index.html';");
            out.println("</script>");
        }
        else {
            tweets.add(new TweetInfo(name, message));
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Date today = new Date();
        String date = "<" + sdf.format(today) + ">";
        out.println(htmlPage());

        out.println("<div class = messageposition>");
        Collections.reverse(tweets);
        for (TweetInfo tweet: tweets) {
            out.println("<h4>From: " + tweet.getName() + " @ " + date.format(String.valueOf(tweet.getDate())) + "</h4>");
            out.println("<h4>Message: " + tweet.getMessage() + "</h4>");
            out.println("_________________________________");

        }
        out.println("</div>\n");


    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
    public String htmlPage(){
        String title = "TweetCool";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
                "transitional//en\">\n";
        String page = docType +
        "<html xmlns=\"http://www.w3.org/1999/xhtml\">" +
        "<head>" +
        "<link rel=\"stylesheet\" type=\"text/css\" href=\"style/style.css\">" +
        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />" +
        "<title>" + title + "</title>" +
        "</head>" +

        "<body>" +
                "\n" +
        "<div align=\"center\">" +
        "<img src=\"images/main.png\" width=\"800\" height=\"600\" />" +
        "<p>&nbsp; </p>" +
        "</div>" +
        "<div class = \"formposition\">" +
        "<form action=\"Tweet\" method=\"POST\">" +
        "<table width=\"330\" border=\"0\">" +
        "<tr>" +
        "<td width=\"57\">Name:</td>" +
        "<td width=\"257\">" + "<input type=\"text\" size=\"21\" name=\"name\">" + "</td>" +
        "</tr>" +
        "<tr>" +
        "<td valign=\"top\">Message:</td>" +
        "<td rowspan=\"2\">" + "<textarea cols=\"22\" rows=\"9\" name=\"tweet\">" +
        "</textarea>" + "</td>" +
        "</tr>" +
        "<tr>" +
        "<td>&nbsp;</td>" +
        "</tr>" +
        "</table>" +
        "<input type=\"submit\" value=\"Submit\" class =\"submit\">" +
        "</form>" +
        "</div>" + "<div class = \"optimized\">Optimized for 1600x900 desktop</div>" +
        "</body>" +
        "</html>";

        return page;
    }
}
