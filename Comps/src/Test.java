import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	org.springframework.web.filter.CharacterEncodingFilter t;
	//web��ʽ��������ʽ����ioc����
	org.springframework.web.context.ContextLoaderListener o;
	
	org.springframework.web.util.IntrospectorCleanupListener l;
	//spring��������db����Դ���Ķ��󣬶������Ŀ��������"�ٿ�"mybatis
	//����Tomcat��ͬ������ioc��������ͬ������mybatis�������ӳ�
	org.springframework.jdbc.datasource.DriverManagerDataSource c;
	//mybatis����������Ҫioc ����DriverManagerDataSource��ע��������Ӷ�ʵ������
	org.mybatis.spring.SqlSessionFactoryBean p;
	//��������mapper�ӿ�
	org.mybatis.spring.mapper.MapperScannerConfigurer m=null;
//    m.set
	//
	org.springframework.jdbc.datasource.DataSourceTransactionManager g;
	public static void main(String[] args) {
		//����new��ʽ����ioc����
//        ApplicationContext ac=new ClassPathXmlApplicationContext();
	
	}

}
