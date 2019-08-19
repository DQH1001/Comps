import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	org.springframework.web.filter.CharacterEncodingFilter t;
	//web方式监听器方式启动ioc容器
	org.springframework.web.context.ContextLoaderListener o;
	
	org.springframework.web.util.IntrospectorCleanupListener l;
	//spring配置连接db数据源核心对象，对象核心目的是整合"操控"mybatis
	//启动Tomcat如同启动了ioc容器，如同启动了mybatis工厂连接池
	org.springframework.jdbc.datasource.DriverManagerDataSource c;
	//mybatis的启动，需要ioc 核心DriverManagerDataSource的注入操作，从而实现整合
	org.mybatis.spring.SqlSessionFactoryBean p;
	//配置所有mapper接口
	org.mybatis.spring.mapper.MapperScannerConfigurer m=null;
//    m.set
	//
	org.springframework.jdbc.datasource.DataSourceTransactionManager g;
	public static void main(String[] args) {
		//测试new方式启动ioc容器
//        ApplicationContext ac=new ClassPathXmlApplicationContext();
	
	}

}
