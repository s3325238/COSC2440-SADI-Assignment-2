# HelloHibernateSpringMVC

This is a continuity of the previous project HelloHibernateAnnotation. With HelloHibernateAnnotation, we can create sessionFactory and studentService to talk to database. In this example, we take it further by integrating the web tier. 

SpringMVC is a Spring module that can help us to create MVC web application. It is a good substitution for Struts 1, 2. In addition, SpringMVC supports Restful webservices which is very popular nowsday. 

**1**. The pom.xml
The pom.xml is very similar to HelloHibernateAnnotation but we need to add some dependencies related to SpringMVC
+ spring-webmvc: obviously we need this dependency
+ javax.servlet-api: to work with SpringMVC we need a ServletDispatcher. That's why servlet-api is needed
+ jackson-databind: well this is strange but we need jackson to return json in our restful controller

**2**. Patient Controller include 4 functions:
+ Get full patients in the database `(GET method)`: 

    http://localhost:8080/patients
+ Get patient by his/her id `(GET method)`:

    http://localhost:8080/patients/getPatientById/{id}

    `param id: patient id in the database you want to get`
    
+ Add new patient `(POST method)`:

    http://localhost:8080/patients/add
    
    `{
        
        "patient_name": "New patient with prescription #2 in visit list",
        
        "birth_Date": "YYYY-MM-DD",
        
        "gender": "Male",
        
        "address": "702 Nguyen Van Linh",
        
        "visitList": [
            
            {
                
                "visit_content": "You have successfully add new visit for patient id: 2",
                
                "prescriptionList": [
                    
                    {
                        
                        "main_content": "You have successfully add new main content of prescription for visit id 2",
                        
                        "optional_content": "You have successfully add new optional content of prescription for visit id 2"
                    
                    }
                    
                ]
                
            }
            
        ]
        
    }`


In order to wire sessionFactory and studentService beans, we need to inject AppConfig class into the getRootConfigClasses method of AbstractAnnotationConfigServletDispatcherInitializer. 


        protected Class<?>[] getRootConfigClasses() {
                return new Class[]{AppConfig.class};
        }
    
The AppConfig class is very similar to beans.xm where we define all the beans. Remember to add 4 annotations:
-@Configuration: to denote that this class will contain beans
-@EnableTransationManagement: to denote that we will have transactionManager bean
-@EnableWebMVC: to say that we want to use SpringMVC
-@ComponentScan: to tell SpringMVC where to look for all the controllers



        @Configuration
        @EnableTransactionManagement
        @EnableWebMvc
        @ComponentScan("controller")
        public class AppConfig {

            @Bean
            public StudentService studentService(){
                return new StudentService();
            }

            @Bean
            public LocalSessionFactoryBean sessionFactory(){
                LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

                sessionFactoryBean.setPackagesToScan("model");

                DriverManagerDataSource dataSource = new DriverManagerDataSource();
                dataSource.setDriverClassName("org.postgresql.Driver");
                dataSource.setUrl("jdbc:postgresql://localhost:5432/hello");
                dataSource.setUsername("postgres");
                dataSource.setPassword("rmit");

                sessionFactoryBean.setDataSource(dataSource);

                return sessionFactoryBean;
            }

            @Bean
            public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
                HibernateTransactionManager tx = new HibernateTransactionManager(sessionFactory);

                return tx;
            }

        }
