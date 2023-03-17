package practice06;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateFileServlet")
public class CreateFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		  	1. 파일 만들기
		  		1) 파일명 : yyyy-mm-dd-작성자-제목.txt
		  		2) 파일경로 : RealPath에 storage 디렉터리를 만들어서 저장
		  		3) 파일내용 : 내용 그대로 추가
		 */
		/*
		 	2. FileResponseServlet으로 리다이렉트
		 		파일명 전달
		 */
		
		request.setCharacterEncoding("UTF-8");
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String container = request.getParameter("container");
		
		
		File dir = new File(request.getServletContext().getRealPath("practice06") + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
			System.out.println("ok");
		} 
		SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
		
		String fileName = dateform.format(new Date()) + "-" + writer + "-" + title + ".txt";
		
		File file = new File(dir, fileName);
		if(file.exists() == false) {
			file.createNewFile();	
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		bw.write(container);
		bw.flush();
		bw.close();
		
		
		response.sendRedirect("/01_Servlet/FileResponseServlet?fileName=" + URLEncoder.encode(fileName, "UTF-8"));

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
