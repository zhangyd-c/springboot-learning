# springboot

#### springboot-schedule  2017-3-10

`@Scheduled` 参数可以接受两种定时的设置，一种是我们常用的`cron="*/1 * * * * ?"`,一种是 `fixedRate = 1000`，两种都表示每隔一秒打印一下内容。

####fixedRate 说明

`@Scheduled(fixedRate = 1000)` ：上一次开始执行时间点之后1秒再执行（固定每1秒执行一次）</br>
`@Scheduled(fixedDelay = 1000)` ：上一次执行完毕后间隔1秒再执行</br>
`@Scheduled(initialDelay=1000, fixedRate=2000)` ：第一次延迟1秒后执行，之后按fixedRate的规则每2秒执行一次</br>

##### 项目中定时使用到cron表达式，详细使用方法，请参考[SpringTask中cron表达式整理记录](http://www.flyat.cc/article/120cd0ed892042e99f0d185ec12af968)

