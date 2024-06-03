package kr.co.soldesk.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringConfigClass implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		///-----------------------------------------------------------------------------------------
		// 콘솔창에 뜨는지 테스트
		System.out.println("onStartup~~~!");

		// 프레임웍 환경설정을 위한 클래스 객체
		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();

		// 환경 설정 클래스의 구현부가 서버에 로드되는 객체(= servletAppContext )
		servletAppContext.register(ServletAppContext.class);

		// 요청 발생 시, 이 요청을 처리하는 서블릿을 DispatcherServlet으로 설정
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);

		// 부가 설정
		servlet.setLoadOnStartup(1); // 가장 먼저 이 객체를 업로드 해
		servlet.addMapping("/"); // 루트로 이동

		///-----------------------------------------------------------------------------------------
		// 서버 메모리 확보
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		rootAppContext.register(RootAppContext.class);

		// 확보된 메모리의 객체 로드
		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
		servletContext.addListener(listener);

		// dispatcher, 즉 jsp... 정적 파일에 대해서 UTF-8로 인코딩하는 필터 객체를 생성
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		filter.addMappingForServletNames(null, false, "dispatcher");
		
		///-----------------------------------------------------------------------------------------
	} // method

} // class
