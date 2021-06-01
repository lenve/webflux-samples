package org.javaboy.async.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@WebServlet(urlPatterns = "/async",asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        AsyncContext asyncContext = request.startAsync();
        CompletableFuture.runAsync(() -> printLog(asyncContext,asyncContext.getRequest(),asyncContext.getResponse()));
        System.out.println("总耗时：" + (System.currentTimeMillis() - start));
    }

    private void printLog(AsyncContext asyncContext, ServletRequest request, ServletResponse response){
        try {
            Thread.sleep(3000);
            response.getWriter().write("ok");
            asyncContext.complete();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
