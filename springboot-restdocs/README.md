# Springboot 整合Spring Rest docs
1.Restdocs

#### pom
添加依赖
```
<dependency>
    <groupId>org.springframework.restdocs</groupId>
    <artifactId>spring-restdocs-mockmvc</artifactId>
    <scope>test</scope>
</dependency>
```
添加插件

```
<build>
        <plugins>
            <plugin>
                <groupId>org.asciidoctor</groupId>
                <artifactId>asciidoctor-maven-plugin</artifactId>
                <version>1.5.3</version>
                <executions>
                    <execution>
                        <id>generate-docs</id>
                        <phase>prepare-package</phase>
                        <goals>
                            <goal>process-asciidoc</goal>
                        </goals>
                        <configuration>
                            <sourceDocumentName>index.adoc</sourceDocumentName>
                            <backend>html</backend>
                            <attributes>
                                <snippets>${project.build.directory}/snippets</snippets>
                            </attributes>
                        </configuration>
                    </execution>
                </executions>
                <dependencies>
                    <dependency>
                        <groupId>org.springframework.restdocs</groupId>
                        <artifactId>spring-restdocs-asciidoctor</artifactId>
                        <version>1.2.1.RELEASE</version>
                    </dependency>
                </dependencies>
            </plugin>
        </plugins>
    </build>

```
#### 添加adoc模板
src/main/asciidoc/index.adoc

asciidoc文档语法请参考：[http://asciidoctor.org/docs/asciidoc-syntax-quick-reference](http://asciidoctor.org/docs/asciidoc-syntax-quick-reference)

#### 编写测试文件
src/test/java/com/zyd/AppTest.java


# 其他文档生成工具
2.Swagger2（这个也需要掌握、使用）

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