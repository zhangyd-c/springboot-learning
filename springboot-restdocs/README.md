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