package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 파라미터 전송 기능
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");

        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                .forEachRemaining(param -> System.out.println("param = " + request.getParameter(param)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");

        System.out.println("username = " + request.getParameter("username"));
        System.out.println("age = " + request.getParameter("age"));

        System.out.println();
        System.out.println("[이름이 같은 복수 파라미터 조회]");

        for (String username : request.getParameterValues("username")) {
            System.out.println("username = " + username);
        }

        response.getWriter().write("ok");
    }
}
