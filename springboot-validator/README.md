# Springboot + validator 2017-10-10

### 前言

> The method validation feature supported by Bean Validation 1.1 is automatically enabled as long as a JSR-303 implementation (e.g. Hibernate validator) is on the classpath. This allows bean methods to be annotated with `javax.validation` constraints on their parameters and/or on their return value. Target classes with such annotated methods need to be annotated with the `@Validated` annotation at the type level for their methods to be searched for inline constraint annotations.

#### 常用注解

> @Null	只能是null   
  @NotNull 不能为null 注意用在基本类型上无效，基本类型有默认初始值   
  @AssertFalse 必须为false   
  @AssertTrue	必须是true   
  
> 字符串/数组/集合检查：(字符串本身就是个数组)   
  @Pattern(regexp="reg") 验证字符串满足正则   
  @Size(max, min) 验证字符串、数组、集合长度范围   
  @NotEmpty 验证字符串不为空或者null   
  @NotBlank 验证字符串不为null或者trim()后不为空   
  
> 数值检查：同时能验证一个字符串是否是满足限制的数字的字符串   
  @Max 规定值得上限int   
  @Min 规定值得下限   	
  @DecimalMax("10.8")	以传入字符串构建一个BigDecimal，规定值要小于这个值    
  @DecimalMin 可以用来限制浮点数大小   
  @Digits(int1, int2) 限制一个小数，整数精度小于int1；小数部分精度小于int2   
  @Digits 无参数，验证字符串是否合法   	
  @Range(min=long1,max=long2) 检查数字是否在范围之间   
  这些都包括边界值   
  
> 日期检查：Date/Calendar   
  @Past 限定一个日期，日期必须是过去的日期   
  @Future 限定一个日期，日期必须是未来的日期   
  
> 其他验证：   
  @Vaild 递归验证，用于对象、数组和集合，会对对象的元素、数组的元素进行一一校验   
  @Email 用于验证一个字符串是否是一个合法的右键地址，空字符串或null算验证通过   
  @URL(protocol=,host=,port=,regexp=,flags=) 用于校验一个字符串是否是合法URL   

#### 注意

@Validated 和 BindingResult 是一一对应的，如果有多个@Validated，那么每个@Validated后面跟着的BindingResult就是这个@Validated的验证结果，顺序不能乱，比如
    
````
@RequestMapping("/saveUser")
public ModelAndView saveUser(@Validated User user, BindingResult userResult, @Validated Other other, BindingResult otherResult, Model model) {
    ......
}
````
userResult对应user实体类的校验结果，otherResult对应other类的校验结果
#### 如下异常
```
HV000030: No validator could be found for constraint 'javax.validation.constraints.Pattern' validating type 'java.lang.Integer'. Check configuration for 'phone'
```
定义属性时将phone类型设置为Integer了， @Pattern只能作用于String类型的属性，所以报上面的错。    


#### 更多...

[https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-validation](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-validation)


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