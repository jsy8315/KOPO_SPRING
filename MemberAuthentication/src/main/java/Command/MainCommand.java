package Command;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainCommand implements Command {
    
    private String viewPage = "Main.jsp";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public String getViewPage() {
        if (viewPage == null) {
            viewPage = "../error.jsp";
        }
        return viewPage;
    }

}
