�������̣�
��ǩ�� ATT �� attention
      IM  :  important

    1. ��pom�ļ�������druid �ڿ�ʼʱ��Ҫѡ��springboot��mybatis��jdbcûѡ�еĻ���Ҫ��pom������

    2. д��yml����yml��д��໷��������druid���໷���������ö����ͬ�����ݿ����á�

    3. dao�� dao����Ҫ����pojoʵ�����ʵ�����Ӧ��Dao�ӿڡ�
             ʵ������lombok��pom��Ҫ���ã��е�@data����
         BookDao���ӿڣ� �� ͷ��д@Mapperע����ӳ��   *ATT ����ֱ������MP��ֱ�Ӽ̳�BaseMapper<Book>
                        ���� �ڷ�������д@Insert ����ɾ�Ĳ�ע�⣩ 
                         *ATT ������@select��ȫ������int��selectһ������Book��һ������List<Book>
                              !!�����У�save��updata�����Book book ������������дInteger id�Ϳ�
                              ����������ֵԭ������������ص�����Ӱ��������������жϲ����Ƿ�ɹ���
        
    4. service, �����ӿں�impl��
                BookServce�ӿ������BookDao��˵��ֻ�ı��˷���ֵ����int���boolean��ԭ�򣺼�Impl��˵����  
                *IM implʵ����ͷ��д�� @Transactional����
                    ��service���ǩ(һ�㲻�����ڽӿ���)�����@Transactional�����Խ�����������spring�������
                      ��ÿ��ҵ�񷽷�ִ��ʱ���Ὺ��һ�����񣬲�����Щ���������ͬ�Ĺ���ʽ�������ڷ���ʧ��ʱ���Խ��лع���
                    ��������Boolean���ͣ���Ϊ����ֵ��BookDao��Ӱ�������Ƿ����0

    5.controller �����ֲ㣬���������룺Code�� �����������public static final Integer SAVE_OK = 20011;
                                    Result����ֵ�࣬����    private Object data;private Integer code;private String msg;
                                                      ���������ݣ������������췽����һ���Ǵ���Ϣ�ģ�һ��������Ϣ�ġ�
                                    BookController �� ��������ͷ��ע�⣬һ��restcontroller��һ��requesrMapping����/books����//����ַ
                                         *IM  ! ʹ���Զ�װ��װ��BookService
                                              ����ÿ������ǰ��Ҫһ��ע�⣬@PostMapping��@PutMapping��@DeleteMapping��@GetMapping
                                                      �����ķ���ֵ����public Result �����صĶ���return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
                                                @PostMapping
                                                public Result save(@RequestBody Book book) {
                                                boolean flag = bookService.save(book);
                                                return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
                                                 }  
                                         *ATT !!!  @RequestBody ����Json���ݣ���@PathVariable Integer id�ǽ���key-value����Ĳ�����@GetMapping("/{id}")������������id
                                    ProjectExceptionAdvice�࣬�쳣�����������@ExceptionHandler(SystemException.class) @ExceptionHandler(BusinessException.class) @ExceptionHandler(Exception.class)
                                                                  ������ע��ǰ����������Ŀ¼��exception�е���
    6.exception �� ����ļ�Դ����  



��Ŀ������Ҫ�ļ��� pom yml ������������test��  **********�ǳ���Ҫ
