# Springboot 实现拦截器 2017-9-30

#### 实现自定义拦截器只需要3步： 

1、创建我们自己的拦截器类并实现 HandlerInterceptor 接口。 

2、创建一个Java类继承WebMvcConfigurerAdapter，并重写 addInterceptors 方法。 

2、实例化我们自定义的拦截器，然后将对像手动添加到拦截器链中（在addInterceptors方法中添加）。


#### 参考链接

[http://blog.csdn.net/catoop/article/details/50501696](http://blog.csdn.net/catoop/article/details/50501696)     


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