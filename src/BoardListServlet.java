import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import org.h2.Driver;
import java.util.ArrayList;

@WebServlet(name = "BoardListServlet",
            value = "/BoardListServlet")
public class BoardListServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException{
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        System.out.println(driver + " " + url);
        super.init(config);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
//            org.h2.Driver.load();

            ServletContext sc = this.getServletContext();
            System.out.println("driver 값 >>>> " + sc.getInitParameter("driver"));
            Class.forName("org.h2.Driver");
            String url = sc.getInitParameter("jdbc:h2:mem:board");
            String username = sc.getInitParameter("ggyu");
            String password = sc.getInitParameter("123");
            System.out.println(url);
            System.out.println(username);
            System.out.println(password);
            con = DriverManager.getConnection(url, username, password);
//                    sc.getInitParameter("url"),
//                    sc.getInitParameter("username"),
//                    sc.getInitParameter("password"));
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT BOARD_SEQ, BOARD_SUBJECT, REGISTER_ID, READ_CNT, REGISTER_DATE " +
                    "FROM BOARD " +
                    "ORDER BY REGISTER_DATE DESC, BOARD_SEQ DESC");

//            ArrayList<BoardVo> boardList = new ArrayList<BoardVo>();
//            while (rs.next()){
//                BoardVo bvo = new BoardVo();
//                bvo.setBoard_seq(rs.getInt("BOARD_SEQ"));
//                bvo.setBoard_subject(rs.getString("BOARD_SUBJECT"));
//                bvo.setRead_cnt(rs.getInt("READ_CNT"));
//                bvo.setRegister_id(rs.getString("REGISTER_ID"));
//                boardList.add(bvo);
//            }
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>게시판</title><style>table, tr, td {border: 1px solid black;}</style></head>");
            out.println("<body><h1>test</h1>");
            out.println("<table>" +
                    "<thead><tr><td>글 번호</td><td>제목</td><td>작성자</td><td>조회수</td><td>작성일</td></tr></thead>" +
                    "<tbody><tr><td>"+rs.getInt("BOARD_SEQ")+"</td>" +
                    "<td>"+ rs.getString("BOARD_SUBJECT")+"</td>" +
                    "<td>"+ rs.getString("REGISTER_ID")+"</td>" +
                    "<td>"+ rs.getString("READ_CNT")+"</td>" +
                    "<td>"+ rs.getString("REGISTER_DATE")+"</td>" +
                    "<tr></tbody>" +
                    "</table>");
            out.println("</body></html>");
            con.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
