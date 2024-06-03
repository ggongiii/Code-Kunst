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
		// �ܼ�â�� �ߴ��� �׽�Ʈ
		System.out.println("onStartup~~~!");

		// �����ӿ� ȯ�漳���� ���� Ŭ���� ��ü
		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();

		// ȯ�� ���� Ŭ������ �����ΰ� ������ �ε�Ǵ� ��ü(= servletAppContext )
		servletAppContext.register(ServletAppContext.class);

		// ��û �߻� ��, �� ��û�� ó���ϴ� ������ DispatcherServlet���� ����
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);

		// �ΰ� ����
		servlet.setLoadOnStartup(1); // ���� ���� �� ��ü�� ���ε� ��
		servlet.addMapping("/"); // ��Ʈ�� �̵�

		///-----------------------------------------------------------------------------------------
		// ���� �޸� Ȯ��
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		rootAppContext.register(RootAppContext.class);

		// Ȯ���� �޸��� ��ü �ε�
		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
		servletContext.addListener(listener);

		// dispatcher, �� jsp... ���� ���Ͽ� ���ؼ� UTF-8�� ���ڵ��ϴ� ���� ��ü�� ����
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		filter.addMappingForServletNames(null, false, "dispatcher");
		
		///-----------------------------------------------------------------------------------------
	} // method

} // class
