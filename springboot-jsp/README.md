# Springboot + jsp
#### 启动方式

- 1. mvn spring-boot:run
- 2. 打包成war，通过 java -jar demo-0.0.1-SNAPSHOT.war启动
    
---
##### 注
*jar包运行的时候会404错误，因为默认jsp不会被拷贝到程序包中，而war包里面有包含了jsp，所以没问题。*

*另外springboot官方并不推荐使用jsp*