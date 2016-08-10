package sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.MemberVo;

@WebServlet("/07")
public class _07Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVo vo = new MemberVo();
		vo.setName("둘리");
		vo.setEmail("dooly@gmail.com");
		vo.setNo(3L);
		vo.setGender("MALE");
		//requestScope 저장
		request.setAttribute("memberVo", vo);
		MemberVo vo2 = new MemberVo();
		vo2.setName("둘리호");
		vo2.setEmail("dooly@gmail.com");
		vo2.setNo(2L);
		vo2.setGender("FEMALE");
		
		//requestScope 저장
		request.setAttribute("memberVo2", vo2);
		//sessionScope 저장
		HttpSession session = request.getSession(true);
		
		//ApplicationScope 저장
		MemberVo vo3 = new MemberVo();
		vo3.setName("고길동");
		vo3.setEmail("dooly@gmail.com");
		vo3.setNo(1L);
		vo3.setGender("FEMALE");
		this.getServletContext().setAttribute("memberVo3",vo3 );
		request.getRequestDispatcher( "/view/07.jsp" ).forward( request, response );
	}
}
