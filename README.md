开发流程：
标签： ATT ： attention
      IM  :  important

    1. 在pom文件中引入druid 在开始时就要选中springboot，mybatis，jdbc没选中的话就要在pom中引入

    2. 写入yml，在yml中写入多环境开发和druid。多环境可以设置多个不同的数据库配置。

    3. dao， dao中需要包括pojo实体类和实体类对应的Dao接口。
             实体类用lombok（pom需要引用）中的@data即可
         BookDao（接口） ： 头部写@Mapper注解做映射   *ATT 可以直接引入MP，直接继承BaseMapper<Book>
                        ：： 在方法上面写@Insert （增删改查注解） 
                         *ATT ！除了@select外全部返回int，select一个返回Book，一个返回List<Book>
                              !!参数中，save和updata填的是Book book 这个对象，另外的写Integer id就可
                              ！！！返回值原因：这个方法返回的是它影响的行数，用来判断操作是否成功的
        
    4. service, 包括接口和impl包
                BookServce接口相对于BookDao来说是只改变了返回值，把int变成boolean，原因：见Impl的说明。  
                *IM impl实现类头部写入 @Transactional事务
                    ！service类标签(一般不建议在接口上)上添加@Transactional，可以将整个类纳入spring事务管理，
                      在每个业务方法执行时都会开启一个事务，不过这些事务采用相同的管理方式。事务在方法失败时可以进行回滚。
                    ！！返回Boolean类型：因为返回值是BookDao的影响行数是否大于0

    5.controller ，表现层，包括错误码：Code类 ，错误代码用public static final Integer SAVE_OK = 20011;
                                    Result返回值类，包括    private Object data;private Integer code;private String msg;
                                                      这三个数据，包括两个构造方法，一个是带消息的，一个不带消息的。
                                    BookController ： 有两个类头部注解，一个restcontroller，一个requesrMapping（“/books”）//根地址
                                         *IM  ! 使用自动装配装配BookService
                                              ！！每个方法前都要一个注解，@PostMapping，@PutMapping，@DeleteMapping，@GetMapping
                                                      方法的返回值都是public Result ，返回的都是return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
                                                @PostMapping
                                                public Result save(@RequestBody Book book) {
                                                boolean flag = bookService.save(book);
                                                return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
                                                 }  
                                         *ATT !!!  @RequestBody 接收Json数据，而@PathVariable Integer id是接受key-value里面的参数（@GetMapping("/{id}")），这个里面的id
                                    ProjectExceptionAdvice类，异常处理，里面包括@ExceptionHandler(SystemException.class) @ExceptionHandler(BusinessException.class) @ExceptionHandler(Exception.class)
                                                                  这三个注解前两个来自于目录中exception中的类
    6.exception 和 上面的见源代码  



项目配置重要文件： pom yml 代码生成器（test）  **********非常重要
