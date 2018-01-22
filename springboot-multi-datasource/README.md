
[如何集成通用Mapper](http://git.oschina.net/free/Mapper/blob/master/wiki/mapper3/2.Integration.md)

[如何使用通用Mapper](http://git.oschina.net/free/Mapper/blob/master/wiki/mapper3/3.Use.md)


- mapper和pageHelper可以正常使用，不受数据源影响
- 多数据源中使用事务管理时，一定要指定为数据源配置的transactionManager Bean的名字，Transactional源码：

``
    @Target({ElementType.METHOD, ElementType.TYPE})    
    @Retention(RetentionPolicy.RUNTIME)    
    @Inherited     
    @Documented    
    public @interface Transactional {    
        @AliasFor("transactionManager")    
        String value() default "";    
        @AliasFor("value")    
        String transactionManager() default "";    
        ...    
    }
``

-  使用通用mapper需要注意的地方：
    - 实体类中非数据库字段，务必添加上`@Transient`注解！
    - 数据库表、字段名与实体类、属性名默认的转换规则为驼峰-下划线，因此建表时需要注意与实体类之间的命名关系，其他转换规则查阅mapper.style属性
        - normal:使用实体类名/属性名作为表名/字段名
        - camelhump:这是默认值，驼峰转换为下划线形式
        - uppercase:转换为大写
        - lowercase:转换为小写
    - 与数据库对应的实体类的主键一定要显式声明，比如  
    `@Id
     	@GeneratedValue(strategy = GenerationType.IDENTITY)`
     	如果不指定主键的话，会发生意想不到的东西（~~o(>_<)o ~~)
     	详细原因，请查看各个Mapper源码中Provider对应的类中
     	`SqlHelper.wherePKColumns(entityClass)`的详细内容
     	
## 生命不息，折腾不止！
### 更多信息，请关注：
1. [我的博客](http://www.zhyd.me)
2. [我的工具](http://tool.zhyd.me)
3. [我的微博](http://weibo.com/211230415)
4. [我的头条号](http://www.toutiao.com/c/user/3286958681/)
5. [我的mooc](http://www.imooc.com/u/1175248/articles)

### 有任何问题可以
- [new issue](https://github.com/zhangyd-c/springboot/issues)
- [给我留言](http://www.zhyd.me/guestbook)

### 如果喜欢，请多多分享、多多Star